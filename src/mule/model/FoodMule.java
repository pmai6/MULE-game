package mule.model;

/**
 * Created by ryyanj on 10/1/15.
 */
public class FoodMule implements Mule {

    private Player aplayer;
    private boolean aisOwned;
    private static  Tile atile;

    public FoodMule() {
        this.player = new Player ("Unicornese","fairy horse","rainbow");
    }
    public final void setOwner(Player aplayer) {
        this.player = aplayer;
    }
    public final Tile getLocation(Tile atile) { return FoodMule.atile; }

    public final void setLocation(Tile atile) {
        FoodMule.tile = atile; }

    public final Player getOwner() {
        return aplayer;
    }

    public final int getCost() {
        return 125;
    }

    public final boolean isOwned() {
        return aisOwned;
    }

    public final void setIsOwned(boolean aisOwned) {
        this.isOwned = aisOwned;
    }
}
