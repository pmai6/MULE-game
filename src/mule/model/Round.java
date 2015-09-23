package mule.model;

/**
 * Created by ryyanj on 9/20/15.
 */

        import java.lang.reflect.Array;
        import java.util.ArrayList;;

public class Round {

    private static ArrayList<Turn> roundTurns;
    private static int roundNum;
    private static int turnNum;
    private static int numPasses;

    public static int getNumPasses() {
        return numPasses;
    }

    //initialize proper number of turns based on number of players
    public static void createTurns() {
        roundTurns = new ArrayList<Turn>(Game.getNumberOfPlayers());
        roundNum = 1;
        turnNum = 0;
    }

    public static boolean isRoundOver() {
        //round is over if all turns are done
        Turn lastTurn = roundTurns.get(roundTurns.size()-1);
        if( lastTurn.isTurnOver() ) {
            return true;
        }
        return false;
    }

    //returns the current turn number
    public static int getTurnNum() {
        return turnNum;
    }

    //returns the current turn object
    public static Turn getCurrentTurn() {
        return roundTurns.get(turnNum);
    }

    public static int getRoundNum() {
        return roundNum;
    }

    public static void setRoundNum(int num) {
        roundNum = num;
    }

    public static void setTurnNum(int num) {
        turnNum = num;
    }

    public static void setNumPasses(int num) {
        numPasses = num;
    }
}


