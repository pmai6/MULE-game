package mule;

import mule.model.Game;
import mule.model.Player;
import mule.model.Round;

import java.util.*;

import mule.model.Tile;
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
        if(gameManager.isLandSelectionPhase())
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
            roundManager.incrementNumPasses();
        }

        PlayerManager.calculatePlayerRandomEvent();
        PlayerManager.calculatePlayerProduction();
        if (gameManager.isLandSelectionPhase()) {
            isLandSelectionOver();
        }
        if (!gameManager.isLandSelectionPhase()) {
            gameManager.setTimer();
            gameManager.setIsMuleBought(false);
            gameManager.setCursorDefault();
        }
        roundManager.incrementTurnNumber();

        if (Round.getTurnNum() < gameManager.getNumberOfPlayers()){
            gameManager.updateGamePlayerRound();
        }

        if(Round.getTurnNum() == gameManager.getNumberOfPlayers()) { //incrmeent round if all players have gone
            roundManager.setPlayerScores();
            roundManager.incrementRoundNumber();

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
        if (Round.getNumPasses() == gameManager.getNumberOfPlayers()) {
            gameManager.setIsLandSelectionPhase(false);
            Round.setRoundNum(0);
            roundManager.setPlayerScores();
            gameManager.createSortedPlayerArray();
            gameManager.setGameStateLabel();
        }
    }


    private  void incrementTurnNumber() {
        int turnNum = Round.getTurnNum();
        turnNum++;
        Round.setTurnNum(turnNum);
    }

    private  void incrementRoundNumber() {
        int roundNum = Round.getRoundNum();
        roundNum++;
        Round.setRoundNum(roundNum);
    }


    private  void incrementNumPasses() {
        int numPasses = Round.getNumPasses();
        numPasses++;
        Round.setNumPasses(numPasses);
    }

    private  void setPlayerScores() {
        for(int playerInd = 0; playerInd < gameManager.getNumberOfPlayers(); playerInd++) {
            gameManager.getMulegame().getPlayerArray().get(playerInd).calculateScore();
        }
    }



}
