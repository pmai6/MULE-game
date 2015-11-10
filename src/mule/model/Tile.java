/**
 * This class represents a tile on the board
 */
package mule.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public interface Tile extends Serializable {
    /**
     *
     */
    List<Mule> MULES = new ArrayList<>();
    /**
     *
     */
    boolean HASMULE = false;

    /**
     *
     * @param player the owner of the mule
     */
    void setOwner(Player player);


    /**
     *
     * @return the owner of the mule
     */
    Player getOwner();

    /**
     *
     * @return cost
     */
    int getCost();
    /**
     *
     * @return whether or not the mule is owned
     */
    boolean isOwned();
    /**
     *
     * @param isOwned whether or not the mule is owned
     */
    void setIsOwned(boolean isOwned);
    /**
     *
     * @return whether or not the tile has a mule
     */
    boolean hasMule();
    /**
     *
     * @param isOwned whether or not the player has a mule
     */
    void setHasMule(boolean isOwned);
    /**
     *
     * @return list of mules
     */
    List<Mule> getMule();
    /**
     *
     * @param mule mule to be added
     */
    void addMule(Mule mule);
    /**
     *
     */
    void calculateProduction();

}


