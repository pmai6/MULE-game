package mule;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mule.model.*;
import mule.view.GameController;

import java.util.Collections;
import java.util.List;

/**
 * Created by travisclement on 9/18/15.
 */
public class GameManager {
    private static GameManager gameManager = new GameManager();
    private static Game mulegame;
    private static GameController controller;

public static GameManager getGameManager() {
    return gameManager;
}
    public void createGame(String difficulty,
                                  int numberOfPlayers,
                                  String map, int n) {
        mulegame = new Game(difficulty, numberOfPlayers, map, n);
    }

    public void startTheGame(Stage stage) throws Exception {

        mulegame.setIsLandSelectionPhase(true);
        MapManager.setUpMap();
        RoundManager.startRounds(gameManager);
        gameManager.startGameController(stage);
        gameManager.setGameStateLabel();
        gameManager.disablePlayers(mulegame.getNumberOfPlayers());

        gameManager.initializePlayerGuiStats();

        //used for testing purposes only TOREMOVE
        for (Player element : mulegame.getPlayerArray()) {
            System.out.println(element.getPlayerName());
        }
        updateGamePlayerRound();

    }

    /**Disables the player areas in the main GUI screen so there
     * score and info do not show up
     * @param numPlayers
     */
    public void disablePlayers(int numPlayers) {
        if (numPlayers == 2) {
            controller.disablePlayerThree();
            controller.disablePlayerFour();
        } else if (numPlayers == 3) {
            controller.disablePlayerFour();
        }
    }

    /** start the game controller - the main window of the game
     *
     * @param astage
     * @throws Exception
     */
    public void startGameController(Stage astage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "view/GameScreen.fxml"));
        Parent root = fxmlLoader.load();
        astage.setScene(new Scene(root));
        astage.setTitle("M.U.L.E Game Screen");
        controller = fxmlLoader.getController();
        astage.show();
    }

    /**  sets the label in the main area of the game with the current game
     * state
     *
     */
    public   void setGameStateLabel() {
        if (gameManager.getMulegame().isLandSelectionPhase()) {
            controller.setGameStateLabel("LAND SELECTION PHASE");
        } else if (gameManager.getMulegame().isMuleBought()) {
            controller.setGameStateLabel("PLACE YOUR MULE");
        } else {
            controller.setGameStateLabel("NORMAL GAME MODE");
        }
    }

    public  void updateGamePlayerRound() {
        controller.setCurrentPlayer(RoundManager.getCurrentPlayer()
                .getPlayerName());
        controller.setRoundNumber(Round.getRoundNum());
        gameManager.setGameStateLabel();
    }


    public void updateStoreData () {
       int food = Store.getFoodQty();
        int energy = Store.getEnergyQty();
        int smithore = Store.getSmithoreQty();
        int crystite = Store.getCrystiteQty();
        int mule = Store.getMuleQty();

        controller.updateStoreData(food, energy,smithore, crystite, mule);
    }

    public  void initializePlayerGuiStats() {
        updatePlayerOne();
        updatePlayerTwo();
        if (mulegame.getNumberOfPlayers() == 4) {
            updatePlayerThree();
            updatePlayerFour();
        } else if (mulegame.getNumberOfPlayers() > 2) {
            updatePlayerThree();
        }

    }
    private  void updatePlayerOne() {
        String name = mulegame.getPlayerArray().get(0).getPlayerName();
        String race = mulegame.getPlayerArray().get(0)
                .getPlayerRace();
        String color = mulegame.getPlayerArray().get(0)
                .getPlayerColor();
        int score = mulegame.getPlayerArray().get(0).getScore();
        int money = mulegame.getPlayerArray().get(0).getMoney();
        int ore = mulegame.getPlayerArray().get(0).getSmithore();
        int food = mulegame.getPlayerArray().get(0).getFood();
        controller.changePlayerOneGuiStats(name, race, score, money, ore,
                food, color);
    }
    private   void updatePlayerTwo() {
        String name = mulegame.getPlayerArray().get(1)
                .getPlayerName();
        String race = mulegame.getPlayerArray().get(1)
                .getPlayerRace();

        String color = mulegame.getPlayerArray().get(1)
                .getPlayerColor();
        int score = mulegame.getPlayerArray().get(1).getScore();
        int money = mulegame.getPlayerArray().get(1).getMoney();
        int ore = mulegame.getPlayerArray().get(1).getSmithore();
        int food = mulegame.getPlayerArray().get(1).getFood();
        controller.changePlayerTwoGuiStats(name, race, score, money, ore,
                food, color);
    }
    private static void updatePlayerThree() {
        String name = mulegame.getPlayerArray().get(2)
                .getPlayerName();
        String race = mulegame.getPlayerArray().get(2)
                .getPlayerRace();
        String color = mulegame.getPlayerArray().get(2)
                .getPlayerColor();
        int score = mulegame.getPlayerArray().get(2).getScore();
        int money = mulegame.getPlayerArray().get(2).getMoney();
        int ore = mulegame.getPlayerArray().get(2).getSmithore();
        int food = mulegame.getPlayerArray().get(2).getFood();
        controller.changePlayerThreeGuiStats(name, race, score, money, ore,
                food, color);
    }

    private  void updatePlayerFour() {
        String name = mulegame.getPlayerArray().get(3)
                .getPlayerName();
        String race = mulegame.getPlayerArray().get(3)
                .getPlayerRace();
        String color = mulegame.getPlayerArray().get(3)
                .getPlayerColor();
        int score = mulegame.getPlayerArray().get(3).getScore();
        int money = mulegame.getPlayerArray().get(3).getMoney();
        int ore = mulegame.getPlayerArray().get(3).getSmithore();
        int food = mulegame.getPlayerArray().get(3).getFood();
        controller.changePlayerFourGuiStats(name, race, score, money, ore,
                food, color);
    }
    public   void setTimer() {
        controller.setTimer();
    }

    public  void muleAlert() {
        controller.badMulePlacement();
    }

    public   void notEnoughMoney() {
        controller.youGotNoMoney();
    }

    public  void addMuleToButton(Button button,Tile tile) {
        controller.addMuleToButton(button, tile);
    }

    public  boolean isLandSelectionPhase() {
        return mulegame.isLandSelectionPhase();
    }

    public  void setIsLandSelectionPhase(boolean isLandSelect) {
        mulegame.setIsLandSelectionPhase(isLandSelect);
    }


    public  Game getMulegame() {
        return mulegame;
}

    public  boolean isMuleBought() {
        return mulegame.isLandSelectionPhase();
    }

    public  void setIsMuleBought(boolean isMuleBought) {
        mulegame.setIsMuleBought(isMuleBought);
    }



    public void createSortedPlayerArray() {
        mulegame.createSortedPlayerArray();
    }

    public List<Player> getSortedPlayerArray() {
        return mulegame.getSortedPlayerArray();
    }

    public  int getNumberOfPlayers() {
        return mulegame.getNumberOfPlayers();
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        mulegame.setNumberOfPlayers(numberOfPlayers);
    }

    public void handleMapButton(Button button) {
        MapManager.handleMapButton(button);

    }
}
