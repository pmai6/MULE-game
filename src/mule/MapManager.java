package mule;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import mule.model.*;
import mule.view.*;

/**
 * Created by travisclement on 9/18/15.
 */
public final class MapManager {

    private MapManager(){}
    private static GameManager gameManager = GameManager.getGameManager();

    private static Button button;

    /**
     * this will be the major method to handle what happens when a button is
     * pushed
     *
     * @param button button on map display player's property
     */
    public static void handleMapButton(Button abutton) {
        MapManager.button = abutton;
        Player player = RoundManager.getCurrentPlayer();
        Tile tile = gameManager.getMulegame().getTiles()[GridPane.getRowIndex
                (abutton)
                ][GridPane.getColumnIndex(abutton)];

        if (gameManager.getMulegame().isLandSelectionPhase()) {
            buyTile(player, tile, abutton);

        } else if (gameManager.getMulegame().isMuleBought()) {
            placeMule(player, tile, abutton);
        }

    }

    /**
     * Method to buy a tile
     * takes in player and tile
     * then marks the tile as owned buy the player in the tile
     * array.
     * then adds the tile to the array the player keeps of the tiles it owns
     * deducts the money from the players money -
     * Button param will only be used to pass through tto the
     * changeButtonColor() method
     *
     * @param player player who buys tile
     * @param tile tile to be bought
     */
    private static void buyTile(Player player, Tile tile, Button abutton) {
        if (canTileBeBought(player, tile)) {

            tile.setIsOwned(true);
            tile.setOwner(player);

            player.playerBuyProperty(tile);
            changeButtonColor(player, abutton);

            RoundManager.playerFinishedTurn(false);
        }
        // maybe have window show up later
    }


    /**
     * Method to check if tile can be bought
     * should check if tile is currently owned
     * if the player has enough money to buy the tile
     * sanity check to make sure it is not the town
     *
     * @param player current player of the game
     * @param tile   tile to be checked
     */
    private static boolean canTileBeBought(Player player, Tile tile) {

        if (!(tile.isOwned()) && (
                player.getMoney() - MapManager.costOfTile() >=
                        0)) {
            return true;
        }
        return false;
    }


    /**
     * method to placeMule on Tile in the main map
     *
     * @param player current player
     * @param tile   Tile that was clicked on
     * @param button - button, so image can be changed
     */
    private static void placeMule(Player player, Tile tile, Button abutton) {
        Mule mule = player.getUnplacedMule();
        if (tile.getOwner() != null && tile.getOwner().equals(player)) {
            tile.addMule(mule);
            tile.setHasMule(true);
            player.setUnplacedMule(null);
            gameManager.getMulegame().setIsMuleBought(false);
            gameManager.setGameStateLabel();
            gameManager.addMuleToButton(abutton, tile);
            for (Tile tiles : player.getTiles()) {
                for (Mule mules : tiles.getMule()) {
                    System.out.println(mules);
                }
            }
        } else {
            player.setUnplacedMule(null);
            gameManager.getMulegame().setIsMuleBought(false);
            gameManager.setGameStateLabel();
            gameManager.muleAlert();

        }

    }


    /**
     * Method to change the color of the button that was pushed on the map
     * takes in player and Button to determine which color and which button to
     * change
     *
     * @param player current player of the game
     * @param button button on map to be changed color
     */
    private static void changeButtonColor(Player player, Button abutton) {
        String thecolor = player.getPlayerColor();
        //how to change color
        abutton.setStyle(" -fx-base: " + thecolor + ";");
    }


    /**
     * method to compute the current cost of tile
     * set to 300 for now will need to update after land selection phase
     *
     * @return int cost of tile
     */
    public static int costOfTile() {
        //TODO need to deal with later rounds in land selection phase
        // and need to deal with when the real game starts.
        if (gameManager.getMulegame().isLandSelectionPhase() && gameManager
                .getMulegame().getRound().getRoundNum() <= 2) {

            return 0;
        }
        return 300;
    }

    public static void setupMap(Game mulegame, GameController controller) {

        Button[][] buttons = controller.getButtonArray();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                Tile tile = mulegame.getTiles()[i][j];
                Button abutton =  buttons[i][j];
                controller.addImageToButton(abutton, tile);
                if (tile.getOwner() != null) {
                    String color = tile.getOwner().getPlayerColor();
                    abutton.setStyle(" -fx-base: " + color + ";");
                   if (tile.hasMule()) {
                       controller.addMuleToButton(abutton, tile);
                    }
                }
            }
        }
    }
}


