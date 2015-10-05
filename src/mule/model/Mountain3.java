package mule.model;
public class Mountain3 implements Tile {

    private Player player;
    private boolean isOwned;
    private Mule mule;
    public Mountain3() {

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

    public void setMule(Mule mule) {
        this.mule = mule;
    }

    public Mule getMule() {
        return mule;
    }
}