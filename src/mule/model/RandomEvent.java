package mule.model;

import mule.GameManager;
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
    public static void callTurnRandomEvent(String event) {
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int m = getM(Round.getRoundNum());
        switch(event) {
            case "RCVD_GT_PACK":
                PlayerManager.addPlayerFood(currentPlayer, 3);
                PlayerManager.addPlayerEnergy(currentPlayer, 2);
                GameManager.notifyRandomEvent("YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.");
                break;
            case "REPAID_HOSPITALITY":
                PlayerManager.addPlayerSmithore(currentPlayer,2);
                GameManager.notifyRandomEvent("WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.");
                break;
            case "BOUGHT_ANTIQUE_CPU":
                PlayerManager.addPlayerMoney(currentPlayer,8*m);
                GameManager.notifyRandomEvent("THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $ 8*m");
                break;
            case "SOLD_RAT":
                PlayerManager.addPlayerMoney(currentPlayer,2*m);
                GameManager.notifyRandomEvent("YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $2*m");
                break;
            case "ATE_ROOF":
                PlayerManager.subPlayerMoney(currentPlayer,4*m);
                GameManager.notifyRandomEvent("FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $4*m");
                break;
            case "STOLE_HALF_FOOD":
                PlayerManager.subPlayerFood(currentPlayer, (int) .5 * currentPlayer.getFood());
                GameManager.notifyRandomEvent("MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.");
                break;
            case "GYPSY_INLAWS_MESS":
                PlayerManager.subPlayerMoney(currentPlayer,6*m);
                GameManager.notifyRandomEvent("GYPSY_INLAWS_MESS");
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

    public static String getAllRandomEventsEvent() {
        final String[] allRandomEvents = {"RCVD_GT_PACK","REPAID_HOSPITALITY","BOUGHT_ANTIQUE_CPU","SOLD_RAT",
                "ATE_ROOF", "STOLE_HALF_FOOD", "GYPSY_INLAWS_MESS"};
        int allRandomEventsIndex = (int)(Math.random() * allRandomEvents.length);
        return allRandomEvents[allRandomEventsIndex];
    }

    public static String getGoodRandomEventsEvent() {
        final String[] goodRandomEvents = {"RCVD_GT_PACK","REPAID_HOSPITALITY","BOUGHT_ANTIQUE_CPU","SOLD_RAT"};
        int goodRandomEventsIndex = (int)(Math.random() * goodRandomEvents.length);
        return goodRandomEvents[goodRandomEventsIndex];
    }
}
