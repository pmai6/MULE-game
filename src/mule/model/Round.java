package mule.model;

/**
 * Created by ryyanj on 9/20/15.
 */

        import mule.GameManager;

        import java.io.*;
        import java.lang.reflect.Array;
        import java.util.ArrayList;

public class Round implements Serializable {

    private  ArrayList<Turn> roundTurns;
    private  int roundNum;
    private  int turnNum;
    private  int numPasses;


    public  int getNumPasses() {
        return numPasses;
    }

    //initialize proper number of turns based on number of players
    public  void createTurns(int numberOfPlayers) {
        roundTurns = new ArrayList<Turn>(numberOfPlayers);
        roundNum = 1;
        turnNum = 0;
    }

    //returns the current turn number
    public  int getTurnNum() {
        return turnNum;
    }

    //returns the current turn object
    public  Turn getCurrentTurn() {
        return roundTurns.get(turnNum);
    }

    public  int getRoundNum() {
        return roundNum;
    }

    public  void setRoundNum(int num) { roundNum = num;
    }

    public  void setTurnNum(int num) {
        turnNum = num;
    }

    public  void setNumPasses(int num) {
        numPasses = num;
    }
}


