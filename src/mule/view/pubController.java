package mule.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.paint.*;
import javafx.stage.Stage;

import javafx.scene.control.TextField;
import mule.*;
import mule.GameManager;
import mule.PlayerManager;
import mule.RoundManager;
import mule.Main;
import mule.model.Game;
import mule.model.Player;
import mule.model.Round;
import mule.model.Turn;
import mule.Pub;

import java.util.List;

/**
 * Created by redcream12 on 9/29/15.
 */
public class pubController {
    // variables to functionality to buttons
    @FXML
    private Button exit;
    @FXML
    private Button gamble;
    @FXML
    private Label gamblePlayerMoney;
    @FXML
    private Label timeRemain;
    @FXML
    private Label moneyEarn;
    @FXML
    private Label timerLabel = new Label();


    //creating Main object so can talk to Main methods
    private Main mainapp;

    public  pubController() {
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
        PlayerManager player = new PlayerManager();
        // Display current wallet of player
        RoundManager.getCurrentPlayer().getMoneyProperty().addListener(new javafx.beans.value.ChangeListener() {
            @Override
            public void changed(javafx.beans.value.ObservableValue o, Object oldVal, Object newVal) {
                gamblePlayerMoney.setText(String.valueOf(RoundManager.getCurrentPlayer().getMoney()));
            }
        });
        // Display player's time remaining
        RoundManager.getCurrentPlayer().getMoneyProperty().addListener(new javafx.beans.value.ChangeListener() {
            @Override
            public void changed(javafx.beans.value.ObservableValue o, Object oldVal, Object newVal) {
                timeRemain.setText(String.valueOf(player.getTimeLeft()));
            }
        });
    }


//    @FXML
//    private void exitButtonAction() throws Exception {
//        pub.setVisible(false);
//        map.setVisible(true);
//    }

    @FXML
    private void gambleButton()  {
        PlayerManager player = new PlayerManager();
        player.gambleInPub();
    }

//    @FXML
//    private void ButtonAction() throws Exception {
//        Stage stage;
//        stage = (Stage) nextButton.getScene().getWindow();
//        Game.getMulegame().getColor().remove(selectedColor);
//
//        playerName =  playerNameBox.getText();
//        Player.createNewGamePlayer(playerName,
//                selectedRace, selectedColor);
//
//
//        if (Game.getMulegame().getN() > 1) {
//            Game.getMulegame().setN(Game.getMulegame().getN() - 1);
//            mainapp.startPlayerConfig(stage);
//        } else {
//            System.out.println("This is where the game opens");
//            GameManager.startTheGame(stage);
//            //GameManager.startGameController(stage);
//        }
//    }

    @FXML
    public void setTimerLabel(Label timer, timer Timer) {
        timer.textProperty().bind(Timer.getTimeSeconds().asString());
        timer.setTextFill(Color.RED);
    }
}

