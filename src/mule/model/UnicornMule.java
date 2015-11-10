package mule.model;

/**
 * Created by redcream12 on 10/20/15.
 */
public class UnicornMule implements Mule {
    private Player player;
    private boolean isOwned;


    public UnicornMule() {

    }

    public void setOwner(Player aplayer) {
        this.player = aplayer;
    }

/*    public Tile getLocation(Tile atile) {
        return atile;
    }

    public void setLocation(Tile atile) {
        UnicornMule.tile = atile;
    }*/

    public Player getOwner() {
        return player;
    }

    public int getCost() {
        return 700;
    }

    public boolean isOwned() {
        return isOwned;
    }

    public void setIsOwned(boolean aisOwned) {
        this.isOwned = aisOwned;
    }

}

