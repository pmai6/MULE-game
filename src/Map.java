/*
holds the array of all of the tiles on the map
*/

public class Map {

   private static  String[][] defaultMapLayout = new String[][]{
            { "P","P","M1","P","R","P","M3","P","P" },
            { "P","M1","P","P","R","P","P","P","M3" },
            { "M3”,”P”,”P”,”P”,”Town”,”P”,”P”,”P”,”M1"},
            { "P","M2","P","P","R","P","M2","P","P" },
            { "P","P","M2","P","R","P","P","P","M2" },
    };



    public Map() {

    }
    public Tile[][] tiles;



}