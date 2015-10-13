package mule.model;

import java.util.ArrayList;
import java.util.List;

//represents a single tile object
public interface Tile {
    List<Mule> mules = new ArrayList<>();
    void setOwner(Player player);

    Tile getLocation(Tile[][] tiles);

    //public String getType();

    Player getOwner();

    int getCost();

    boolean isOwned();

    void setIsOwned(boolean isOwned);


    public List<Mule> getMule();

    public void addMule (Mule mule);

    public void calculateProduction();

    }


