package mule.model;

/**
 * Created by ryyanj on 10/1/15.
 */
public interface Mule {

    public void setOwner(Player player);

    public void setLocation(Tile[][] tiles);

    public Tile getLocation(Tile[][] tiles);

    public Player getOwner();

    public int getCost();

    public boolean isOwned();

    public void setIsOwned(boolean isOwned);

}
