package mule.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import mule.GameManager;
import mule.Main;
import mule.PlayerManager;


/**
 * The type Start up controller.
 */
public class StartUpController {
    /**
     * The Game manager.
     */
    private GameManager gameManager;
    /**
     * The Difficulty combo.
     */
// variables to functionality to comboboxes and buttons
    @FXML
    private ComboBox<String> difficultyCombo;
    /**
     * The Number players combo.
     */
    @FXML
    private ComboBox<Integer> numberPlayersCombo;
    /**
     * The Map type combo.
     */
    @FXML
    private ComboBox<String> mapTypeCombo;
    /**
     * The Next button.
     */
    @FXML
    private Button nextButton;


    /**
     * The Mainapp.
     */
//creating Main object so can talk to Main methods
    private Main mainapp;


    /**
     * The Difficulty combo data.
     */
// Arrays for Combo - pull down boxes
    private ObservableList<String> difficultyComboData =
            FXCollections.observableArrayList();

    /**
     * The Number players combo data.
     */
    private ObservableList<Integer> numberPlayersComboData =
            FXCollections.observableArrayList();

    /**
     * The Map type combo data.
     */
    private ObservableList<String> mapTypeComboData =
            FXCollections.observableArrayList();


    /**
     * The Selected difficulty.
     */
    private String selectedDifficulty;
    /**
     * The Selected map.
     */
    private String selectedMap;
    /**
     * The Selected number players.
     */
    private int selectedNumberPlayers = 0;


    /**
     * Instantiates a new Start up controller.
     */
    public  StartUpController() {
    }

    /**
     * Sets main app.
     *
     * @param mainapp the mainapp
     */
    public void setMainApp(Main mainapp) {
        this.mainapp = mainapp;
    }

    /**
     * Initialize.
     */
    @FXML
    private void initialize() {

        gameManager = GameManager.getGameManager();
        // Init ComboBox's
        difficultyComboData.add("Beginner");
        difficultyComboData.add("Standard");
        difficultyComboData.add("Tournament");

        numberPlayersComboData.add(2);
        numberPlayersComboData.add(3);
        numberPlayersComboData.add(4);


        mapTypeComboData.add("Standard");
        mapTypeComboData.add("Random");
        difficultyCombo.setItems(difficultyComboData);
        numberPlayersCombo.setItems(numberPlayersComboData);
        mapTypeCombo.setItems(mapTypeComboData);
    }

    /**
     * Handle difficulty combo action.
     */
    @FXML
    private void handleDifficultyComboAction() {
        selectedDifficulty =
                difficultyCombo.getSelectionModel().getSelectedItem();
    }

    /**
     * Handle number players combo action.
     */
    @FXML
    private void handleNumberPlayersComboAction() {
        selectedNumberPlayers =
                numberPlayersCombo.getSelectionModel().getSelectedItem();
    }

    /**
     * Handle map type combo action.
     */
    @FXML
    private void handleMapTypeComboAction() {
        selectedMap = mapTypeCombo.getSelectionModel().getSelectedItem();
    }

    /**
     * Next button action.
     *
     * @throws Exception the exception
     */
    @FXML
    private void nextButtonAction() throws Exception {
        Stage stage;
        stage = (Stage) nextButton.getScene().getWindow();


        gameManager.createGame(selectedDifficulty,
                selectedNumberPlayers, selectedMap, selectedNumberPlayers);

        // the below starts the next window
        mainapp.startPlayerConfig(stage);


    }

    /**
     * Skip screens.
     *
     * @throws Exception the exception
     */
    @FXML
    private void skipScreens() throws Exception {

        Stage stage;
        stage = (Stage) nextButton.getScene().getWindow();

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
}
