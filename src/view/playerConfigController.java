import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.paint.*;
import javafx.stage.Stage;

import javafx.scene.control.TextField;
import java.util.List;


public class playerConfigController {

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
        // Init ComboBox's
        raceComboData.add("Human");
        raceComboData.add("Ugaite");
        raceComboData.add("Flapper");
        raceComboData.add("Bonzoid");
        raceComboData.add("Buzzite");


        List<String> colorList;
        colorList = Game.getMulegame().getColor();
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
    }


    @FXML
    private void nextButtonAction() throws Exception {
        Stage stage;
        stage = (Stage) nextButton.getScene().getWindow();
        Game.getMulegame().getColor().remove(selectedColor);

        playerName =  playerNameBox.getText();
        Player.createNewGamePlayer(playerName,
                selectedRace, selectedColor);


        if (Game.getMulegame().getN() > 1) {
            Game.getMulegame().setN(Game.getMulegame().getN() - 1);
            mainapp.startPlayerConfig(stage);
        } else {
            System.out.println("This is where the game opens");
            GameManager.startTheGame(stage);
            //GameManager.startGameController(stage);
        }
    }
}
