package mule;

import mule.model.Player;
import mule.model.Tile;

/**
 * Class to manage player objects
 */
public class PlayerManager {
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
     * stub method - player's turn ends when gambling
     * @param player - player who currently gamble
     */
    public static void gambleInPub (Player player) {
        //Pub.gamble(player, some sort of timer, mule.model.Round.getRoundNum());
        //mule.model.Round.getCurrentTurn().endTurn();

        //this method is all that needs to be called to finish a turn
        //the parameter tells you whether the turn is ending b/c a player
        //passed or because of something other than that
        RoundManager.playerFinishedTurn(false);
    }
}
