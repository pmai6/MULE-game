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

        String[] defaultTiles = new String[]{"P", "M2","M1","M3","R"} ;

        String[][] randomMapLayout = new String[5][9];
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 9; j++) {
                randomMapLayout[i][j] = defaultTiles[(int) (Math.random() *
                        (5))];
            }
        }
        randomMapLayout[2][4]= "Town";
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