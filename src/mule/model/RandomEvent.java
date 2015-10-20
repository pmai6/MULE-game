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
///        7.KATRINA_SWEPT_ALL (bad event) - ($3*m, 1 energyMules)
///        8.GA_HOT_BOWL (bad event) - (5 food, 2 SmithoreMules)
///        9.GENIE_GRANT_GIFT (good event) + ($3*m, 10 food, 2 mules)
///        10.UNICORN_WANDER_LOST (good event) + ($6*m, 1 special unicornMule, 2 energy, 2 food, 3 smithore, 3 crystite)
///        11.GT_HOMECOMING (good event) + (1 energy, 4 crystite)
///        12.TEST_WEEK_MESS (bad event) - ($2*m, 3 energy)
    public static void callTurnRandomEvent(String event) {
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
            case "KATRINA_SWEPT_ALL":
                PlayerManager.subPlayerMoney(currentPlayer,3*m);
                try {
                    PlayerManager.subPlayerMule(currentPlayer, "Energy Mule", 1);
                } catch (Exception n) {
                    System.out.println("Mule does not exists");
                }
                break;
            case "GA_HOT_BOWL":
                PlayerManager.subPlayerFood(currentPlayer, 5);
                try {
                    PlayerManager.subPlayerMule(currentPlayer, "Smithore Mule", 2);
                } catch (Exception n) {
                    System.out.println("Mule does not exists");
                }
                break;
            case "GENIE_GRANT_GIFT":
                PlayerManager.addPlayerMoney(currentPlayer,3*m);
                PlayerManager.addPlayerFood(currentPlayer, 10);
                try {
                    PlayerManager.addPlayerMule(currentPlayer, "Energy Mule", 2);
                } catch (Exception n) {
                    System.out.println("Mule does not exists");
                }
                break;
            case "UNICORN_WANDER_LOST":
                PlayerManager.addPlayerMoney(currentPlayer, 6*m);
                PlayerManager.addPlayerFood(currentPlayer, 10);
                PlayerManager.addPlayerEnergy(currentPlayer, 2);
                PlayerManager.addPlayerSmithore(currentPlayer, 3);
                PlayerManager.addPlayerCrystite(currentPlayer, 3);
                try {
                    PlayerManager.addPlayerMule(currentPlayer, "Unicorn Mule", 1);
                } catch (Exception n) {
                    System.out.println("Mule does not exists");
                }
                break;
            case "GT_HOMECOMING":
                PlayerManager.addPlayerCrystite(currentPlayer, 4);
                PlayerManager.addPlayerEnergy(currentPlayer,1);
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
                "ATE_ROOF", "STOLE_HALF_FOOD", "GYPSY_INLAWS_MESS", "KATRINA_SWEPT_ALL", "GA_HOT_BOWL",
                "GENIE_GRANT_GIFT", "UNICORN_WANDER_LOST","GT_HOMECOMING", "TEST_WEEK_MESS"};
        int allRandomEventsIndex = (int)(Math.random() * allRandomEvents.length);
        return allRandomEvents[allRandomEventsIndex];
    }

    public static String getGoodRandomEventsEvent() {
        final String[] goodRandomEvents = {"RCVD_GT_PACK","REPAID_HOSPITALITY","BOUGHT_ANTIQUE_CPU","SOLD_RAT",
                "GENIE_GRANT_GIFT", "UNICORN_WANDER_LOST","GT_HOMECOMING"};
        int goodRandomEventsIndex = (int)(Math.random() * goodRandomEvents.length);
        return goodRandomEvents[goodRandomEventsIndex];
    }
}
