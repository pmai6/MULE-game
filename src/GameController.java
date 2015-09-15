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


public class GameController {

    //creating Main object so can talk to Main methods
    private Main mainapp;


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
    private void nextButtonAction() throws Exception {
        Stage stage;
    }
}
