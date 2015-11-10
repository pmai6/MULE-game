package mule;

import mule.model.Game;
import mule.model.Player;


/**
 * The type Round manager.
 */
public class RoundManager {
    /**
     * The constant roundManager.
     */
    private static RoundManager roundManager = new RoundManager();
    /**
     * The constant gameManager.
     */
    private static GameManager gameManager;
    /**
     * The constant mulegame.
     */
    private static Game mulegame;

    /**
     * Start rounds.
     *
     * @param agameManager the agame manager
     */
    public static void startRounds(GameManager agameManager) {
// no idea what this does
        //should probably create turn objects here

        gameManager = agameManager;
        mulegame = gameManager.getMulegame();
        mulegame.getRound().createTurns(mulegame.getNumberOfPlayers());
    }


    /**
     * Start from save.
     *
     * @param agameManager the agame manager
     */
    public static void startFromSave(GameManager agameManager) {
        gameManager = agameManager;
        mulegame = gameManager.getMulegame();

    }

    /**
     * Gets current player.
     *
     * @return the current player
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
     * Player finished turn.
     *
     * @param passed the passed
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
    }

    /**
     * Is land selection over.
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


    /**
     * Increment turn number.
     */
    private void incrementTurnNumber() {
        int turnNum = mulegame.getRound().getTurnNum();
        turnNum++;
        mulegame.getRound().setTurnNum(turnNum);
    }

    /**
     * Increment round number.
     */
    private void incrementRoundNumber() {
        int roundNum = mulegame.getRound().getRoundNum();
        roundNum++;
        mulegame.getRound().setRoundNum(roundNum);
    }


    /**
     * Increment num passes.
     */
    private void incrementNumPasses() {
        int numPasses = mulegame.getRound().getNumPasses();
        numPasses++;
        mulegame.getRound().setNumPasses(numPasses);
    }

    /**
     * Sets player scores.
     */
    private void setPlayerScores() {
        for (int playerInd = 0; playerInd < gameManager.getNumberOfPlayers();
             playerInd++) {
            mulegame.getPlayerArray().get(playerInd).calculateScore();
        }
    }


}
