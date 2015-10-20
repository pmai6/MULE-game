package mule;

import mule.model.*;
import mule.RoundManager;
import mule.StoreManager;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Iterator;
import java.util.List;
import java.io.Serializable;

/**
 * Class to manage player objects
 */
public class PlayerManager implements Serializable{
    private static GameManager gameManager = GameManager.getGameManager();

    private int startTime;
    private mule.view.timer time = new mule.view.timer(startTime);
    private IntegerProperty timeLeft = time.getTimeLeft();

    public static void createNewGamePlayer(String playerName2,
                                            String selectedRace2,
                                            String selectedColor2) {
        Player newplayer = new Player(playerName2, selectedRace2, selectedColor2);
        gameManager.getMulegame().addPlayerToArray(newplayer);
    }


    /**
     * Method to deduct the an amount of money a player spent on land
     * @param player
     * @param property
     */
    public static void buyProperty (Player player, Tile property) {
        player.setMoney(player.getMoney() - MapManager.costOfTile());
        player.addtile(property);

    }

    /** Stub method
     * Method to deduct the an amount of money a player spent
     * @param player
     * @param item
     * @param quantity
     */
    public static void buyResources (Player player, String item, int quantity) {
        if (item.equalsIgnoreCase("food")) {
            player.setFood(player.getFood() + quantity);
            player.setMoney(player.getMoney() - (Store.getFoodPrice() * quantity));
        } else if (item.equalsIgnoreCase("energy")) {
            player.setEnergy(player.getEnergy() + quantity);
            player.setMoney(player.getMoney() - (Store.getEnergyPrice() * quantity));
        } else if (item.equalsIgnoreCase("smithore")) {
            player.setSmithore(player.getSmithore() + quantity);
            player.setMoney(player.getMoney() - (Store.getSmithorePrice() * quantity));
        } else if (item.equals("crystite")) {
            player.setCrystite(player.getCrystite() + quantity);
            player.setMoney(player.getMoney() - (Store.getCrystitePrice() * quantity));
        }
    }

    public static void buyMule (Player player, Mule mule) throws Exception{
        if (player.getMoney() - mule.getCost() >= 0) {
            player.setMoney(player.getMoney() - mule.getCost());
            if (mule.getCost() == 125) {
                Store.setFoodMuleQty(Store.getFoodMuleQty() - 1);
            } else if (mule.getCost() == 150) {
                Store.setEnergyMuleQty(Store.getEnergyMuleQty() - 1);
            } else if (mule.getCost() == 175) {
                Store.setSmithoreMuleQty(Store.getSmithoreMuleQty() - 1);
            } else {
                Store.setCrystiteMuleQty(Store.getCrystiteMuleQty() - 1);
            }
            GameManager.getGameManager().updateStoreData();
            player.setUnplacedMule(mule);
            gameManager.placeMule();
        } else {
            gameManager.notEnoughMoney();
        }
    }
    /**
     * void method - add money to the account of the player
     * @param player - current player
     * @param item - item sold
     * @param quantity - amount sold
     */
    public static void sellResources (Player player, String item ,int quantity) {
        //
        if (item.equalsIgnoreCase("food")) {
            player.setFood(player.getFood() - quantity);
            player.setMoney(player.getMoney() + (Store.getFoodPrice() * quantity));
        } else if (item.equalsIgnoreCase("energy")) {
            player.setEnergy(player.getEnergy() - quantity);
            player.setMoney(player.getMoney() + (Store.getEnergyPrice() * quantity));
        } else if (item.equalsIgnoreCase("smithore")) {
            player.setSmithore(player.getSmithore() - quantity);
            player.setMoney(player.getMoney() + (Store.getSmithoreQty() * quantity));
        } else if (item.equals("crystite")) {
            player.setCrystite(player.getCrystite() - quantity);
            player.setMoney(player.getMoney() + (Store.getCrystitePrice() * quantity));
        }
    }

    /**
     * stub method - player starts his turn
     * @param player - player who has current turn
     * @param startTimer - time in player's turn which is determined by his score
     */
    public void startTurn(Player player, int startTimer) {
        mule.model.Round.getCurrentTurn().setPlayer(player);
        startTime = startTimer;
        time.startTimer();
    }


    public IntegerProperty getTimeLeftProperty() { return timeLeft; } // get time remaining in the
                                                                      // player's turn
    public int getTimeLeft() { return timeLeft.get(); }

    /**
     * stub method - player's turn ends when gambling
     */
    public void gambleInPub () {
        Pub.gamble(RoundManager.getCurrentPlayer(), timeLeft.get(), mule.model.Round.getRoundNum());
        //this method is all that needs to be called to finish a turn
        //the parameter tells you whether the turn is ending b/c a player
        //passed or because of something other than that
        RoundManager.playerFinishedTurn(false);

    }

    public static void calculatePlayerProduction() {
        Player currentPlayer = RoundManager.getCurrentPlayer();
        List<Tile> tiles = currentPlayer.getTiles();
        Iterator<Tile> tileIterator = tiles.iterator();
        System.out.println(currentPlayer.getTotalNumberOfMules());
        System.out.println(currentPlayer.getEnergy());
        if(currentPlayer.getEnergy() >= currentPlayer.getTotalNumberOfMules()) {
            PlayerManager.subPlayerEnergy(currentPlayer, currentPlayer.getTotalNumberOfMules());
            while (tileIterator.hasNext()) {
                tileIterator.next().calculateProduction();
            }
        } else {
            System.out.println("insufficient amount of energy");
        }
    }

    public static void calculatePlayerTurnRandomEvent() {
        String lowestScorePlayerName = gameManager.getSortedPlayerArray().get(0).getPlayerName();
        String currentPlayerName = RoundManager.getCurrentPlayer().getPlayerName();
        String event;
        if(Math.random() < .27) {
            //if current player isnt the player with the lowest score
            if(lowestScorePlayerName.compareToIgnoreCase(currentPlayerName) == 0)
                event = RandomEvent.getAllTurnRandomEventsEvent();
            else
                event = RandomEvent.getGoodTurnRandomEventsEvent();
            RandomEvent.callTurnRandomEvent(event);
        } else {
                System.out.println("no random event will occur");
            }
    }

    public static void calculatePlayerRoundRandomEvent() {
        String event;
        if(Math.random() < .2) {
            event = RandomEvent.getRoundRandomEventsEvent();
            RandomEvent.callRoundRandomEvent(event);

        }
        else
            System.out.println("no random event will occur");
    }

    public static void addPlayerFood(Player player, int amount) {
        int currentFoodQty = player.getFood();
        int newFoodQty = currentFoodQty + amount;
        player.setFood(newFoodQty);
    }

    public static void addPlayerEnergy(Player player, int amount) {
        int currentEnergyQty = player.getEnergy();
        int newEnergyQty = currentEnergyQty + amount;
        player.setEnergy(newEnergyQty);
    }

    public static void addPlayerSmithore(Player player, int amount) {
        int currentSmithoreQty = player.getSmithore();
        int newSmithoreQty = currentSmithoreQty + amount;
        player.setSmithore(newSmithoreQty);
    }

    public static void addPlayerCrystite(Player player, int amount) {
        int currentCrystiteQty = player.getCrystite();
        int newCrystiteQty = currentCrystiteQty + amount;
        player.setSmithore(newCrystiteQty);
    }

    public static void addPlayerMoney(Player player, int amount) {
        int currentMoneyQty = player.getMoney();
        int newMoneyQty = currentMoneyQty + amount;
        player.setMoney(newMoneyQty);
    }

//    public static void addPlayerEnergyMule(Player player, int amount) throws Exception{
//        int currentEnergyMuleQty = player.getenergyMule();
//        int newEnergyMuleQty = currentEnergyMuleQty + amount;
//        player.setEnergyMule(newEnergyMuleQty);
//        for (int m = 0; m < amount; m++) {
//            Mule mule = new EnergyMule();
//            player.setUnplacedMule(mule);
//            gameManager.placeMule();
//        }
//    }
//
//    public static void addPlayerUnicornMule(Player player, int amount) throws Exception{
//        int currentUnicornMuleQty = player.getUnicornMule();
//        int newUnicornMuleQty = currentUnicornMuleQty + amount;
//        player.setUnicornMule(newUnicornMuleQty);
//        for (int m = 0; m < amount; m++) {
//            Mule mule = new UnicornMule();
//            player.setUnplacedMule(mule);
//            gameManager.placeMule();
//        }
//    }

    public static void addPlayerMule (Player player, String muleName, int amount) throws Exception{
        for (int i = 0; i < amount; i++) {
            if (muleName.equals("Energy Mule")){
                Mule mule = new EnergyMule();
                player.setUnplacedMule(mule);
                gameManager.placeMule();
            } else if (muleName.equals("Unicorn Mule")){
                Mule mule = new UnicornMule();
                player.setUnplacedMule(mule);
                gameManager.placeMule();
            } else if (muleName.equals("Ore Mule")) {
                Mule mule = new SmithoreMule();
                player.setUnplacedMule(mule);
                gameManager.placeMule();
            } else if (muleName.equals("Crystite Mule")) {
                Mule mule = new CrystiteMule();
                player.setUnplacedMule(mule);
                gameManager.placeMule();
            } else {
                Mule mule = new FoodMule();
                player.setUnplacedMule(mule);
                gameManager.placeMule();
            }
        }
    }

    public static void subPlayerFood(Player player, int amount) {
        int currentFoodQty = player.getFood();
        int newFoodQty = currentFoodQty - amount;
        player.setFood(newFoodQty);
    }

    public static void subPlayerEnergy(Player player, int amount) {
        int currentEnergyQty = player.getEnergy();
        int newEnergyQty = currentEnergyQty - amount;
        player.setEnergy(newEnergyQty);
    }

    public static void subPlayerSmithore(Player player, int amount) {
        int currentSmithoreQty = player.getSmithore();
        int newSmithoreQty = currentSmithoreQty - amount;
        player.setSmithore(newSmithoreQty);
    }

    public static void subPlayerCrystite(Player player, int amount) {
        int currentCrystiteQty = player.getCrystite();
        int newCrystiteQty = currentCrystiteQty - amount;
        player.setSmithore(newCrystiteQty);
    }

    public static void subPlayerMoney(Player player, int amount) {
        int currentMoneyQty = player.getMoney();
        int newMoneyQty = currentMoneyQty - amount;
        player.setMoney(newMoneyQty);
    }

    public static void addFoodToAllPlayers(int food) {
        Iterator<Player> playerIterator = getPlayerList().iterator();
            while (playerIterator.hasNext()) {
                addPlayerFood(playerIterator.next(),food);
            }
    }

    public static void addEnergyToAllPlayers(int energy) {
        Iterator<Player> playerIterator = getPlayerList().iterator();
        while (playerIterator.hasNext()) {
            addPlayerEnergy(playerIterator.next(), energy);
        }
    }

    public static void addSmithoreToAllPlayers(int smithore) {
        Iterator<Player> playerIterator = getPlayerList().iterator();
        while (playerIterator.hasNext()) {
            addPlayerSmithore(playerIterator.next(), smithore);
        }
    }
    public static void subFoodToAllPlayers(int food) {
        Iterator<Player> playerIterator = getPlayerList().iterator();
        while (playerIterator.hasNext()) {
            subPlayerFood(playerIterator.next(), food);
        }
    }

    public static void subEnergyToAllPlayers(int energy) {
        Iterator<Player> playerIterator = getPlayerList().iterator();
        while (playerIterator.hasNext()) {
            subPlayerEnergy(playerIterator.next(), energy);
        }
    }

    public static void subSmithoreToAllPlayers(int smithore) {
        Iterator<Player> playerIterator = getPlayerList().iterator();
        while (playerIterator.hasNext()) {
            subPlayerSmithore(playerIterator.next(), smithore);
        }
    }


    public static List<Player> getPlayerList() {
        List<Player> allPlayers = gameManager.getSortedPlayerArray();
        return allPlayers;
    }

    public static void subPlayerMule (Player player, String muleName, int amount) throws Exception{
        for (int i = 0; i < amount; i++) {
            if (muleName.equals("Energy Mule")){
                int currentEnergyMuleQty = player.getenergyMule();
                int newEnergyMuleQty = currentEnergyMuleQty - amount;
                player.setEnergyMule(newEnergyMuleQty);
            } else if (muleName.equals("Unicorn Mule")){
                int currentUnicornMuleQty = player.getUnicornMule();
                int newUnicornMuleQty = currentUnicornMuleQty - amount;
                player.setOreMule(newUnicornMuleQty);
            } else if (muleName.equals("Ore Mule")) {
                int currentSmithoreMuleQty = player.getOreMule();
                int newEnergyMuleQty = currentSmithoreMuleQty - amount;
                player.setOreMule(newEnergyMuleQty);
            } else if (muleName.equals("Crystite Mule")) {
                int currentCrystiteMuleQty = player.getCrystiteMule();
                int newCrystiteMuleQty = currentCrystiteMuleQty - amount;
                player.setCrystiteMule(newCrystiteMuleQty);
            } else {
                int currentFoodMuleQty = player.getFoodMule();
                int newFoodMuleQty = currentFoodMuleQty - amount;
                player.setFoodMule(newFoodMuleQty);
            }
        }
    }
}
