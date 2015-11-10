package mule;

import mule.model.*;
import mule.RoundManager;
import javafx.beans.property.IntegerProperty;

import java.util.Iterator;
import java.util.List;
import java.io.Serializable;

/**
 * The type Player manager.
 */
public class PlayerManager implements Serializable {
    /**
     * The constant gameManager.
     */
    private static GameManager gameManager = GameManager.getGameManager();

    /**
     * The Start time.
     */
    private int startTime;
    /**
     * The Time.
     */
    private mule.view.Timer time = new mule.view.Timer(startTime);
    /**
     * The Time left.
     */
    private IntegerProperty timeLeft = time.getTimeLeft();

    /**
     * Create new game player.
     *
     * @param playerName2    the player name 2
     * @param selectedRace2  the selected race 2
     * @param selectedColor2 the selected color 2
     */
    public static void createNewGamePlayer(String playerName2,
                                            String selectedRace2,
                                            String selectedColor2) {
        Player newplayer = new Player(playerName2, selectedRace2, selectedColor2);
        gameManager.getMulegame().addPlayerToArray(newplayer);
    }


    /**
     * Buy resources.
     *
     * @param player   the player
     * @param item     the item
     * @param quantity the quantity
     */
    public static void buyResources (Player player, String item, int quantity) {
        if (item.equalsIgnoreCase("food")) {
            player.setFood(player.getFood() + quantity);
            player.setMoney(player.getMoney() - (gameManager.getGameStore().getFoodPrice
                    () *
                    quantity));
        } else if (item.equalsIgnoreCase("energy")) {
            player.setEnergy(player.getEnergy() + quantity);
            player.setMoney(player.getMoney() - (gameManager.getGameStore().getEnergyPrice() * quantity));
        } else if (item.equalsIgnoreCase("smithore")) {
            player.setSmithore(player.getSmithore() + quantity);
            player.setMoney(player.getMoney() - (gameManager.getGameStore().getSmithorePrice() * quantity));
        } else if (item.equals("crystite")) {
            player.setCrystite(player.getCrystite() + quantity);
            player.setMoney(player.getMoney() - (gameManager.getGameStore().getCrystitePrice() * quantity));
        }
    }

    /**
     * Buy mule.
     *
     * @param player the player
     * @param mule   the mule
     * @throws Exception the exception
     */
    public static void buyMule (Player player, Mule mule) throws Exception{
        if (player.getMoney() - mule.getCost() >= 0) {
            player.setMoney(player.getMoney() - mule.getCost());
            if (mule.getCost() == 125) {
                gameManager.getGameStore().setFoodMuleQty(gameManager.getGameStore()
                        .getFoodMuleQty() - 1);
            } else if (mule.getCost() == 150) {
                gameManager.getGameStore().setEnergyMuleQty(gameManager.getGameStore()
                        .getEnergyMuleQty() - 1);
            } else if (mule.getCost() == 175) {
                gameManager.getGameStore().setSmithoreMuleQty(gameManager.getGameStore()
                        .getSmithoreMuleQty() - 1);
            } else {
                gameManager.getGameStore().setCrystiteMuleQty(gameManager.getGameStore()
                        .getCrystiteMuleQty() - 1);
            }
            GameManager.getGameManager().updateStoreData();
            player.setUnplacedMule(mule);
            gameManager.placeMule();
        } else {
            gameManager.notEnoughMoney();
        }
    }

    /**
     * Sell resources.
     *
     * @param player   the player
     * @param item     the item
     * @param quantity the quantity
     */
    public static void sellResources (Player player, String item ,int quantity) {
        //
        if (item.equalsIgnoreCase("food")) {
            player.setFood(player.getFood() - quantity);
            player.setMoney(player.getMoney() + (gameManager.getGameStore().getFoodPrice() * quantity));
        } else if (item.equalsIgnoreCase("energy")) {
            player.setEnergy(player.getEnergy() - quantity);
            player.setMoney(player.getMoney() + (gameManager.getGameStore().getEnergyPrice() * quantity));
        } else if (item.equalsIgnoreCase("smithore")) {
            player.setSmithore(player.getSmithore() - quantity);
            player.setMoney(player.getMoney() + (gameManager.getGameStore().getSmithoreQty() * quantity));
        } else if (item.equals("crystite")) {
            player.setCrystite(player.getCrystite() - quantity);
            player.setMoney(player.getMoney() + (gameManager.getGameStore().getCrystitePrice() * quantity));
        }
    }

    /**
     * Gets time left property.
     *
     * @return the time left property
     */
    public IntegerProperty getTimeLeftProperty() { return timeLeft; } // get time remaining in the

    /**
     * Gets time left.
     *
     * @return the time left
     */
// player's turn
    public int getTimeLeft() { return timeLeft.get(); }

    /**
     * Gamble in pub.
     */
    public void gambleInPub () {
        Pub.gamble(RoundManager.getCurrentPlayer(), timeLeft.get(),
                GameManager.getGameManager().getMulegame().getRound()
                .getRoundNum());
        //this method is all that needs to be called to finish a turn
        //the parameter tells you whether the turn is ending b/c a player
        //passed or because of something other than that
        RoundManager.playerFinishedTurn(false);

    }

    /**
     * Calculate player production.
     */
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

    /**
     * Calculate player turn random event.
     */
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

    /**
     * Calculate player round random event.
     */
    public static void calculatePlayerRoundRandomEvent() {
        String event;
        if(Math.random() < .2) {
            event = RandomEvent.getRoundRandomEventsEvent();
            RandomEvent.callRoundRandomEvent(event);

        }
        else
            System.out.println("no random event will occur");
    }

    /**
     * Add player food.
     *
     * @param player the player
     * @param amount the amount
     */
    public static void addPlayerFood(Player player, int amount) {
        int currentFoodQty = player.getFood();
        int newFoodQty = currentFoodQty + amount;
        player.setFood(newFoodQty);
    }

    /**
     * Add player energy.
     *
     * @param player the player
     * @param amount the amount
     */
    public static void addPlayerEnergy(Player player, int amount) {
        int currentEnergyQty = player.getEnergy();
        int newEnergyQty = currentEnergyQty + amount;
        player.setEnergy(newEnergyQty);
    }

    /**
     * Add player smithore.
     *
     * @param player the player
     * @param amount the amount
     */
    public static void addPlayerSmithore(Player player, int amount) {
        int currentSmithoreQty = player.getSmithore();
        int newSmithoreQty = currentSmithoreQty + amount;
        player.setSmithore(newSmithoreQty);
    }

    /**
     * Add player crystite.
     *
     * @param player the player
     * @param amount the amount
     */
    public static void addPlayerCrystite(Player player, int amount) {
        int currentCrystiteQty = player.getCrystite();
        int newCrystiteQty = currentCrystiteQty + amount;
        player.setSmithore(newCrystiteQty);
    }

    /**
     * Add player money.
     *
     * @param player the player
     * @param amount the amount
     */
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

    /**
     * Add player mule.
     *
     * @param player   the player
     * @param muleName the mule name
     * @param amount   the amount
     * @throws Exception the exception
     */
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

    /**
     * Sub player food.
     *
     * @param player the player
     * @param amount the amount
     */
    public static void subPlayerFood(Player player, int amount) {
        int currentFoodQty = player.getFood();
        int newFoodQty = currentFoodQty - amount;
        player.setFood(newFoodQty);
    }

    /**
     * Sub player energy.
     *
     * @param player the player
     * @param amount the amount
     */
    public static void subPlayerEnergy(Player player, int amount) {
        int currentEnergyQty = player.getEnergy();
        int newEnergyQty = currentEnergyQty - amount;
        player.setEnergy(newEnergyQty);
    }

    /**
     * Sub player smithore.
     *
     * @param player the player
     * @param amount the amount
     */
    public static void subPlayerSmithore(Player player, int amount) {
        int currentSmithoreQty = player.getSmithore();
        int newSmithoreQty = currentSmithoreQty - amount;
        player.setSmithore(newSmithoreQty);
    }

    /**
     * Sub player crystite.
     *
     * @param player the player
     * @param amount the amount
     */
    public static void subPlayerCrystite(Player player, int amount) {
        int currentCrystiteQty = player.getCrystite();
        int newCrystiteQty = currentCrystiteQty - amount;
        player.setSmithore(newCrystiteQty);
    }

    /**
     * Sub player money.
     *
     * @param player the player
     * @param amount the amount
     */
    public static void subPlayerMoney(Player player, int amount) {
        int currentMoneyQty = player.getMoney();
        int newMoneyQty = currentMoneyQty - amount;
        player.setMoney(newMoneyQty);
    }

    /**
     * Add food to all players.
     *
     * @param food the food
     */
    public static void addFoodToAllPlayers(int food) {
        Iterator<Player> playerIterator = getPlayerList().iterator();
            while (playerIterator.hasNext()) {
                addPlayerFood(playerIterator.next(),food);
            }
    }

    /**
     * Add energy to all players.
     *
     * @param energy the energy
     */
    public static void addEnergyToAllPlayers(int energy) {
        Iterator<Player> playerIterator = getPlayerList().iterator();
        while (playerIterator.hasNext()) {
            addPlayerEnergy(playerIterator.next(), energy);
        }
    }

    /**
     * Add smithore to all players.
     *
     * @param smithore the smithore
     */
    public static void addSmithoreToAllPlayers(int smithore) {
        Iterator<Player> playerIterator = getPlayerList().iterator();
        while (playerIterator.hasNext()) {
            addPlayerSmithore(playerIterator.next(), smithore);
        }
    }

    /**
     * Sub food to all players.
     *
     * @param food the food
     */
    public static void subFoodToAllPlayers(int food) {
        Iterator<Player> playerIterator = getPlayerList().iterator();
        while (playerIterator.hasNext()) {
            subPlayerFood(playerIterator.next(), food);
        }
    }

    /**
     * Sub energy to all players.
     *
     * @param energy the energy
     */
    public static void subEnergyToAllPlayers(int energy) {
        Iterator<Player> playerIterator = getPlayerList().iterator();
        while (playerIterator.hasNext()) {
            subPlayerEnergy(playerIterator.next(), energy);
        }
    }

    /**
     * Sub smithore to all players.
     *
     * @param smithore the smithore
     */
    public static void subSmithoreToAllPlayers(int smithore) {
        Iterator<Player> playerIterator = getPlayerList().iterator();
        while (playerIterator.hasNext()) {
            subPlayerSmithore(playerIterator.next(), smithore);
        }
    }


    /**
     * Gets player list.
     *
     * @return the player list
     */
    public static List<Player> getPlayerList() {
        List<Player> allPlayers = gameManager.getSortedPlayerArray();
        return allPlayers;
    }

    /**
     * Sub player mule.
     *
     * @param player   the player
     * @param muleName the mule name
     * @param amount   the amount
     * @throws Exception the exception
     */
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
