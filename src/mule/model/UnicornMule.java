package mule.model;

/**
 * The type Unicorn mule.
 */
public class UnicornMule implements Mule {
    /**
     * The Player.
     */
    private Player player;
    /**
     * The Is owned.
     */
    private boolean isOwned;


    /**
     * Instantiates a new Unicorn mule.
     */
    public UnicornMule() {

    }

    /**
     * Sets owner.
     *
     * @param aplayer the aplayer
     */
    public void setOwner(Player aplayer) {
        this.player = aplayer;
    }

/*    public Tile getLocation(Tile atile) {
        return atile;
    }

    public void setLocation(Tile atile) {
        UnicornMule.tile = atile;
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
        return 700;
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

