package mule.model;

/**
 * Created by ryyanj on 10/1/15.
 */
/**
 */

/**
 * The type Crystite mule.
 */
public final class CrystiteMule implements Mule {
    /**
     * The Player.
     */
    private Player player;
    /**
     * The Is owned.
     */
    private boolean isOwned;


    /**
     * Instantiates a new Crystite mule.
     */
    public CrystiteMule() {

    }


    /**
     * Sets owner.
     *
     * @param aplayer the aplayer
     */
    public void setOwner(Player aplayer) {
        this.player = aplayer;
    }



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
        return 200;
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
