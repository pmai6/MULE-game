package mule;

import mule.model.Game;
import mule.model.Player;


/**
 * This class need to keep track of rounds and notify the Game class or
 * manager that Land selection has finished
 */
public class RoundManager {
    private static RoundManager roundManager = new RoundManager();
    private static GameManager gameManager;
    private static Game mulegame;

    public static void startRounds(GameManager agameManager) {
// no idea what this does
        //should probably create turn objects here

        gameManager = agameManager;
        mulegame = gameManager.getMulegame();
        mulegame.getRound().createTurns(mulegame.getNumberOfPlayers());
    }


    public static void startFromSave(GameManager agameManager) {
        gameManager = agameManager;
        mulegame = gameManager.getMulegame();

    }

    /**
     * return whoever is the currentPlayer
     *
     * @return you know the player
     */
    public static Player getCurrentPlayer() {
        if (gameManager.isLandSelectionPhase()) {
            return mulegame.getPlayerArray().get(mulegame.getRound()
                    .getTurnNum());
        } else {
            return mulegame.getSortedPlayerArray().get(mulegame.getRound()
                    .getTurnNum());
        }
    }


    /**
     * other classes will call this to let the RoundManager manager know that a
     * player has finished their turn.
     * coming from MapManager.
     */
    public static void playerFinishedTurn(boolean passed) {
        if (passed) {
            roundManager.incrementNumPasses();
        }

        PlayerManager.calculatePlayerProduction();
        if (gameManager.isLandSelectionPhase()) {
            isLandSelectionOver();
        }
        if (!gameManager.isLandSelectionPhase()) {
            PlayerManager.calculatePlayerTurnRandomEvent();
            gameManager.setTimer(getCurrentPlayer().calcPlayerTime());
            gameManager.setIsMuleBought(false);
            gameManager.setCursorDefault();
        }
        gameManager.initializePlayerGuiStats();
        roundManager.incrementTurnNumber();

        if (mulegame.getRound().getTurnNum() < gameManager.getNumberOfPlayers(
                )) {
            gameManager.updateGamePlayerRound();
        }

        if (mulegame.getRound().getTurnNum() == gameManager
                .getNumberOfPlayers()) {
            //incrmeent round if all players have gone

            roundManager.setPlayerScores();
            roundManager.incrementRoundNumber();

            gameManager.getMulegame().createSortedPlayerArray();
            mulegame.getRound().setTurnNum(0); //reset turn counter
            mulegame.getRound().setNumPasses(0); //reset number of passes
            gameManager.updateGamePlayerRound();
            if (gameManager.isLandSelectionPhase()) {
                isLandSelectionOver();
            } else {
                PlayerManager.calculatePlayerRoundRandomEvent();
            }
    }

    /**
     * somehow keep track of all the playerPassed Turn and set land slection
     * over if all players have passed.
     */
    private static void isLandSelectionOver() {
        if (mulegame.getRound().getNumPasses() == gameManager
                .getNumberOfPlayers()) {
            gameManager.setIsLandSelectionPhase(false);
            mulegame.getRound().setRoundNum(0);
            roundManager.setPlayerScores();
            gameManager.createSortedPlayerArray();
            gameManager.setGameStateLabel();
        }
    }


    private void incrementTurnNumber() {
        int turnNum = mulegame.getRound().getTurnNum();
        turnNum++;
        mulegame.getRound().setTurnNum(turnNum);
    }

    private void incrementRoundNumber() {
        int roundNum = mulegame.getRound().getRoundNum();
        roundNum++;
        mulegame.getRound().setRoundNum(roundNum);
    }


    private void incrementNumPasses() {
        int numPasses = mulegame.getRound().getNumPasses();
        numPasses++;
        mulegame.getRound().setNumPasses(numPasses);
    }

    private void setPlayerScores() {
        for (int playerInd = 0; playerInd < gameManager.getNumberOfPlayers();
             playerInd++) {
            mulegame.getPlayerArray().get(playerInd).calculateScore();
        }
    }


}
