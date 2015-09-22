/**
 * This class need to keep track of rounds and notify the Game class or
 * manager that Land selection has finished
 */
public class RoundManager {

    public static void startRounds() {
        //create turn objects for round
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
        return Game.getMulegame().getPlayerArray().get(Round.getTurnNum());
    }

    /** other classes will call this to let the RoundManager manager know that a
     * player has finished their turn.
     *  coming from MapManager.
     */
    public static void playerFinishedTurn(boolean passed) { //TODO//

        if(passed == true) {
            RoundManager.incrementNumPasses();
            isLandSelectionOver();

        }
        RoundManager.incrementTurnNumber();

        if (Round.getTurnNum() < Game.getNumberOfPlayers()){
            GameManager.updateGamePlayerRound();
        }

        if(Round.getTurnNum() == Game.getNumberOfPlayers()) { //incrmeent round if all players have gone
            RoundManager.incrementRoundNumber();
            Round.setTurnNum(0); //reset turn counter
            Round.setNumPasses(0);//reset number of passes
            GameManager.updateGamePlayerRound();
            isLandSelectionOver();
        }

    }

    /** somehow keep track of all the playerPassed Turn and set land slection
     * over if all players have passed.
     */
    private static void isLandSelectionOver () {
        if (Round.getNumPasses() == Game.getNumberOfPlayers()) {
            Game.setIsLandSelectionPhase(false);

            Round.setRoundNum(0);
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
}
