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
    private static RoundManager roundManager = new RoundManager();
    private static GameManager gameManager;
    public static void startRounds(GameManager agameManager) {
// no idea what this does
        //should probably create turn objects here
        Round.createTurns();
        gameManager = agameManager;
    }

    /**
     * return whoever is the currentPlayer
     *
     * @return you know the player
     */
    public static Player getCurrentPlayer() {
        // This needs to be an actual player
        // This is called by the MapManager handleMapButton method

        if(gameManager.getMulegame().isLandSelectionPhase())
            return gameManager.getMulegame().getPlayerArray().get(Round
                    .getTurnNum());
        else {
            return gameManager.getMulegame().getSortedPlayerArray().get(Round
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

        if (gameManager.isLandSelectionPhase()) {
            isLandSelectionOver();
        }
        if (!gameManager.isLandSelectionPhase()) {
            gameManager.setTimer();
            gameManager.getMulegame().setIsMuleBought(false);
        }
        RoundManager.incrementTurnNumber();

        if (Round.getTurnNum() < gameManager.getMulegame().getNumberOfPlayers()){
            gameManager.updateGamePlayerRound();
        }

        if(Round.getTurnNum() == gameManager.getMulegame().getNumberOfPlayers()) { //incrmeent round if all players have gone
            setPlayerScores();
            RoundManager.incrementRoundNumber();

            gameManager.getMulegame().createSortedPlayerArray();
            Round.setTurnNum(0); //reset turn counter
            Round.setNumPasses(0);//reset number of passes
            gameManager.updateGamePlayerRound();
            if (gameManager.isLandSelectionPhase()) {
                isLandSelectionOver();
            }
        }

    }

    /** somehow keep track of all the playerPassed Turn and set land slection
     * over if all players have passed.
     */
    private static void isLandSelectionOver () {
        if (Round.getNumPasses() == gameManager.getMulegame().getNumberOfPlayers()) {
            gameManager.setIsLandSelectionPhase(false);
            Round.setRoundNum(0);
            setPlayerScores();
            gameManager.createSortedPlayerArray();
            gameManager.setGameStateLabel();
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
        for(int playerInd = 0; playerInd < gameManager.getMulegame().getNumberOfPlayers(); playerInd++) {
            gameManager.getMulegame().getPlayerArray().get(playerInd).calculateScore();
        }
    }
}
