package mule.model;

/**
 * Created by ryyanj on 10/1/15.
 */
public class FoodMule implements Mule {

    private Player player;
    private boolean isOwned;


    public FoodMule() {

    }
    public void setOwner(Player player) {
        this.player = player;
    }
 /*   public Tile getLocation(Tile tile) {
        return FoodMule.tile;
    }

    public void setLocation(Tile tile) {
        FoodMule.tile = tile;
    }
*/
    public Player getOwner() {
        return player;
    }

    public int getCost() {
        return 125;
    }

    public boolean isOwned() {
        return isOwned;
    }

    public void setIsOwned(boolean isOwned) {
        this.isOwned = isOwned;
    }
}
