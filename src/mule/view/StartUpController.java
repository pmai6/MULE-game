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


public class StartUpController {
    private GameManager gameManager;
    // variables to functionality to comboboxes and buttons
    @FXML
    private ComboBox<String> difficultyCombo;
    @FXML
    private ComboBox<Integer> numberPlayersCombo;
    @FXML
    private ComboBox<String> mapTypeCombo;
    @FXML
    private Button nextButton;


    //creating Main object so can talk to Main methods
    private Main mainapp;


    // Arrays for Combo - pull down boxes
    private ObservableList<String> difficultyComboData =
            FXCollections.observableArrayList();

    private ObservableList<Integer> numberPlayersComboData =
            FXCollections.observableArrayList();

    private ObservableList<String> mapTypeComboData =
            FXCollections.observableArrayList();


    private String selectedDifficulty;
    private String selectedMap;
    private int selectedNumberPlayers = 0;


    public  StartUpController() {
    }

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

    @FXML
    private void handleDifficultyComboAction() {
        selectedDifficulty =
                difficultyCombo.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void handleNumberPlayersComboAction() {
        selectedNumberPlayers =
                numberPlayersCombo.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void handleMapTypeComboAction() {
        selectedMap = mapTypeCombo.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void nextButtonAction() throws Exception {
        Stage stage;
        stage = (Stage) nextButton.getScene().getWindow();


        gameManager.createGame(selectedDifficulty,
                selectedNumberPlayers, selectedMap, selectedNumberPlayers);

        // the below starts the next window
        mainapp.startPlayerConfig(stage);


    }

    @FXML
    private void skipScreens () throws Exception {

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
