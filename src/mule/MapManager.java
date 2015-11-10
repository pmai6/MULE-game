package mule;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import mule.model.*;
import mule.view.*;

/**
 * The type Map manager.
 */
public class MapManager {
    /**
     * The constant gameManager.
     */
    private static GameManager gameManager = GameManager.getGameManager();

    /**
     * The constant button.
     */
    private static Button button;

    /**
     * Handle map button.
     *
     * @param button the button
     */
    public static void handleMapButton(Button button) {
        MapManager.button = button;
        Player player = RoundManager.getCurrentPlayer();
        Tile tile = gameManager.getMulegame().getTiles()[GridPane.getRowIndex
                (button)
                ][GridPane.getColumnIndex(button)];

        if (gameManager.getMulegame().isLandSelectionPhase()) {
            buyTile(player, tile, button);

        } else if (gameManager.getMulegame().isMuleBought()) {
            placeMule(player, tile, button);
        }

    }

    /**
     * Buy tile.
     *
     * @param player the player
     * @param tile   the tile
     * @param button the button
     */
    private static void buyTile(Player player, Tile tile, Button button) {
        if (canTileBeBought(player, tile)) {

            tile.setIsOwned(true);
            tile.setOwner(player);

            player.playerBuyProperty(tile);
            changeButtonColor(player, button);

            RoundManager.playerFinishedTurn(false);
        }
        // maybe have window show up later
    }


    /**
     * Can tile be bought boolean.
     *
     * @param player the player
     * @param tile   the tile
     * @return the boolean
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
     * Place mule.
     *
     * @param player the player
     * @param tile   the tile
     * @param button the button
     */
    private static void placeMule(Player player, Tile tile, Button button) {
        Mule mule = player.getUnplacedMule();
        if (tile.getOwner() != null && tile.getOwner().equals(player)) {
            tile.addMule(mule);
            tile.setHasMule(true);
            player.setUnplacedMule(null);
            gameManager.getMulegame().setIsMuleBought(false);
            gameManager.setGameStateLabel();
            gameManager.addMuleToButton(button, tile);

        } else {
            player.setUnplacedMule(null);
            gameManager.getMulegame().setIsMuleBought(false);
            gameManager.setGameStateLabel();
            gameManager.muleAlert();

        }

    }


    /**
     * Change button color.
     *
     * @param player the player
     * @param button the button
     */
    private static void changeButtonColor(Player player, Button button) {
        String thecolor = player.getPlayerColor();
        //how to change color
        button.setStyle(" -fx-base: " + thecolor + ";");
    }


    /**
     * Cost of tile int.
     *
     * @return the int
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

    /**
     * Sets map.
     *
     * @param mulegame   the mulegame
     * @param controller the controller
     */
    public static void setupMap(Game mulegame, GameController controller) {

        Button[][] buttons = controller.getButtonArray();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                Tile tile = mulegame.getTiles()[i][j];
                Button button =  buttons[i][j];
                controller.addImageToButton(button, tile);
                if (tile.getOwner() != null) {
                    String color = tile.getOwner().getPlayerColor();
                    button.setStyle(" -fx-base: " + color + ";");
                   if (tile.hasMule()) {
                       controller.addMuleToButton(button, tile);
                    }
                }
            }
        }
    }
}


