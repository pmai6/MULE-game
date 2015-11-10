package mule.model;

/**
 * The type Energy mule.
 */
public class EnergyMule implements Mule {

    /**
     * The Player.
     */
    private Player player;
    /**
     * The Is owned.
     */
    private boolean isOwned;

    /**
     * Instantiates a new Energy mule.
     */
    public EnergyMule() {

    }

    /**
     * Sets owner.
     *
     * @param aplayer the aplayer
     */
    public void setOwner(Player aplayer) {
        this.player = aplayer;
    }

  /*  public Tile getLocation(Tile tile) {
        return tile;
    }

    public void setLocation(Tile tile) {
        EnergyMule.tile = tile;
    }*/

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
        return 150;
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
     * @param aisOwned the ais owned
     */
    public void setIsOwned(boolean aisOwned) {
        this.isOwned = aisOwned;
    }
}
