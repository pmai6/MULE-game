
//represents a single tile object
public interface Tile {

    public void setOwner(Player player);

    public Tile getLocation(Tile[][] tiles);

    //public String getType();

    public Player getOwner();

    public int getCost();

    public boolean isOwned();

    public void setIsOwned(boolean isOwned);
}