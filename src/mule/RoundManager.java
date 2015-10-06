package mule;

import mule.model.Game;
import mule.model.Player;
import mule.model.Round;

import java.util.*;
import mule.view.GameController;
import mule.view.timer;


/**
 * This class need to keep track of rounds and notify the Game class or
 * manager that Land selection has finished
 */
public class RoundManager {

    public static void startRounds() {
// no idea what this does
        //should probably create turn objects here
        Round.createTurns();
    }

    /**
     * return whoever is the currentPlayer
     *
     * @return you know the player
     */
    public static Player getCurrentPlayer() {
        // This needs to be an actual player
        // This is called by the MapManager handleMapButton method

        if(GameManager.getMulegame().isLandSelectionPhase())
            return GameManager.getMulegame().getPlayerArray().get(Round
                    .getTurnNum());
        else {
            return GameManager.getMulegame().getSortedPlayerArray().get(Round
                    .getTurnNum());
        }
    }



    /** other classes will call this to let the RoundManager manager know that a
     * player has finished their turn.
     *  coming from MapManager.
     */
    public static void playerFinishedTurn(boolean passed) {
        if(passed) {
            RoundManager.incrementNumPasses();
        }

        if (GameManager.getMulegame().isLandSelectionPhase()) {
            isLandSelectionOver();
        }
        if (!GameManager.getMulegame().isLandSelectionPhase()) {
            GameManager.setTimer();
            GameManager.getMulegame().setIsMuleBought(false);
        }
        RoundManager.incrementTurnNumber();

        if (Round.getTurnNum() < GameManager.getMulegame().getNumberOfPlayers()){
            GameManager.updateGamePlayerRound();
        }

        if(Round.getTurnNum() == GameManager.getMulegame().getNumberOfPlayers()) { //incrmeent round if all players have gone
            setPlayerScores();
            RoundManager.incrementRoundNumber();

            GameManager.getMulegame().createSortedPlayerArray();
            Round.setTurnNum(0); //reset turn counter
            Round.setNumPasses(0);//reset number of passes
            GameManager.updateGamePlayerRound();
            if (GameManager.getMulegame().isLandSelectionPhase()) {
                isLandSelectionOver();
            }
        }

    }

    /** somehow keep track of all the playerPassed Turn and set land slection
     * over if all players have passed.
     */
    private static void isLandSelectionOver () {
        if (Round.getNumPasses() == GameManager.getMulegame().getNumberOfPlayers()) {
            GameManager.getMulegame().setIsLandSelectionPhase(false);
            Round.setRoundNum(0);
            setPlayerScores();
            GameManager.getMulegame().createSortedPlayerArray();
            GameManager.setGameStateLabel();
        }
    }


    private static void incrementTurnNumber() {
        int turnNum = Round.getTurnNum();
        turnNum++;
        Round.setTurnNum(turnNum);
    }

    private static void incrementRoundNumber() {
        int roundNum = Round.getRoundNum();
        roundNum++;
        Round.setRoundNum(roundNum);
    }


    private static void incrementNumPasses() {
        int numPasses = Round.getNumPasses();
        numPasses++;
        Round.setNumPasses(numPasses);
    }

    private static void setPlayerScores() {
        for(int playerInd = 0; playerInd < GameManager.getMulegame().getNumberOfPlayers(); playerInd++) {
            GameManager.getMulegame().getPlayerArray().get(playerInd).calculateScore();
        }
    }
}
