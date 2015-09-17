import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.paint.*;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.Label;
import java.awt.TextField;


public class TownController {

    public javafx.scene.control.Label raceInfo;
    public javafx.scene.control.Label colorLabel;
    // variables to functionality to comboboxes and buttons
    @FXML
    private Button store;
    @FXML
    private Button landOffice;
    @FXML
    private Button assayOffice;
    @FXML
    private Button pub;
    @FXML
    private Button exit;


    //creating Main object so can talk to Main methods
    private Main mainapp;


    public  TownController() {
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
    }

    @FXML
    private void handleStoreAction() {
        System.out.println("Store Opens");
    }

    @FXML
    private void handleLandOfficeAction() {
        System.out.println("Land Office Opens");
    }

    @FXML
    private void handleAssayOfficeAction() {
        System.out.println("Assay Office Opens");
    }
    @FXML private void handlePubAction() {
        System.out.println("Time to get Drunk");
    }
    @FXML
    private void exitButtonAction() throws Exception {
        Stage stage;
        stage = (Stage) exit.getScene().getWindow();
        mainapp.startGameController(stage);
    }
}
