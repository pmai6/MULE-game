import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * Created by travisclement on 9/18/15.
 */
public class MapManager {

    /** this will be the major method to handle what happens when a button is
     * pushed
     * @param button
     */
    public static void handleMapButton(Button button) {
        System.out.println("Row " + GridPane.getRowIndex(button) + " Column "
                + GridPane.getColumnIndex(button));
        System.out.println(button.getText());
        button.setStyle(" -fx-base: RED;");
    }

    /** sets up the main map that will be in uses during the game
     * This is here basicall just so random maps could be implemented at a
     * latter date as opposed to hard coding the tiles to the Tile array
     *
     */
    public static void setUpMap() {

        Tile[][] tiles = GameMap.getTiles();
        String[][] defaultMapLayout = GameMap.getDefaultMapLayout();

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
    }


}
