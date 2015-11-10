package mule.model;

/**
 * Created by ryyanj on 10/1/15.
 */
public class FoodMule implements Mule {

    private Player player;
    private boolean isOwned;
    private static  Tile tile;

    public FoodMule() {
        this.player = new Player ("Unicornese","fairy horse","rainbow");
    }
    public final void setOwner(Player player) {
        this.player = player;
    }
    public final Tile getLocation(Tile tile) { return FoodMule.tile; }
 /*   public Tile getLocation(Tile tile) {
        return FoodMule.tile;
    }

    public final void setLocation(Tile tile) {
        FoodMule.tile = tile; }

    public final Player getOwner() {
    public void setLocation(Tile tile) {
        FoodMule.tile = tile;
    }
*/
    public Player getOwner() {
        return player;
    }

    public final int getCost() {
        return 125;
    }

    public final boolean isOwned() {
        return isOwned;
    }

    public final void setIsOwned(boolean isOwned) {
        this.isOwned = isOwned;
    }
}
