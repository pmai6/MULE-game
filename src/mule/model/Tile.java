package mule.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//represents a single tile object
public interface Tile extends Serializable {
    List<Mule> mules = new ArrayList<>();
    void setOwner(Player player);

    Tile getLocation(Tile[][] tiles);

    //public String getType();

    Player getOwner();

    int getCost();

    boolean isOwned();

    void setIsOwned(boolean isOwned);


    List<Mule> getMule();
    void addMule (Mule mule);
    void calculateProduction();

    }


