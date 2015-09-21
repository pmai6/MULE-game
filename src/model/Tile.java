//represents a single tile object
public interface Tile {

    public void setOwner(String player);

    public Tile getLocation(Tile[][] tiles);

    //public String getType();

    public String getOwner();

    public int getCost();

}