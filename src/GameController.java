import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.*;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.Label;
import java.awt.TextField;


public class GameController {

    //creating Main object so can talk to Main methods
    private Main mainapp;
    @FXML
    private Button goToTown;
    @FXML
    private AnchorPane town;
    @FXML
    private HBox map;
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

    public  GameController() {
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
       for (Player newplayer : Game.getMulegame().getPlayerArray()) {
            System.out.println(newplayer.getPlayerName() + " " + newplayer
                    .getPlayerColor() + " " + newplayer.getPlayerRace());
        }
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
        town.setVisible(false);
        map.setVisible(true);
    }
    @FXML
    private void goToTownButton() throws Exception {
        map.setVisible(false);
      town.setVisible(true);
    }
}
