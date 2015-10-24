package mule.model;

import java.io.*;

/**
 * Created by ryyanj on 10/1/15.
 */
public interface Mule extends Serializable {

    void setOwner(Player player);

    void setLocation(Tile tile);

    Tile getLocation(Tile tiles);

    Player getOwner();

    int getCost();

    boolean isOwned();

    void setIsOwned(boolean isOwned);

}
