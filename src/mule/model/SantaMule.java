package mule.model;

/**
 * Created by redcream12 on 12/4/15.
 */
public class SantaMule implements Mule{
    private Player player;
    private boolean isOwned;
    private static  Tile tile;

    public SantaMule() {

    }

    public void setOwner(Player player) {
            this.player = player;
        }
    public Tile getLocation(Tile tile) { return tile; }

    public void setLocation(Tile tile) {
        SantaMule.tile = tile; }

    public Player getOwner() {
            return player;
        }

    public int getCost() {
            return 350;
        }

    public boolean isOwned() {
            return isOwned;
        }

    public void setIsOwned(boolean isOwned) {
            this.isOwned = isOwned;
        }

    }

