package mule.model;

/**
 * Created by ryyanj on 10/1/15.
 */
public class SmithoreMule implements Mule {

    private Player player;
    private boolean isOwned;
    private static Tile tile;

    public SmithoreMule() {

    }

    public void setOwner(Player player) {
        this.player = player;
    }

    public Tile getLocation(Tile tile) {
        return tile;
    }

    public void setLocation(Tile tile) {
        SmithoreMule.tile = tile;
    }

    public Player getOwner() {
        return player;
    }

    public int getCost() {
        return 175;
    }

    public boolean isOwned() {
        return isOwned;
    }

    public void setIsOwned(boolean isOwned) {
        this.isOwned = isOwned;
    }
}
