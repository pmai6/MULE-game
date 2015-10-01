package mule;
/**
 * Created by redcream12 on 9/18/15.
 */
import mule.model.Player;

import java.util.Random;

public class Pub {
    private int gamblingMoney = 0;

    /**Player gambles in pub and receive appropriate money
     * @param player player who gambles
     * @param turnTimeLeft player's unused time in their turn
     * @param roundNum current round number
     */
    public static void gamble(Player player, int turnTimeLeft, int roundNum) {
        int [] roundBonus = new int []{50, 100, 150, 200};
        Random rand = new Random();
        int moneyBonus = 0;
        int timeBonus = 0;

        if (turnTimeLeft <= 50 && turnTimeLeft >= 37) { timeBonus = roundBonus[3]; }
        else if (turnTimeLeft < 38 && turnTimeLeft > 24) { timeBonus = roundBonus[2]; }
        else if (turnTimeLeft < 26 && turnTimeLeft > 11) { timeBonus = roundBonus[1]; }
        else if (turnTimeLeft < 13 && turnTimeLeft >= 0) { timeBonus = roundBonus[0]; }


        // round 1 - 3
        if (roundNum > 0 && roundNum < 4) { moneyBonus = roundBonus[0] + rand.nextInt(timeBonus); }
        // round 4 - 7
        if (roundNum < 5 && roundNum < 8) { moneyBonus = roundBonus[1] + rand.nextInt(timeBonus); }
        // round 8 - 11
        if (roundNum < 9 && roundNum < 12) { moneyBonus = roundBonus[2] + rand.nextInt(timeBonus); }
        // round 12
        if (roundNum == 12) { moneyBonus = roundBonus[3] + rand.nextInt(timeBonus); }
        
        if (moneyBonus <= 250) { player.setMoney(player.getMoney() + moneyBonus); } // player cannot earn more than 250 a gambling
        else { System.out.println("You earn more than the amount allowed. Sorry, no clover!!"); }
    }
}
