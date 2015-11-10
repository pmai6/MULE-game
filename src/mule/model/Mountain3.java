package mule.model;

import mule.PlayerManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The type Mountain 3.
 */
public class Mountain3 implements Tile {

    /**
     * The Player.
     */
    private Player player;
    /**
     * The Is owned.
     */
    private boolean isOwned;
    /**
     * The Has mule.
     */
    private boolean hasMule;
    /**
     * The Mules.
     */
    private List<Mule> mules = new ArrayList<>();

    /**
     * Instantiates a new Mountain 3.
     */
    public Mountain3() {

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
     * Gets location.
     *
     * @param tiles the tiles
     * @return the location
     */
    public Tile getLocation(Tile[][] tiles) {
        return tiles[2][4];
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
        return 300;
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


    /**
     * Gets mule.
     *
     * @return the mule
     */
    public List<Mule> getMule() {
        return mules;
    }

    /**
     * Add mule.
     *
     * @param mule the mule
     */
    public void addMule(Mule mule) {
        mules.add(mule);
    }

    /**
     * Calculate production.
     */
    public void calculateProduction() {
        List<Mule> amules = this.getMule();
        Iterator<Mule> muleIterator = amules.iterator();
        while (muleIterator.hasNext()) {
            Mule currentMule = muleIterator.next();
            if (currentMule instanceof FoodMule) {
                PlayerManager.addPlayerFood(this.getOwner(), 1);
            } else if (currentMule instanceof EnergyMule) {
                PlayerManager.addPlayerEnergy(this.getOwner(), 1);
            } else if (currentMule instanceof SmithoreMule) {
                PlayerManager.addPlayerSmithore(this.getOwner(), 4);
            } else if (currentMule instanceof UnicornMule) {
                PlayerManager.addPlayerFood(this.getOwner(), 4);
                PlayerManager.addPlayerEnergy(this.getOwner(), 1);
            }
        }

    }

    /**
     * Has mule boolean.
     *
     * @return the boolean
     */
    public boolean hasMule() {
        return hasMule;
    }

    /**
     * Sets has mule.
     *
     * @param ahasMule the ahas mule
     */
    public void setHasMule(boolean ahasMule) {
        this.hasMule = ahasMule;
    }
}