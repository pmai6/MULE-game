package mule.model;

import mule.PlayerManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The type Mountain 2.
 */
public class Mountain2 implements Tile {

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
     * Instantiates a new Mountain 2.
     */
    public Mountain2() {

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
    public  int getCost() {
        return 300;
    }

    /**
     * Is owned boolean.
     *
     * @return the boolean
     */
    public  boolean isOwned() {
        return isOwned;
    }

    /**
     * Sets is owned.
     *
     * @param isOwned the is owned
     */
    public  void setIsOwned(boolean isOwned) {
        this.isOwned = isOwned;
    }


    /**
     * Gets mule.
     *
     * @return the mule
     */
    public  List<Mule> getMule() {
        return mules;
    }

    /**
     * Add mule.
     *
     * @param mule the mule
     */
    public  void addMule(Mule mule) {
        mules.add(mule);
    }

    /**
     * Calculate production.
     */
    public  void calculateProduction() {
        List<Mule> mules = this.getMule();
        Iterator<Mule> muleIterator = mules.iterator();
        while(muleIterator.hasNext()) {
            Mule currentMule = muleIterator.next();
                if (currentMule instanceof FoodMule) {
                    PlayerManager.addPlayerFood(this.getOwner(), 1);
                } else if (currentMule instanceof EnergyMule) {
                    PlayerManager.addPlayerEnergy(this.getOwner(), 1);
                } else if (currentMule instanceof SmithoreMule) {
                    PlayerManager.addPlayerSmithore(this.getOwner(), 3);
                } else if (currentMule instanceof UnicornMule) {
                    PlayerManager.addPlayerSmithore(this.getOwner(), 3);
                    PlayerManager.addPlayerCrystite(this.getOwner(), 1);
                    PlayerManager.addPlayerEnergy(this.getOwner(), 2);
                }
        }

    }

    /**
     * Has mule boolean.
     *
     * @return the boolean
     */
    public  boolean hasMule() {
        return hasMule;
    }

    /**
     * Sets has mule.
     *
     * @param hasMule the has mule
     */
    public  void setHasMule(boolean hasMule) {
        this.hasMule = hasMule;
    }
}