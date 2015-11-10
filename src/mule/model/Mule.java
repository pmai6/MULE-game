package mule.model;

import java.io.Serializable;

/**
 * The interface Mule.
 */
public interface Mule extends Serializable {

    /**
     * Sets owner.
     *
     * @param player the player
     */
    void setOwner(Player player);

/*
    void setLocation(Tile tile);

    Tile getLocation(Tile tiles);
*/

    /**
     * Gets owner.
     *
     * @return the owner
     */
    Player getOwner();

    /**
     * Gets cost.
     *
     * @return the cost
     */
    int getCost();

    /**
     * Is owned boolean.
     *
     * @return the boolean
     */
    boolean isOwned();

    /**
     * Sets is owned.
     *
     * @param isOwned the is owned
     */
    void setIsOwned(boolean isOwned);

}
