/**
 * This class represents a tile on the board
 */
package mule.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The interface Tile.
 */
public interface Tile extends Serializable {
    /**
     * The constant MULES.
     */
    List<Mule> MULES = new ArrayList<>();
    /**
     * The constant HASMULE.
     */
    boolean HASMULE = false;

    /**
     * Sets owner.
     *
     * @param player the player
     */
    void setOwner(Player player);


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

    /**
     * Has mule boolean.
     *
     * @return the boolean
     */
    boolean hasMule();

    /**
     * Sets has mule.
     *
     * @param isOwned the is owned
     */
    void setHasMule(boolean isOwned);

    /**
     * Gets mule.
     *
     * @return the mule
     */
    List<Mule> getMule();

    /**
     * Add mule.
     *
     * @param mule the mule
     */
    void addMule(Mule mule);

    /**
     * Calculate production.
     */
    void calculateProduction();

}


