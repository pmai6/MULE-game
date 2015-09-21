/**
 * This class need to keep track of rounds and notify the Game class or
 * manager that Land selection has finished
 */
public class RoundManager {

    public static void startRounds() {
// no idea what this does
        //should probably create turn objects here
    }


    /**
     * return whoever is the currentPlayer
     *
     * @return you know the player
     */
    public static Player getCurrentPlayer() {
        Player player = new Player();
        return player;
    }


    /** other classes will call this to let the RoundManager manager know that a
     * player has finished their turn.
     *  coming from MapManager.
     */
    public static void playerFinishedTurn() { //TODO//
    }


    /** other classes will call this to let the RoundManager manager know that a
     * player has passed on turn
     *  coming Game Manager
     *  Will need to keep track of number of presses so can decide if land
     *  selection is over.
     *  create some sort of counter to keep track of how many times this is
     *  pressed in a round - if same as number of players in round then land
     *  selection phase is over.
     */
    public static boolean playerPassedTurn() {
        System.out.println("I finished my turn");
        Round.incrementNumPasses();
        return false;
    }


    /** somehow keep track of all the playerPassed Turn and set land slection
     * over if all players have passed.
     */
    private static boolean isLandSelectionOver () { //TODO
        if(Round.getNumPasses() == Game.getNumberOfPlayers()) {
            return true;
        }
        else
            return false;
    }
}
