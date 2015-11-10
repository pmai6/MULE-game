package mule.model;

/**
 * Created by ryyanj on 9/20/15.
 */

        import java.io.*;
        import java.util.ArrayList;
        import java.util.List;

public class Round implements Serializable {

    private  List <Turn> roundTurns;
    private  int roundNum;
    private  int turnNum;
    private  int numPasses;


    public final int getNumPasses() {
        return numPasses;
    }

    //initialize proper number of turns based on number of players
    public final void createTurns(int numberOfPlayers) {
        roundTurns = new ArrayList<Turn>(numberOfPlayers);
        roundNum = 1;
        turnNum = 0;
    }

    //returns the current turn number
    public final int getTurnNum() {
        return turnNum;
    }

    //returns the current turn object
    public final Turn getCurrentTurn() {
        return roundTurns.get(turnNum);
    }

    public final int getRoundNum() {
        return roundNum;
    }

    public final void setRoundNum(int num) { roundNum = num;
    }

    public final void setTurnNum(int num) {
        turnNum = num;
    }

    public final void setNumPasses(int num) {
        numPasses = num;
    }
}


