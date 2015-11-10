package mule.model;

/**
 * The type Turn.
 */

public class Turn {

    /**
     * The Player.
     */
    Player player; //which player's turn

    /**
     * Instantiates a new Turn.
     */
    public Turn() {

    }

    /**
     * Sets player.
     *
     * @param player the player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Gets player.
     *
     * @return the player
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Is turn over boolean.
     *
     * @return the boolean
     */
    public boolean isTurnOver() {
        //some conditions
        return false;
    }

}