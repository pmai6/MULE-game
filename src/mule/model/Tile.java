package mule.model;
//represents a single tile object
public interface Tile {

    void setOwner(Player player);

    Tile getLocation(Tile[][] tiles);

    //public String getType();

    Player getOwner();

    int getCost();

    boolean isOwned();

    void setIsOwned(boolean isOwned);

    public void setMule(Mule mule);

}