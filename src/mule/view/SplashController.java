package mule.view;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mule.GameManager;
import mule.Main;
import mule.PlayerManager;

/**
 * The type Splash controller.
 */
public final class SplashController {


    /**
     * The Game manager.
     */
    private GameManager gameManager;
    /**
     * The Mainapp.
     */
//creating Main object so can talk to Main methods
    private Main mainapp;

    /**
     * The Start game label.
     */
    @FXML
    private Label startGameLabel;

    /**
     * The Unicorn skip.
     */
    @FXML
    private Label unicornSkip;
    /**
     * The New game anchor.
     */
    @FXML
    private AnchorPane newGameAnchor;
    /**
     * The Load game anchor.
     */
    @FXML
    private AnchorPane loadGameAnchor;

    /**
     * Sets main app.
     *
     * @param amainapp the amainapp
     */
    public void setMainApp(Main amainapp) {
        this.mainapp = amainapp;
    }

    /**
     * Initialize.
     */
    @FXML
    private void initialize() {

        gameManager = GameManager.getGameManager();

    }


    /**
     * Start new game.
     *
     * @throws Exception the exception
     */
    @FXML
    private void startNewGame() throws Exception {
        Stage stage;
        stage = (Stage) startGameLabel.getScene().getWindow();

        mainapp.startUpConfig(stage);
    }

    /**
     * Skip screens.
     *
     * @throws Exception the exception
     */
    @FXML
    private void skipScreens() throws Exception {

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

    /**
     * Make grey new.
     *
     * @throws Exception the exception
     */
    @FXML
    private void makeGreyNew() throws Exception {

        //how to change color
        newGameAnchor.setStyle(" -fx-background-color: DarkSlateGray");
    }

    /**
     * Make grey load.
     *
     * @throws Exception the exception
     */
    @FXML
    private void makeGreyLoad() throws Exception {

        //how to change color
        loadGameAnchor.setStyle(" -fx-background-color: DarkSlateGray");
    }

    /**
     * Make black new.
     *
     * @throws Exception the exception
     */
    @FXML
    private void makeBlackNew() throws Exception {

        //how to change color
        newGameAnchor.setStyle(" -fx-background-color: Black");
    }

    /**
     * Make black load.
     *
     * @throws Exception the exception
     */
    @FXML
    private void makeBlackLoad() throws Exception {

        //how to change color
        loadGameAnchor.setStyle(" -fx-background-color: Black");
    }

    /**
     * Load game.
     *
     * @throws Exception the exception
     */
    @FXML
    private void loadGame() throws Exception {
        Stage stage;
        stage = (Stage) startGameLabel.getScene().getWindow();
        GameManager.loadGame(stage);
    }
}


