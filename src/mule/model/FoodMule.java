package mule.model;

/**
 * The type Food mule.
 */
public class FoodMule implements Mule {

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
     * Instantiates a new Food mule.
     */
    public FoodMule() {
        this.player = new Player ("Unicornese","fairy horse","rainbow");
    }

    /**
     * Sets owner.
     *
     * @param player the player
     */
    public final void setOwner(Player player) {
        this.player = player;
    }

    /**
     * Gets location.
     *
     * @param tile the tile
     * @return the location
     */
    public final Tile getLocation(Tile tile) { return FoodMule.tile; }

    /**
     * Gets owner.
     *
     * @return the owner
     */
/*   public Tile getLocation(Tile tile) {
        return FoodMule.tile;
    }

    public final void setLocation(Tile tile) {
        FoodMule.tile = tile; }

    public final Player getOwner() {
    public void setLocation(Tile tile) {
        FoodMule.tile = tile;
    }
*/
    public Player getOwner() {
        return player;
    }

    /**
     * Gets cost.
     *
     * @return the cost
     */
    public final int getCost() {
        return 125;
    }

    /**
     * Is owned boolean.
     *
     * @return the boolean
     */
    public final boolean isOwned() {
        return isOwned;
    }

    /**
     * Sets is owned.
     *
     * @param isOwned the is owned
     */
    public final void setIsOwned(boolean isOwned) {
        this.isOwned = isOwned;
    }
}
