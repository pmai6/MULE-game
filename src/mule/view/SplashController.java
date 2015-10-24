package mule.view;

import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import mule.*;

/**
 * Created by travisclement on 10/23/15.
 */
public class SplashController {


    private GameManager gameManager;
    //creating Main object so can talk to Main methods
    private Main mainapp;

    @FXML
    private Label startGameLabel;

    @FXML
    private Label unicornSkip;
    @FXML
    private AnchorPane newGameAnchor;
    @FXML
    private AnchorPane loadGameAnchor;

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainapp takes Main object
     */
    public void setMainApp(Main mainapp) {
        this.mainapp = mainapp;
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

        gameManager = GameManager.getGameManager();

    }


    @FXML
    private void startNewGame() throws Exception {
        Stage stage;
        stage = (Stage) startGameLabel.getScene().getWindow();

        mainapp.startUpConfig(stage);


    }

    @FXML
    private void skipScreens () throws Exception {

        Stage stage;
        stage = (Stage) unicornSkip.getScene().getWindow();

        gameManager.createGame("Beginner", 4, "Standard", 4);
        PlayerManager.createNewGamePlayer("Drew",
                "Human", "Purple");
        PlayerManager.createNewGamePlayer("Ryyan",
                "Ugaite", "Green");
        PlayerManager.createNewGamePlayer("Travis",
                "Flapper", "Red");
        PlayerManager.createNewGamePlayer("Zuri",
                "Bonzoid", "Blue");

        gameManager.startTheGame(stage);
    }

    @FXML
    private void makeGreyNew () throws Exception {

        //how to change color
        newGameAnchor.setStyle(" -fx-background-color: DarkSlateGray");
    }

    @FXML
    private void makeGreyLoad () throws Exception {

        //how to change color
        loadGameAnchor.setStyle(" -fx-background-color: DarkSlateGray");
    }
    @FXML
    private void makeBlackNew () throws Exception {

        //how to change color
        newGameAnchor.setStyle(" -fx-background-color: Black");
    }

    @FXML
    private void makeBlackLoad () throws Exception {

        //how to change color
        loadGameAnchor.setStyle(" -fx-background-color: Black");
    }

    @FXML
    private void loadGame() throws Exception {
        Stage stage;
        stage = (Stage) startGameLabel.getScene().getWindow();
        GameManager.loadGame(stage);
    }
}


