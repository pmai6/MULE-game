package mule.model;

import java.util.ArrayList;
import java.util.List;

public class Mountain1 implements Tile {

    private Player player;
    private boolean isOwned;
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


}