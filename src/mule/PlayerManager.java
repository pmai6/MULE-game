package mule;

import mule.model.Player;
import mule.model.Tile;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Class to manage player objects
 */
public class PlayerManager {
    private int startTime;
    private mule.view.timer time = new mule.view.timer(startTime);
    private IntegerProperty timeLeft = time.getTimeLeft();

    /** Stub method
     * Method to deduct the an amount of money a player spent on land
     * @param player
     * @param property
     */
    public static void buyProperty (Player player, Tile property) {
        player.setMoney(player.getMoney() - MapManager.costOfTile());
        player.addtile(property);

    }

//    /** Stub method
//     * Method to deduct the an amount of money a player spent
//     * @param player
//     * @param item
//     * @param quantity
//     * @return true if able to do the method
//     */
//    public static void boughtsomething (Player player, String item, int quantity) {
//        if (item.equalsIgnoreCase("food")) {
//            player.getFood() = player.getFood() + (Store.getFood() * quantity);
//            player.getMoney() = player.getMoney() - (Store.getFood() * quantity);
//            Store.getFood() = Store.getFood() - (Store.getFood() * quantity);
//        } else if (item.equalsIgnoreCase("energy")) {
//            player.getEnergy() = player.getEnergy() + (Store.getEnergy() * quantity);
//            player.getMoney() = player.getMoney() - (Store.getEnergy() * quantity);
//            Store.getEnergy() = Store.getEnergy() - (Store.getEnergy() * quantity);
//        } else if (item.equalsIgnoreCase("smithore")) {
//            player.getSmithore() = player.getSmithore() + (Store.getSmithore() * quantity);
//            player.getMoney() = player.getMoney() - (Store.getSmithore() * quantity);
//            Store.getSmithore() = Store.getSmithore() - (Store.getSmithore() * quantity);
//        } else if (item.equals("crystite")) {
//            player.getCrystite() = player.getFood() + (Store.getCrystite() * quantity);
//            player.getMoney() = player.getMoney() - (Store.getCrystite() * quantity);
//            Store.getCrystite() = Store.getCrystite() - (Store.getCrystite() * quantity);
//        }
//    }


    /**
     * void method - add to the account of the player
     * @param player - player object
     * @param amountOfSale
     */
    public void sellSomething (Player player, double amountOfSale) {
        //TODO
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

//    /**
//     * stub method - player's score is calculated
//     */
//    public int getScore() {
//        RoundManager.getCurrentPlayer().getFood();
//
//    }

    public IntegerProperty getTimeLeftProperty() { return timeLeft; }

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
}
