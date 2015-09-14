import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.awt.*;


public class playerConfigController {

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
    private String selectedPlayerName;


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
        raceComboData.add("Packer");
        raceComboData.add("Spheroid");
        raceComboData.add("Humanoid");
        raceComboData.add("Leggite");
        raceComboData.add("Flapper");
        raceComboData.add("Bonzoid");
        raceComboData.add("Mechtron");

        colorComboData.add("purple");
        colorComboData.add("green");
        colorComboData.add("red");
        colorComboData.add("blue");

        raceCombo.setItems(raceComboData);
        colorCombo.setItems(colorComboData);
    }

    @FXML
    private void handleRaceComboAction() {
        selectedRace =
                raceCombo.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void handleColorComboAction() {
        selectedColor =
                colorCombo.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void handlePlayerNameComboAction() {
        selectedPlayerName = playerNameBox.getText();
    }

    @FXML
    private void nextButtonAction() throws Exception {
        Stage stage;
        stage = (Stage) nextButton.getScene().getWindow();
        //this is where you start the next screen


    }
}
