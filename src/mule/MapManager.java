package mule;

import com.sun.xml.internal.bind.v2.TODO;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import mule.model.*;
import mule.model.GameMap;
/**
 * Created by travisclement on 9/18/15.
 */
public class MapManager {

    private static Button button;

    /** this will be the major method to handle what happens when a button is
     * pushed
     * @param button
     */
    public static void handleMapButton(Button button) {
        MapManager.button = button;
        System.out.println("Row " + GridPane.getRowIndex(button) + " Column "
                + GridPane.getColumnIndex(button));
        if (Game.getMulegame().isLandSelectionPhase()) {

            Player player = RoundManager.getCurrentPlayer();

            Tile tile = GameMap.getTiles()[GridPane.getRowIndex(button)
                    ][GridPane.getColumnIndex(button)];

            buyTile(player, tile, button);

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
    private static void buyTile (Player player, Tile tile, Button button) {
        if (canTileBeBought(player,tile)) {

            tile.setIsOwned(true);
            tile.setOwner(player);

            PlayerManager.buyProperty(player, tile);
            changeButtonColor(player, button);

            //GameManager.initializePlayerGuiStats();
/*player.setFood(10000000);
            player.setOre(999999);
            player.setScore(777777);*/

            RoundManager.playerFinishedTurn(false);
        }
         // maybe have window show up later
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

    if (!(tile.isOwned()) && (player.getMoney() - MapManager.costOfTile() >=
            0)) {
        return true;
    }
    return false;
}




    /** Method to change the color of the button that was pushed on the map
     * takes in player and Button to determine which color and which button to
     * change
     * @param player
     * @param button
     */
    private static void changeButtonColor (Player player, Button button) {
        //TODO
        String thecolor = player.getPlayerColor();
        //how to change color
        button.setStyle(" -fx-base: " + thecolor + ";");
    }


    /** method to compute the current cost of tile
     * set to 300 for now will need to update after land selection phase
     * @return int cost of tile
     */
    public static int costOfTile() {
        //TODO need to deal with later rounds in land selection phase
        // and need to deal with when the real game starts.
        if (Game.isLandSelectionPhase() && Round.getRoundNum() <= 2) {

            return 0;
        }
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
                    newTileName.setOwner(null);
                }

            }
        }
    }
}
