import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * Created by travisclement on 9/18/15.
 */
public class MapManager {

    public static void handleMapButton(Button button){
        System.out.println("Row " + GridPane.getRowIndex(button) + " Column "
                + GridPane.getColumnIndex(button));
    }

    public static void setUpMap() {

        Tile [][] tiles = Map.getTiles();
        String [][] defaultMapLayout = Map.getDefaultMapLayout();

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
                    newTileName.setOwner("Town");
                }

            }
        }
        printMap(tiles);
    }

    // This is just here to make sure stuff is working
    public static void printMap(Tile [][] tiles) {
        for (int i = 0; i < 5; i++) {
            System.out.println();
            for (int j = 0; j < 9; j++) {

                System.out.print(tiles[i][j].getClass() + " ");

            }
        }
    }


}
