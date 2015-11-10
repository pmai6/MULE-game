package mule.model;

/*
holds the array of all of the tiles on the map
*/

import mule.GameManager;
import mule.model.Tile;

/**
 * The type Game map.
 */
public final class GameMap {
    /**
     * Instantiates a new Game map.
     */
    private  GameMap() { }

    /**
     * The constant gameManager.
     */
    private static GameManager gameManager = GameManager.getGameManager();


    /**
     * The constant defaultMapLayout.
     */
    private static String[][] defaultMapLayout = new String[][]{
            {"P", "P", "M1", "P", "R", "P", "M3", "P", "P"},
            {"P", "M1", "P", "P", "R", "P", "P", "P", "M3"},
            {"M3", "P", "P", "P", "Town", "P", "P", "P", "M1"},
            {"P", "M2", "P", "P", "R", "P", "M2", "P", "P"},
            {"P", "P", "M2", "P", "R", "P", "P", "P", "M2"}
    };


    /**
     * Get default map layout string [ ] [ ].
     *
     * @return the string [ ] [ ]
     */
    public static String[][] getDefaultMapLayout() {
        return defaultMapLayout;
    }


    /**
     * Get random map layout string [ ] [ ].
     *
     * @return the string [ ] [ ]
     */
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

    /**
     * Get map layout string [ ] [ ].
     *
     * @return the string [ ] [ ]
     */
    public static String[][] getMapLayout() {
        if (gameManager.getMulegame().getMap().equals("Standard")) {
            return getDefaultMapLayout();
        } else {
            return getRandomMapLayout();
        }
    }

    /**
     * Sets default map layout.
     *
     * @param defaultMapLayout the default map layout
     */
    public static void setDefaultMapLayout(String[][] defaultMapLayout) {
        GameMap.defaultMapLayout = defaultMapLayout;
    }


    /**
     * Set up map tile [ ] [ ].
     *
     * @return the tile [ ] [ ]
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