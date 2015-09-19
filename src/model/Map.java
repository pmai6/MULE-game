/*
holds the array of all of the tiles on the map
*/

public class Map {
    private static  Tile[][] tiles = new Tile[5][9];;

    private static String[][] defaultMapLayout = new String[][]{
            {"P", "P", "M1", "P", "R", "P", "M3", "P", "P"},
            {"P", "M1", "P", "P", "R", "P", "P", "P", "M3"},
            {"M3", "P", "P", "P", "Town", "P", "P", "P", "M1"},
            {"P", "M2", "P", "P", "R", "P", "M2", "P", "P"},
            {"P", "P", "M2", "P", "R", "P", "P", "P", "M2"}
    };


    public Map() {

    }


    public static String[][] getDefaultMapLayout() {
        return defaultMapLayout;
    }

    public static void setDefaultMapLayout(String[][] defaultMapLayout) {
        Map.defaultMapLayout = defaultMapLayout;
    }

    public static Tile[][] getTiles() {
        return tiles;
    }

    public static void setTiles(Tile[][] tiles) {
        Map.tiles = tiles;
    }
}