package mule.model;

import mule.PlayerManager;
import mule.RoundManager;

/**
 * Created by ryyanj on 10/17/15.
 */
public class RandomEvent {

    //round event rules
///        1.RCVD_GT_PACKAGE + (3 food, 2 energy)
///        2.REPAID_HOSPITALITY + (2 Smithore)
///        3.BOUGHT_ANTIQUE_CPU + ($8*m)
///        4.SOLD_RAT + ($2*m)
///        5.ATE_ROOF (bad event) - ($4*m)
///        6.STOLE_HALF_FOOD (bad event) - (.5 * food)
///        7.GYPSY_INLAWS_MESS (bad event) - ($6*m)
    public static void callRandomEvent(String event) {
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int m = getM(Round.getRoundNum());
        switch(event) {
            case "RCVD_GT_PACK":
                PlayerManager.addPlayerFood(currentPlayer, 3);
                PlayerManager.addPlayerEnergy(currentPlayer,2);
                break;
            case "REPAID_HOSPITALITY":
                PlayerManager.addPlayerSmithore(currentPlayer,2);
                break;
            case "BOUGHT_ANTIQUE_CPU":
                PlayerManager.addPlayerMoney(currentPlayer,8*m);
                break;
            case "SOLD_RAT":
                PlayerManager.addPlayerMoney(currentPlayer,2*m);
                break;
            case "ATE_ROOF":
                PlayerManager.subPlayerMoney(currentPlayer,4*m);
                break;
            case "STOLE_HALF_FOOD":
                PlayerManager.subPlayerFood(currentPlayer, (int) .5 * currentPlayer.getFood());
                break;
            case "GYPSY_INLAWS_MESS":
                PlayerManager.subPlayerMoney(currentPlayer,6*m);
                break;
            default:
                throw new IllegalArgumentException("Invalid random event " + event);
        }
    }

    private static int getM(int currRoundNum) {
        if(currRoundNum > 0 && currRoundNum < 4) {
            return 25;
        }
        else if (currRoundNum > 3 && currRoundNum < 8) {
            return 50;
        }
        else if (currRoundNum > 7 && currRoundNum < 12) {
            return 75;
        }
        else
            return 100;
    }

}
