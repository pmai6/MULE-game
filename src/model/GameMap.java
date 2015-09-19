/*
holds the array of all of the tiles on the map
*/

public class GameMap {
    private static  Tile[][] tiles = new Tile[5][9];;

   private static String[][] defaultMapLayout = new String[][]{
            {"P", "P", "M1", "P", "R", "P", "M3", "P", "P"},
            {"P", "M1", "P", "P", "R", "P", "P", "P", "M3"},
            {"M3", "P", "P", "P", "Town", "P", "P", "P", "M1"},
            {"P", "M2", "P", "P", "R", "P", "M2", "P", "P"},
            {"P", "P", "M2", "P", "R", "P", "P", "P", "M2"}
    };


    public GameMap() {

    }


    public static String[][] getDefaultMapLayout() {
        return defaultMapLayout;
    }


    //TODO currently just a plan array - need logic to fill the array
    public static String[][] getRandomMapLayout() {
        String[][] randomMapLayout = new String[][]{
                {"P", "P", "M2", "P", "R", "P", "P", "P", "M2"},
                {"P", "P", "Town", "P", "R", "P", "P", "P", "M2"},
                {"M3", "P", "P", "P", "Town", "P", "P", "P", "M1"},
                {"P", "M2", "P", "P", "R", "P", "M2", "P", "P"},
                {"P", "M2", "Town", "P", "R", "P", "Town", "P", "P"}
        };

        return randomMapLayout;
    }

    public static String[][] getMapLayout() {
        if (Game.getMulegame().getMap().equals("Standard")) {
            return getDefaultMapLayout();
        } else {
            return getRandomMapLayout();
        }
    }

    public static void setDefaultMapLayout(String[][] defaultMapLayout) {
        GameMap.defaultMapLayout = defaultMapLayout;
    }

    public static Tile[][] getTiles() {
        return tiles;
    }

    public static void setTiles(Tile[][] tiles) {
        GameMap.tiles = tiles;
    }
}