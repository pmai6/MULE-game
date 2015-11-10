package mule.model;

/**
 * The type Smithore mule.
 */
public class SmithoreMule implements Mule {

    /**
     * The Player.
     */
    private Player player;
    /**
     * The Is owned.
     */
    private boolean isOwned;
    /**
     * The constant tile.
     */
    private static  Tile tile;

    /**
     * Instantiates a new Smithore mule.
     */
    public SmithoreMule() {

    }

    /**
     * Sets owner.
     *
     * @param player the player
     */
    public void setOwner(Player player) {
        this.player = player;
    }

    /**
     * Gets location.
     *
     * @param tile the tile
     * @return the location
     */
    public Tile getLocation(Tile tile) { return tile; }

    /**
     * Sets location.
     *
     * @param tile the tile
     */
    public void setLocation(Tile tile) {
        SmithoreMule.tile = tile; }

    /**
     * Gets owner.
     *
     * @return the owner
     */
    public Player getOwner() {
        return player;
    }

    /**
     * Gets cost.
     *
     * @return the cost
     */
    public int getCost() {
        return 175;
    }

    /**
     * Is owned boolean.
     *
     * @return the boolean
     */
    public boolean isOwned() {
        return isOwned;
    }

    /**
     * Sets is owned.
     *
     * @param isOwned the is owned
     */
    public void setIsOwned(boolean isOwned) {
        this.isOwned = isOwned;
    }
}
