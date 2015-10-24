package mule.model;

import mule.PlayerManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Mountain1 implements Tile {

    private Player player;
    private boolean isOwned;
    private boolean hasMule;
    private static  Tile[][] tiles;
    private List<Mule> mules = new ArrayList<>();

    public Mountain1() {

    }
    public void setOwner(Player player) {
        this.player = player;
    }
    public Tile getLocation(Tile[][] tiles) { return tiles[2][4]; }

    public Player getOwner() {
        return player;
    }

    public int getCost() {
        return 300;
    }

    public boolean isOwned() {
        return isOwned;
    }

    public void setIsOwned(boolean isOwned) {
        this.isOwned = isOwned;
    }

    public List<Mule> getMule() {
        return mules;
    }

    public void addMule (Mule mule) {
        mules.add(mule);
    }

    public void calculateProduction() {
        List<Mule> mules = this.getMule();
        Iterator<Mule> muleIterator = mules.iterator();
        while(muleIterator.hasNext()) {
            Mule currentMule = muleIterator.next();
                if (currentMule instanceof FoodMule) {
                    PlayerManager.addPlayerFood(this.getOwner(), 1);
                } else if (currentMule instanceof EnergyMule) {
                    PlayerManager.addPlayerEnergy(this.getOwner(), 1);
                } else if (currentMule instanceof SmithoreMule) {
                    PlayerManager.addPlayerSmithore(this.getOwner(), 2);
                } else if (currentMule instanceof UnicornMule) {
                    PlayerManager.addPlayerSmithore(this.getOwner(), 2);
                    PlayerManager.addPlayerFood(this.getOwner(), 3);
                    PlayerManager.addPlayerEnergy(this.getOwner(), 2);
                }
        }

    }

    public boolean hasMule() {
        return hasMule;
    }

    public void setHasMule(boolean hasMule) {
        this.hasMule = hasMule;
    }
}