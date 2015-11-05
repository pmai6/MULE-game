package mule.model;

import mule.PlayerManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Mountain2 implements Tile {

    private Player player;
    private boolean isOwned;
    private boolean hasMule;
    private List<Mule> mules = new ArrayList<>();
    public Mountain2() {

    }

    public final void setOwner(Player player) {
        this.player = player;
    }

    public final Tile getLocation(Tile[][] tiles) {
        return tiles[2][4];
    }

    public final Player getOwner() {
        return player;
    }

    public final int getCost() {
        return 300;
    }

    public final boolean isOwned() {
        return isOwned;
    }

    public final void setIsOwned(boolean isOwned) {
        this.isOwned = isOwned;
    }


    public final List<Mule> getMule() {
        return mules;
    }

    public final void addMule(Mule mule) {
        mules.add(mule);
    }

    public final void calculateProduction() {
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

    public final boolean hasMule() {
        return hasMule;
    }

    public final void setHasMule(boolean hasMule) {
        this.hasMule = hasMule;
    }
}