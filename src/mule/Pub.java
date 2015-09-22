package mule;
/**
 * Created by redcream12 on 9/18/15.
 */
import mule.model.Player;

import java.util.Random;

public class Pub {

    public void gamble(Player player, int turnTime, int roundNum) {
        int [] roundBonus = new int []{50, 100, 150, 200};
        Random rand = new Random();
        int moneyBonus = 0;
        int timeBonus = 0;

        if (turnTime <= 50 && turnTime >= 37) { timeBonus = roundBonus[3]; }
        else if (turnTime < 38 && turnTime > 24) { timeBonus = roundBonus[2]; }
        else if (turnTime < 26 && turnTime > 11) { timeBonus = roundBonus[1]; }
        else if (turnTime < 13 && turnTime >= 0) { timeBonus = roundBonus[0]; }

        while (moneyBonus <= 250) { // player cannot earn more than 250 in one gamebling
            // round 1 - 3
            if (roundNum > 0 && roundNum < 4) { moneyBonus = roundBonus[0] * rand.nextInt(timeBonus); }
            // round 4 - 7
            if (roundNum < 5 && roundNum < 8) { moneyBonus = roundBonus[1] * rand.nextInt(timeBonus); }
            // round 8 - 11
            if (roundNum < 9 && roundNum < 12) { moneyBonus = roundBonus[2] * rand.nextInt(timeBonus); }
            // round 12
            if (roundNum == 12) { moneyBonus = roundBonus[3] * rand.nextInt(timeBonus); }
        }

    }
}
