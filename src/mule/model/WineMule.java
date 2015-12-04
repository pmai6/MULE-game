package mule.model;

/**
 * Created by redcream12 on 12/4/15.
 */
public class WineMule implements Mule {

    private Player player;
    private boolean isOwned;
    private static  Tile tile;

    public WineMule() {

    }

    public void setOwner(Player player) {
            this.player = player;
        }
    public Tile getLocation(Tile tile) { return tile; }

    public void setLocation(Tile tile) {
        WineMule.tile = tile; }

    public Player getOwner() {
            return player;
        }

    public int getCost() {
            return 110;
        }

    public boolean isOwned() {
            return isOwned;
        }

    public void setIsOwned(boolean isOwned) {
            this.isOwned = isOwned;
        }

    }

