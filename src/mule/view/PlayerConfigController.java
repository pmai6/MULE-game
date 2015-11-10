package mule.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;

import javafx.stage.Stage;

import javafx.scene.control.TextField;
import mule.GameManager;
import mule.Main;
import mule.PlayerManager;

import java.util.List;


/**
 * The type Player config controller.
 */
public class PlayerConfigController {
    /**
     * The Game manager.
     */
    private GameManager gameManager;
    /**
     * The Race info.
     */
    private javafx.scene.control.Label raceInfo;
    /**
     * The Color label.
     */
    private javafx.scene.control.Label colorLabel;
    /**
     * The Race combo.
     */
// variables to functionality to comboboxes and buttons
    @FXML
    private ComboBox<String> raceCombo;
    /**
     * The Color combo.
     */
    @FXML
    private ComboBox<String> colorCombo;
    /**
     * The Next button.
     */
    @FXML
    private Button nextButton;
    /**
     * The Player name box.
     */
    @FXML
    private TextField playerNameBox;


    /**
     * The Mainapp.
     */
//creating Main object so can talk to Main methods
    private Main mainapp;


    /**
     * The Race combo data.
     */
// Arrays for Combo - pull down boxes
    private ObservableList<String> raceComboData =
            FXCollections.observableArrayList();

    /**
     * The Color combo data.
     */
    private ObservableList<String> colorComboData =
            FXCollections.observableArrayList();

    /**
     * The Selected race.
     */
    private String selectedRace;
    /**
     * The Selected color.
     */
    private String selectedColor;


    /**
     * Instantiates a new Player config controller.
     */
    public PlayerConfigController() {
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
        raceComboData.add("Human");
        raceComboData.add("Ugaite");
        raceComboData.add("Flapper");
        raceComboData.add("Bonzoid");
        raceComboData.add("Buzzite");
        raceComboData.add("Foilers");
        raceComboData.add("Trillers");
        raceComboData.add("Yellers");


        List<String> colorList;
        colorList = gameManager.getMulegame().getColor();
        for (String color : colorList) {
            colorComboData.add(color);

        }

        raceCombo.setItems(raceComboData);
        colorCombo.setItems(colorComboData);
    }

    /**
     * Handle race combo action.
     */
    @FXML
    private void handleRaceComboAction() {
        selectedRace =
                raceCombo.getSelectionModel().getSelectedItem();
        if (raceCombo.getSelectionModel().getSelectedItem().equals("Ugaite")) {
            raceInfo.setText("From the Nekite Galaxy. Ugaite love land. To "
                    + "get it they are willing to stick their necks out!");
        }
        if (raceCombo.getSelectionModel().getSelectedItem().equals("Human")) {
            raceInfo.setText("From the Earth Systems. Humanoids start with "
                    + "$600 because they are too smart! Expert Species");
        }
        if (raceCombo.getSelectionModel().getSelectedItem().equals("Bonzoid")) {
            raceInfo.setText("From the Armpull Galaxy. Bonzoids love climbing"
                    + " and are often found hanging around in the mountains");
        }
        if (raceCombo.getSelectionModel().getSelectedItem().equals("Buzzite")) {
            raceInfo.setText("From the Jacket System. Love to fly high above "
                    + "the competition");
        }
        if (raceCombo.getSelectionModel().getSelectedItem().equals("Flapper")) {
            raceInfo.setText("From the Boird-Drop Galaxy. All Flappers "
                    + "receive an extra $600 in their nest egg! Beginner "
                    + "Species");
        }
        if (raceCombo.getSelectionModel().getSelectedItem().equals("Foilers")) {
            raceInfo.setText("(DLC content) Feel Free to Foil your enemies "
                    + "with this new character!");
        }
        if (raceCombo.getSelectionModel().getSelectedItem().equals
                ("Trillers")) {
            raceInfo.setText("(DLC content) Keepin it trill. Try and tolerate"
                    + " these terrifying terrors");
        }
        if (raceCombo.getSelectionModel().getSelectedItem().equals("Yellers")) {
            raceInfo.setText("(DLC content) They're yellow. Thats about it");
        }
    }

    /**
     * Handle color combo action.
     */
    @FXML
    private void handleColorComboAction() {
        selectedColor =
                colorCombo.getSelectionModel().getSelectedItem();
        if (colorCombo.getSelectionModel().getSelectedItem().equals("Red")) {
            colorLabel.setTextFill(javafx.scene.paint.Color.RED);
        }
        if (colorCombo.getSelectionModel().getSelectedItem().equals("Blue")) {
            colorLabel.setTextFill(javafx.scene.paint.Color.BLUE);
        }
        if (colorCombo.getSelectionModel().getSelectedItem().equals("Purple")) {
            colorLabel.setTextFill(javafx.scene.paint.Color.PURPLE);
        }
        if (colorCombo.getSelectionModel().getSelectedItem().equals("Green")) {
            colorLabel.setTextFill(javafx.scene.paint.Color.GREEN);
        }
        if (colorCombo.getSelectionModel().getSelectedItem().equals("Orange")) {
            colorLabel.setTextFill(javafx.scene.paint.Color.ORANGE);
        }
        if (colorCombo.getSelectionModel().getSelectedItem().equals("Yellow")) {
            colorLabel.setTextFill(javafx.scene.paint.Color.YELLOW);
        }

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
        gameManager.getMulegame().removeColor(selectedColor);

        String playerName = playerNameBox.getText();
        PlayerManager.createNewGamePlayer(playerName,
                selectedRace, selectedColor);


        if (gameManager.getMulegame().getN() > 1) {
            gameManager.getMulegame().setN(gameManager.getMulegame().getN() -
                    1);
            mainapp.startPlayerConfig(stage);
        } else {
            gameManager.startTheGame(stage);
            //GameManager.startGameController(stage);
        }
    }
}
