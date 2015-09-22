
/**
 * Created by ryyanj on 9/20/15.
 */

import java.lang.reflect.Array;
import java.util.ArrayList;;

public class Round {

    public ArrayList<Turn> roundTurns;
    public static int numPasses;
    public Round() {
        numPasses = 0;
    }
    public static int getNumPasses() {
        return numPasses;
    }

    //initialize proper number of turns based on number of players
    public static void createTurns() {
        roundTurns = new ArrayList<Turn>(Game.getNumberOfPlayers());
        roundNum = 1;
        turnNum = 0;
    public static void incrementNumPasses () {
        numPasses++;
    }

public static int turnNum;

    public static int roundNum = 1;
    public static void createTurns() {

    }

    public static int getTurnNum() {
        return turnNum;
    }

    public static void setTurnNum(int turnNum) {
        Round.turnNum = turnNum;
    }

    public static int getRoundNum() {
        return roundNum;
    }

    public static void setRoundNum(int roundNum) {
        Round.roundNum = roundNum;
    }
    //public roundTurns;

    public boolean isRoundOver() {
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


