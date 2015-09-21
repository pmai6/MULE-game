import com.sun.xml.internal.bind.v2.TODO;
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
        if (Game.getMulegame().isLandSelectionPhase()) {

            Player player = Round.getCurrentPlayer();
            Tile tile = GameMap.getTiles()[GridPane.getRowIndex(button)
                    ][GridPane.getColumnIndex(button)];
            if (!(buyTile(player, tile, button))) {
                System.out.println(button.getText());
                String acolor = "RED";
                button.setStyle(" -fx-base: " + acolor +";");
            }
        }

    }

    /** Method to buy a tile
     * takes in player and tile
     * then marks the tile as owned buy the player in the tile
     * array.
     * then adds the tile to the array the player keeps of the tiles it owns
     * deducts the money from the players money - use PlayerManager method
     * boughtsomething  to handle the deduction from the players account
     * the PlayerManager can talk to Gamemanager to update the GUI screen
     * Update the button to reflect the players color
     * Button param will only be used to pass through tto the
     * changeButtonColor() method
     * @param player
     * @param tile
     * @return true if tile was purchased
     */
    private static boolean buyTile (Player player, Tile tile, Button button) {
        //TODO
        return false;
    }


    /** Method to check if tile can be bought
     * should check if tile is currently owned
     * if the player has enough money to buy the tile
     * sanity check to make sure it is not the town
     * @param player
     * @param tile
     * return boolean return true if it can be
     */
private static boolean canTileBeBought (Player player, Tile tile) {
    //TODO
    return false;
}




    /** Method to change the color of the button that was pushed on the map
     * takes in player and Button to determine which color and which button to
     * change
     * @param player
     * @param button
     */
    private void changeButtonColor (Player player, Button button) {
        //TODO

        //how to change color
        //button.setStyle(" -fx-base: RED;");
    }


    /** method to compute the current cost of tile
     * set to 300 for now will need to update after land selection phase
     * @return int cost of tile
     */
    public static int costOfTile() {
        //TODO good enough for M4 but needs to be more accurate for later rounds
        return 300;
    }


    /** sets up the main map that will be in uses during the game
     * This is here basically just so random maps could be implemented at a
     * latter date as opposed to hard coding the tiles to the Tile array
     *
     */
    public static void setUpMap() {

        Tile[][] tiles = GameMap.getTiles();
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
                    newTileName.setOwner("Town");
                }

            }
        }
    }


}
