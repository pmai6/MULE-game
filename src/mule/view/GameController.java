package mule.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import mule.*;
import mule.model.Mountain1;
import mule.model.Mountain2;
import mule.model.Mountain3;
import mule.model.Plain;
import mule.model.River;
import mule.model.Store;
import mule.model.Tile;

public final class GameController {
    private GameManager gameManager;
    private Main mainapp;
    @FXML
    private AnchorPane town;
    @FXML
    private AnchorPane Pub;
    @FXML
    private AnchorPane Store;
    @FXML
    private Button gambleButton;
    @FXML
    private HBox map;
    @FXML
    private Label gamestate;
    @FXML
    private HBox playerthree;
    @FXML
    private HBox playerfour;
    @FXML
    private TextField purchaseQtyBox;
    @FXML
    private ComboBox<String> transactionBuyCombo;
    @FXML
    private ComboBox<String> transactionSellCombo;
    @FXML
    private GridPane mapGrid;
    private Button[][] mapButtonArray;
    @FXML
    private Label foodLabel;
    @FXML
    private Label smithOreLabel;
    @FXML
    private Label crystiteLabel;
    @FXML
    private Label energyLabel;
    @FXML
    private Label foodMuleLabel;
    @FXML
    private Label energyMuleLabel;
    @FXML
    private Label crystiteMuleLabel;
    @FXML
    private Label oreMuleLabel;
    @FXML
    private Label playerOneName;
    @FXML
    private Label playerOneRace;
    @FXML
    private Label playerOneScore;
    @FXML
    private Label playerOneMoney;
    @FXML
    private Label playerOneOre;
    @FXML
    private Label playerOneFood;
    @FXML
    private Label playerOneEnergy;
    @FXML
    private Label playerTwoName;
    @FXML
    private Label playerTwoRace;
    @FXML
    private Label playerTwoScore;
    @FXML
    private Label playerTwoMoney;
    @FXML
    private Label playerTwoOre;
    @FXML
    private Label playerTwoFood;
    @FXML
    private Label playerTwoEnergy;
    @FXML
    private Label playerThreeName;
    @FXML
    private Label playerThreeRace;
    @FXML
    private Label playerThreeScore;
    @FXML
    private Label playerThreeMoney;
    @FXML
    private Label playerThreeOre;
    @FXML
    private Label playerThreeFood;
    @FXML
    private Label playerThreeEnergy;
    @FXML
    private Label playerFourName;
    @FXML
    private Label playerFourRace;
    @FXML
    private Label playerFourScore;
    @FXML
    private Label playerFourMoney;
    @FXML
    private Label playerFourOre;
    @FXML
    private Label playerFourFood;
    @FXML
    private Label playerFourEnergy;
    @FXML
    private Label currentPlayer;
    @FXML
    private Label roundNumber;
    @FXML
    private Label timerLabel;
    private Timer timer;
    private String purchaseQty;
    // Arrays for Combo - pull down boxes
    private ObservableList<String> transactionBuyComboData = FXCollections
            .observableArrayList();
    private ObservableList<String> transactionSellComboData = FXCollections
            .observableArrayList();
    @FXML
    private Button saveGameButton;
    private javafx.collections.ObservableList<String> purchaseChoiceBoxData =
            javafx.collections.FXCollections.observableArrayList();

    public GameController() {

    }

    public Button[][] getButtonArray() {
        return mapButtonArray;
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
        transactionBuyComboData.add(" ");
        transactionBuyComboData.add("Food");
        transactionBuyComboData.add("Smithore");
        transactionBuyComboData.add("Energy");
        transactionBuyComboData.add("Crystite");
        transactionBuyComboData.add("Food Mule");
        transactionBuyComboData.add("Energy Mule");
        transactionBuyComboData.add("Crystite Mule");
        transactionBuyComboData.add("Smithore Mule");

        gameManager = GameManager.getGameManager();
        transactionBuyComboData.add(" ");
        transactionBuyComboData.add("Food");
        transactionBuyComboData.add("Smithore");
        transactionBuyComboData.add("Energy");
        transactionBuyComboData.add("Crystite");
        transactionBuyComboData.add("Food Mule");
        transactionBuyComboData.add("Energy Mule");
        transactionBuyComboData.add("Crystite Mule");
        transactionBuyComboData.add("Smithore Mule");

        transactionSellComboData.add(" ");
        transactionSellComboData.add("Food");
        transactionSellComboData.add("Smithore");
        transactionSellComboData.add("Energy");
        transactionSellComboData.add("Crystite");

        transactionBuyCombo.setItems(transactionBuyComboData);
        transactionSellCombo.setItems(transactionSellComboData);

        mapButtonArray = new Button[5][9];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                mapButtonArray[i][j] = new Button();
                mapGrid.add(mapButtonArray[i][j], j, i);

                mapButtonArray[i][j].minWidth(45.0);
                mapButtonArray[i][j].minWidth(45.0);
                mapButtonArray[i][j].prefHeight(60.0);
                mapButtonArray[i][j].prefWidth(60.0);
            }
        }
        mapButtonArray[0][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[0][0]);
            }
        });
        mapButtonArray[0][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[0][1]);
            }
        });
        mapButtonArray[0][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[0][2]);
            }
        });
        mapButtonArray[0][3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[0][3]);
            }
        });
        mapButtonArray[0][4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[0][4]);
            }
        });
        mapButtonArray[0][5].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[0][5]);
            }
        });
        mapButtonArray[0][6].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[0][6]);
            }
        });
        mapButtonArray[0][7].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[0][7]);
            }
        });
        mapButtonArray[0][8].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[0][8]);
            }
        });

        mapButtonArray[1][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[1][0]);
            }
        });
        mapButtonArray[1][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[1][1]);
            }
        });
        mapButtonArray[1][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[1][2]);
            }
        });
        mapButtonArray[1][3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[1][3]);
            }
        });
        mapButtonArray[1][4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[1][4]);
            }
        });
        mapButtonArray[1][5].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[1][5]);
            }
        });
        mapButtonArray[1][6].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[1][6]);
            }
        });
        mapButtonArray[1][7].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[1][7]);
            }
        });
        mapButtonArray[1][8].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[1][8]);
            }
        });

        mapButtonArray[2][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[2][0]);
            }
        });
        mapButtonArray[2][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[2][1]);
            }
        });
        mapButtonArray[2][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[2][2]);
            }
        });
        mapButtonArray[2][3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[2][3]);
            }
        });
        mapButtonArray[2][4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                goToTownButton();
            }
        });
        mapButtonArray[2][5].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[2][5]);
            }
        });
        mapButtonArray[2][6].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[2][6]);
            }
        });
        mapButtonArray[2][7].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[2][7]);
            }
        });
        mapButtonArray[2][8].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[2][8]);
            }
        });

        mapButtonArray[3][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[3][0]);
            }
        });
        mapButtonArray[3][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[3][1]);
            }
        });
        mapButtonArray[3][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[3][2]);
            }
        });
        mapButtonArray[3][3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[3][3]);
            }
        });
        mapButtonArray[3][4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[3][4]);
            }
        });
        mapButtonArray[3][5].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[3][5]);
            }
        });
        mapButtonArray[3][6].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[3][6]);
            }
        });
        mapButtonArray[3][7].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[3][7]);
            }
        });
        mapButtonArray[3][8].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[3][8]);
            }
        });

        mapButtonArray[4][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[4][0]);
            }
        });
        mapButtonArray[4][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[4][1]);
            }
        });
        mapButtonArray[4][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[4][2]);
            }
        });
        mapButtonArray[4][3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[4][3]);
            }
        });
        mapButtonArray[4][4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[4][4]);
            }
        });
        mapButtonArray[4][5].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[4][5]);
            }
        });
        mapButtonArray[4][6].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[4][6]);
            }
        });
        mapButtonArray[4][7].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[4][7]);
            }
        });
        mapButtonArray[4][8].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                gameManager.handleMapButton(mapButtonArray[4][8]);
            }
        });


    }

    public final void setTimer(int time) {
        timer = new Timer(time);
        setTimerLabel(timer, timerLabel);
        timer.startTimer();
    }

    @FXML
    public void setTimerLabel(Timer timer, Label timerLabel) {
        timerLabel.textProperty().bind(timer.getTimeSeconds().asString());
        timerLabel.setTextFill(Color.RED);
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


    @FXML
    private void goToStorebButton() {
        gameManager.updateStoreData();
        town.setVisible(false);
        map.setVisible(false);
        Store.setVisible(true);
    }

    //Empty method but necessary for combo box to work - DO NOT ERASE
    @FXML
    private void handleTransactionAction() {

    }

    @FXML
    private void submitPurchaseAction() throws Exception {
        purchaseQty = purchaseQtyBox.getText();
        String selectedSellTransaction = transactionSellCombo.getSelectionModel()
                .getSelectedItem();
        String selectedBuyTransaction = transactionBuyCombo.getSelectionModel()
                .getSelectedItem();
        if (selectedBuyTransaction != null) {
            if (selectedBuyTransaction.equalsIgnoreCase("Food")) {
                StoreManager.exportFood(Integer.parseInt(purchaseQty));
            } else if (selectedBuyTransaction.equalsIgnoreCase("Smithore")) {
                StoreManager.exportSmithore(Integer.parseInt(purchaseQty));
            } else if (selectedBuyTransaction.equalsIgnoreCase("Energy")) {
                StoreManager.exportEnergy(Integer.parseInt(purchaseQty));
            } else if (selectedBuyTransaction.equalsIgnoreCase("Crystite")) {
                StoreManager.exportCrystite(Integer.parseInt(purchaseQty));
            } else if (selectedBuyTransaction.equalsIgnoreCase("Food Mule")) {
                StoreManager.buyMule(selectedBuyTransaction);
            } else if (selectedBuyTransaction.equalsIgnoreCase("Smithore "
                    + "Mule")) {
                StoreManager.buyMule(selectedBuyTransaction);
            } else if (selectedBuyTransaction.equalsIgnoreCase("Energy Mule")) {
                StoreManager.buyMule(selectedBuyTransaction);
            } else if (selectedBuyTransaction.equalsIgnoreCase("Crystite "
                    + "Mule")) {
                StoreManager.buyMule(selectedBuyTransaction);
            }
        }
        //Null point exception, need to check what's going on with the sell
        // method

        if (selectedSellTransaction != null) {
            if (selectedSellTransaction.equalsIgnoreCase("Food")) {
                StoreManager.importFood(Integer.parseInt(purchaseQty));
            } else if (selectedSellTransaction.equalsIgnoreCase("Smithore")) {
                StoreManager.importSmithore(Integer.parseInt(purchaseQty));
            } else if (selectedSellTransaction.equalsIgnoreCase("Energy")) {
                StoreManager.importEnergy(Integer.parseInt(purchaseQty));
            } else if (selectedSellTransaction.equalsIgnoreCase("Crystite")) {
                StoreManager.importCrystite(Integer.parseInt(purchaseQty));
            } else if (selectedSellTransaction.equalsIgnoreCase("Food Mule")) {
                StoreManager.buyMule(selectedSellTransaction);
            }
        }

        transactionSellCombo.valueProperty().set(null);
        transactionBuyCombo.valueProperty().set(null);
    }


    @FXML
    private void exitStoreButtonAction() throws Exception {
        Store.setVisible(false);
        town.setVisible(true);
        map.setVisible(false);
    }

    @FXML
    private void goToPubButton() {
        town.setVisible(false);
        map.setVisible(false);
        Pub.setVisible(true);
    }

    @FXML
    private void exitPubButtonAction() throws Exception {
        Pub.setVisible(false);
        town.setVisible(true);
        map.setVisible(false);
    }

    @FXML
    private void gambleButton() throws Exception {
        PlayerManager player = new PlayerManager();
        player.gambleInPub();
        exitButtonAction();
    }

    @FXML
    public void exitButtonAction() throws Exception {
        Pub.setVisible(false);
        Store.setVisible(false);
        town.setVisible(false);
        map.setVisible(true);
    }

    @FXML
    private void goToTownButton() {
        //if (!Game.isLandSelectionPhase()) {
        map.setVisible(false);
        town.setVisible(true);
        // }
    }

    @FXML
    private void passTurnButton() {
        RoundManager.playerFinishedTurn(true);
    }

    @FXML
    private void saveGame() throws Exception {
        GameManager.saveGame();
    }

    public void disablePlayerThree() {
        playerthree.setVisible(false);
    }

    public void disablePlayerFour() {
        playerfour.setVisible(false);
    }

    public void setGameStateLabel(String input) {
        gamestate.setText(input);
    }

    public void changePlayerOneGuiStats(
            String name, String race, int score,
            int money, int ore, int food, String
                    color, int energy) {
        playerOneName.setText(name);
        playerOneName.setStyle(" -fx-text-fill :" + color + ";");
        playerOneRace.setText(race);
        playerOneScore.setText(String.valueOf(score));
        playerOneMoney.setText(String.valueOf(money));
        playerOneOre.setText(String.valueOf(ore));
        playerOneFood.setText(String.valueOf(food));
        playerOneEnergy.setText(String.valueOf(energy));
    }


    public void changePlayerTwoGuiStats(
            String name, String race, int score,
            int money, int ore, int food, String
                    color, int energy) {
        playerTwoName.setText(name);
        playerTwoName.setStyle(" -fx-text-fill :" + color + ";");

        playerTwoRace.setText(race);
        playerTwoScore.setText(String.valueOf(score));
        playerTwoMoney.setText(String.valueOf(money));
        playerTwoOre.setText(String.valueOf(ore));
        playerTwoFood.setText(String.valueOf(food));
        playerTwoEnergy.setText(String.valueOf(energy));

    }

    public void changePlayerThreeGuiStats(
            String name, String race, int score,
            int money, int ore, int food,
            String color, int energy) {
        playerThreeName.setText(name);
        playerThreeName.setStyle(" -fx-text-fill :" + color + ";");
        playerThreeRace.setText(race);
        playerThreeScore.setText(String.valueOf(score));
        playerThreeMoney.setText(String.valueOf(money));
        playerThreeOre.setText(String.valueOf(ore));
        playerThreeFood.setText(String.valueOf(food));
        playerThreeEnergy.setText(String.valueOf(energy));
    }

    public void changePlayerFourGuiStats(
            String name, String race, int score,
            int money, int ore, int food,
            String color, int energy) {
        playerFourName.setText(name);
        playerFourName.setStyle(" -fx-text-fill :" + color + ";");
        playerFourRace.setText(race);
        playerFourScore.setText(String.valueOf(score));
        playerFourMoney.setText(String.valueOf(money));
        playerFourOre.setText(String.valueOf(ore));
        playerFourFood.setText(String.valueOf(food));
        playerFourEnergy.setText(String.valueOf(energy));
    }

    public void setCurrentPlayer(String player) {
        currentPlayer.setText(player);
    }

    public void setRoundNumber(int round) {
        roundNumber.setText(String.valueOf(round));
    }


    public void updateStoreData(
            int food, int energy, int smithore, int
            crystite, int foodMule, int energyMule, int crystiteMule, int
            oreMule) {
        foodLabel.setText(new Integer(food).toString());
        energyLabel.setText(new Integer(energy).toString());
        smithOreLabel.setText(new Integer(smithore).toString());
        crystiteLabel.setText(new Integer(crystite).toString());
        foodMuleLabel.setText(new Integer(foodMule).toString());
        energyMuleLabel.setText(new Integer(energyMule).toString());
        crystiteMuleLabel.setText(new Integer(crystiteMule).toString());
        oreMuleLabel.setText(new Integer(oreMule).toString());
    }

    public void youGotNoResources() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("You don't have enough item");

        alert.showAndWait();
    }


    public void placingMule() throws Exception {
        Image imageplain = new Image(getClass()
                .getResourceAsStream("../resources/baby.png"));

        map.setCursor(new ImageCursor(imageplain));
        exitButtonAction();
    }


    public void badMulePlacement() {
        map.setCursor(Cursor.DEFAULT);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("You lost your mule!");
        alert.showAndWait();
    }


    public void youGotNoMoney() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("You don't have enough money");

        alert.showAndWait();
    }


    public void randomEventDialog(String random) {
        map.setCursor(Cursor.DEFAULT);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(random);
        alert.showAndWait();
    }

    public void addMuleToButton(Button button, Tile tile) {
        Image imageplain;
        if (tile instanceof Plain) {
            imageplain = new Image(getClass()
                    .getResourceAsStream("../resources/brownMule.png"));
        } else if (tile instanceof Mountain1) {
            imageplain = new Image(getClass()
                    .getResourceAsStream("../resources/mountain1Mule.png"));
        } else if (tile instanceof Mountain2) {
            imageplain = new Image(getClass()
                    .getResourceAsStream("../resources/mountain2Mule.png"));
        } else if (tile instanceof Mountain3) {
            imageplain = new Image(getClass()
                    .getResourceAsStream("../resources/mountain3Mule.png"));
        } else {
            imageplain = new Image(getClass()
                    .getResourceAsStream("../resources/riverMule.gif"));
        }

        button.setGraphic(new ImageView(imageplain));
        setCursorDefault();
    }

    public void addImageToButton(Button button, Tile tile) {
        Image imageplain;
        if (button == mapButtonArray[2][4]) { //town button
            imageplain = new Image(getClass()
                    .getResourceAsStream("../resources/town.gif"));
        } else if (tile instanceof Mountain1) {
            imageplain = new Image(getClass()
                    .getResourceAsStream("../resources/mountain1.png"));
        } else if (tile instanceof Mountain2) {
            imageplain = new Image(getClass()
                    .getResourceAsStream("../resources/mountain2.png"));
        } else if (tile instanceof Mountain3) {
            imageplain = new Image(getClass()
                    .getResourceAsStream("../resources/mountain3.png"));
        } else if (tile instanceof River) {
            imageplain = new Image(getClass()
                    .getResourceAsStream("../resources/river.gif"));
        } else {
            imageplain = new Image(getClass()
                    .getResourceAsStream("../resources/brown.png"));
        }
        button.setGraphic(new ImageView(imageplain));
    }

    public void setCursorDefault() {
        map.setCursor(Cursor.DEFAULT);
    }


    public int getTimeLeft() {
        return timer.getIntTimeLeft();
    }

    public void stopTimer() {
        timer.stopTimer();
    }
}





