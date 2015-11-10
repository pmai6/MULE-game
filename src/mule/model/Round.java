package mule.model;

/**
 * Created by ryyanj on 9/20/15.
 */

        import java.io.*;
        import java.util.ArrayList;

/**
 * The type Round.
 */
public class Round implements Serializable {

    /**
     * The Round turns.
     */
    private  ArrayList<Turn> roundTurns;
    /**
     * The Round num.
     */
    private  int roundNum;
    /**
     * The Turn num.
     */
    private  int turnNum;
    /**
     * The Num passes.
     */
    private  int numPasses;


    /**
     * Gets num passes.
     *
     * @return the num passes
     */
    public final int getNumPasses() {
        return numPasses;
    }

    /**
     * Create turns.
     *
     * @param numberOfPlayers the number of players
     */
//initialize proper number of turns based on number of players
    public final void createTurns(int numberOfPlayers) {
        roundTurns = new ArrayList<Turn>(numberOfPlayers);
        roundNum = 1;
        turnNum = 0;
    }

    /**
     * Gets turn num.
     *
     * @return the turn num
     */
//returns the current turn number
    public final int getTurnNum() {
        return turnNum;
    }

    /**
     * Gets current turn.
     *
     * @return the current turn
     */
//returns the current turn object
    public final Turn getCurrentTurn() {
        return roundTurns.get(turnNum);
    }

    /**
     * Gets round num.
     *
     * @return the round num
     */
    public final int getRoundNum() {
        return roundNum;
    }

    /**
     * Sets round num.
     *
     * @param num the num
     */
    public final void setRoundNum(int num) { roundNum = num;
    }

    /**
     * Sets turn num.
     *
     * @param num the num
     */
    public final void setTurnNum(int num) {
        turnNum = num;
    }

    /**
     * Sets num passes.
     *
     * @param num the num
     */
    public final void setNumPasses(int num) {
        numPasses = num;
    }
}


