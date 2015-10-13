package mule.model;

import mule.PlayerManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class River implements Tile {

    private Player player;
    private boolean isOwned;
    private List<Mule> mules = new ArrayList<>();

    public River() {

    }
    public void setOwner(Player player) {
        this.player = player;
    }
    public Tile getLocation(Tile[][] tiles) { return tiles[4][3]; }

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
            if(muleIterator.next() instanceof FoodMule) {
                PlayerManager.addPlayerFood(this.getOwner(),4);
            }
            else if(muleIterator.next() instanceof EnergyMule) {
                PlayerManager.addPlayerEnergy(this.getOwner(), 2);
            }
        }

    }
}

