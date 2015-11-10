package mule.model;

/**
 * Created by ryyanj on 10/1/15.
 */
public class CrystiteMule implements Mule {

    private Player player;
    private boolean isOwned;
    private static  Tile tile;

    public CrystiteMule() {

    }

    public void setOwner(Player aplayer) {
        this.player = aplayer;
    }
    public Tile getLocation(Tile atile) { return atile; }

    public void setLocation(Tile atile) {
        CrystiteMule.tile = atile; }

    public Player getOwner() {
        return player;
    }

    public int getCost() {
        return 200;
    }

    public boolean isOwned() {
        return isOwned;
    }

    public void setIsOwned(boolean aisOwned) {
        this.isOwned = aisOwned;
    }

}
