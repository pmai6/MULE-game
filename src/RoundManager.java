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
        return Game.getMulegame().getPlayerArray().get(Round.getTurnNum());
    }

    private static void incrementTurnNumber() {
        Round.turnNum++;
    }

    private static void incrementRoundNumber() {
        Round.roundNum++;
    }


    /** other classes will call this to let the RoundManager manager know that a
     * player has finished their turn.
     *  coming from MapManager.
     */
    public static void playerFinishedTurn(boolean passed) { //TODO//

        if(passed == true) {
            Round.incrementNumPasses();
            isLandSelectionOver();
        }

        RoundManager.incrementTurnNumber();
        if (Round.getTurnNum() < Game.getNumberOfPlayers()){
            GameManager.updateGamePlayerRound();
        }

        if(Round.getTurnNum() == Game.getNumberOfPlayers()) { //incrmeent round if all players have gone
            RoundManager.incrementRoundNumber();
            Round.turnNum = 0; //reset turn counter
            Round.numPasses = 0;//reset number of passes
            GameManager.updateGamePlayerRound();
            isLandSelectionOver();

        }

    }

    /** somehow keep track of all the playerPassed Turn and set land slection
     * over if all players have passed.
     */
    private static void isLandSelectionOver () {
        if(Round.getNumPasses() == Game.getNumberOfPlayers()) {
            Game.setIsLandSelectionPhase(false);
            //Round.turnNum = 0; //reset turn counter

            Round.setRoundNum(0);
            GameManager.setGameStateLabel();
        }
    }
}
