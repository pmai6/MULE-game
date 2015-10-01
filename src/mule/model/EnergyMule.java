package mule.model;

/**
 * Created by ryyanj on 10/1/15.
 */
public class EnergyMule implements Mule {

    private Player player;
    private boolean isOwned;
    private static  Tile[][] tiles;

    public EnergyMule() {

    }

    public void setOwner(Player player) {
        this.player = player;
    }
    public Tile getLocation(Tile[][] tiles) { return tiles[2][4]; }

    public void setLocation(Tile[][] tiles) {this.tiles = tiles; }

    public Player getOwner() {
        return player;
    }

    public int getCost() {
        return 150;
    }

    public boolean isOwned() {
        return isOwned;
    }

    public void setIsOwned(boolean isOwned) {
        this.isOwned = isOwned;
    }
}
