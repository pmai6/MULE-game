package mule.model;

/**
 * Created by ryyanj on 10/1/15.
 */
public class EnergyMule implements Mule {

    private Player player;
    private boolean isOwned;
    private static  Tile tile;

    public EnergyMule() {

    }

    public void setOwner(Player aplayer) {
        this.player = aplayer;
    }
    public Tile getLocation(Tile atile) { return atile; }

    public void setLocation(Tile atile) {
        EnergyMule.tile = atile; }

    public Player getOwner() {
        return player;
    }

    public int getCost() {
        return 150;
    }

    public boolean isOwned() {
        return isOwned;
    }

    public void setIsOwned(boolean aisOwned) {
        this.isOwned = aisOwned;
    }
}
