package mule.model;

/*
holds the array of all of the tiles on the map
*/

import mule.GameManager;
import mule.model.Tile;

public class GameMap {
    private static GameManager gameManager = GameManager.getGameManager();


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


    public static String[][] getRandomMapLayout() {

        String[] defaultTiles = new String[]{"P", "M2","M1","M3","P", "P", "P", "P"} ;

        String[][] randomMapLayout = new String[5][9];
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 9; j++) {
                randomMapLayout[i][j] = defaultTiles[(int) (Math.random() *
                        (8))];
            }
        }
        randomMapLayout[2][4]= "Town";
        randomMapLayout[0][4] = "R";
        randomMapLayout[1][4] = "R";
        randomMapLayout[3][4] = "R";
        randomMapLayout[4][4] = "R";
        return randomMapLayout;
    }

    public static String[][] getMapLayout() {
        if (gameManager.getMulegame().getMap().equals("Standard")) {
            return getDefaultMapLayout();
        } else {
            return getRandomMapLayout();
        }
    }

    public static void setDefaultMapLayout(String[][] defaultMapLayout) {
        GameMap.defaultMapLayout = defaultMapLayout;
    }


    /** sets up the main map that will be in uses during the game
     * This is here basically just so random maps could be implemented at a
     * latter date as opposed to hard coding the tiles to the Tile array
     *
     */
    public static Tile[][] setUpMap() {

        Tile[][] tiles =  new Tile[5][9];
        String[][] defaultMapLayout = GameMap.getMapLayout();

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 9; j++) {

                String tileType = defaultMapLayout[i][j];

                if (tileType.equals("P")) {
                    Tile newTileName = new Plain();
                    tiles[i][j] = newTileName;

                } else if (tileType.equals("R")) {
                    Tile newTileName = new River();
                    tiles[i][j] = newTileName;

                } else if (tileType.equals("M1"))  {
                    Tile newTileName = new Mountain1();
                    tiles[i][j] = newTileName;

                } else if (tileType.equals("M2")) {
                    Tile newTileName = new Mountain2();
                    tiles[i][j] = newTileName;

                } else if (tileType.equals("M3")) {
                    Tile newTileName = new Mountain3();
                    tiles[i][j] = newTileName;

                } else {
                    Tile newTileName = new Plain();
                    tiles[i][j] = newTileName;
                    newTileName.setOwner(null);
                }

            }
        }
        return tiles;
    }
}