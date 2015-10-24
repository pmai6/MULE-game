package mule.view;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.paint.*;
import javafx.stage.Stage;

import javafx.scene.control.TextField;
import mule.GameManager;
import mule.Main;
import mule.PlayerManager;
import mule.model.Game;
import mule.model.Player;

import java.util.List;


public class playerConfigController {
private GameManager gameManager;
    public javafx.scene.control.Label raceInfo;
    public javafx.scene.control.Label colorLabel;
    // variables to functionality to comboboxes and buttons
    @FXML
    private ComboBox<String> raceCombo;
    @FXML
    private ComboBox<String> colorCombo;
    @FXML
    private Button nextButton;
    @FXML
    private TextField playerNameBox;


    //creating Main object so can talk to Main methods
    private Main mainapp;


    // Arrays for Combo - pull down boxes
    private ObservableList<String> raceComboData =
            FXCollections.observableArrayList();

    private ObservableList<String> colorComboData =
            FXCollections.observableArrayList();

    private String selectedRace;
    private String selectedColor;
    private String playerName;
    private String raceInfoValue;


    public  playerConfigController() {
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

    @FXML
    private void handleRaceComboAction() {
        selectedRace =
                raceCombo.getSelectionModel().getSelectedItem();
                if (raceCombo.getSelectionModel().getSelectedItem() == "Ugaite") {
                    raceInfo.setText("From the Nekite Galaxy. Ugaite love land. To get it they are willing to stick their necks out!");
                }
                if (raceCombo.getSelectionModel().getSelectedItem() == "Human") {
                    raceInfo.setText("From the Earth Systems. Humanoids start with $600 because they are too smart! Expert Species");
                }
                if (raceCombo.getSelectionModel().getSelectedItem() == "Bonzoid") {
                    raceInfo.setText("From the Armpull Galaxy. Bonzoids love climbing and are often found hanging around in the mountains");
                }
                if (raceCombo.getSelectionModel().getSelectedItem() == "Buzzite") {
                    raceInfo.setText("From the Jacket System. Love to fly high above the competition");
                }
                if (raceCombo.getSelectionModel().getSelectedItem() == "Flapper") {
                    raceInfo.setText("From the Boird-Drop Galaxy. All Flappers receive an extra $600 in their nest egg! Beginner Species");
                }
                if (raceCombo.getSelectionModel().getSelectedItem() == "Foilers") {
                    raceInfo.setText("(DLC content) Feel Free to Foil your enemies with this new character!");
                }
                if (raceCombo.getSelectionModel().getSelectedItem() == "Trillers") {
                    raceInfo.setText("(DLC content) Keepin it trill. Try and tolerate these terrifying terrors");
                }
                if (raceCombo.getSelectionModel().getSelectedItem() == "Yellers") {
                    raceInfo.setText("(DLC content) They're yellow. Thats about it");
                }
    }

    @FXML
    private void handleColorComboAction() {
        selectedColor =
                colorCombo.getSelectionModel().getSelectedItem();
                if (colorCombo.getSelectionModel().getSelectedItem() == "Red") {
                    colorLabel.setTextFill(javafx.scene.paint.Color.RED);
                }
                if (colorCombo.getSelectionModel().getSelectedItem() ==
                        "Blue") {
                    colorLabel.setTextFill(javafx.scene.paint.Color.BLUE);
                }
                if (colorCombo.getSelectionModel().getSelectedItem() ==
                        "Purple") {
                    colorLabel.setTextFill(javafx.scene.paint.Color.PURPLE);
                }
                if (colorCombo.getSelectionModel().getSelectedItem() ==
                        "Green") {
                    colorLabel.setTextFill(javafx.scene.paint.Color.GREEN);
                }
                if (colorCombo.getSelectionModel().getSelectedItem() == "Orange") {
                    colorLabel.setTextFill(javafx.scene.paint.Color.ORANGE);
                }
                if (colorCombo.getSelectionModel().getSelectedItem() == "Yellow") {
                    colorLabel.setTextFill(javafx.scene.paint.Color.YELLOW);
                }

    }


    @FXML
    private void nextButtonAction() throws Exception {
        Stage stage;
        stage = (Stage) nextButton.getScene().getWindow();
        gameManager.getMulegame().removeColor(selectedColor);

        playerName =  playerNameBox.getText();
        PlayerManager.createNewGamePlayer(playerName,
                selectedRace, selectedColor);


        if (gameManager.getMulegame().getN() > 1) {
            gameManager.getMulegame().setN(gameManager.getMulegame().getN() - 1);
            mainapp.startPlayerConfig(stage);
        } else {
            System.out.println("This is where the game opens");
            gameManager.startTheGame(stage);
            //GameManager.startGameController(stage);
        }
    }
}
