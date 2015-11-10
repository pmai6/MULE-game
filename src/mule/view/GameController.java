package mule.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;


import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import mule.*;
import mule.model.Mountain1;
import mule.model.Mountain2;
import mule.model.Mountain3;
import mule.model.Plain;
import mule.model.River;
import mule.model.Tile;

/**
 * The type Game controller.
 */
public final class GameController {
    /**
     * The Game manager.
     */
    private GameManager gameManager;
    /**
     * The Mainapp.
     */
    private Main mainapp;
    /**
     * The Town.
     */
    @FXML
    private AnchorPane town;
    /**
     * The Pub.
     */
    @FXML
    private AnchorPane pub;
    /**
     * The Store.
     */
    @FXML
    private AnchorPane store;
    /**
     * The Gamble button.
     */
    @FXML
    private Button gambleButton;
    /**
     * The Map.
     */
    @FXML
    private HBox map;
    /**
     * The Gamestate.
     */
    @FXML


    private Label gamestate;
    /**
     * The Playerthree.
     */
    @FXML
    private HBox playerthree;
    /**
     * The Playerfour.
     */
    @FXML
    private HBox playerfour;
    /**
     * The Purchase qty box.
     */
    @FXML
    private TextField purchaseQtyBox;
    /**
     * The Transaction buy combo.
     */
    @FXML
    private ComboBox<String> transactionBuyCombo;
    /**
     * The Transaction sell combo.
     */
    @FXML
    private ComboBox<String> transactionSellCombo;
    /**
     * The Map grid.
     */
    @FXML
    private GridPane mapGrid;
    /**
     * The Map button array.
     */
    private Button[][] mapButtonArray;
    /**
     * The Food label.
     */
    @FXML
    private Label foodLabel;
    /**
     * The Smith ore label.
     */
    @FXML
    private Label smithOreLabel;
    /**
     * The Crystite label.
     */
    @FXML
    private Label crystiteLabel;
    /**
     * The Energy label.
     */
    @FXML
    private Label energyLabel;
    /**
     * The Food mule label.
     */
    @FXML
    private Label foodMuleLabel;
    /**
     * The Energy mule label.
     */
    @FXML
    private Label energyMuleLabel;
    /**
     * The Crystite mule label.
     */
    @FXML
    private Label crystiteMuleLabel;
    /**
     * The Ore mule label.
     */
    @FXML
    private Label oreMuleLabel;
    /**
     * The Player one name.
     */
    @FXML
    private Label playerOneName;
    /**
     * The Player one race.
     */
    @FXML
    private Label playerOneRace;
    /**
     * The Player one score.
     */
    @FXML
    private Label playerOneScore;
    /**
     * The Player one money.
     */
    @FXML
    private Label playerOneMoney;
    /**
     * The Player one ore.
     */
    @FXML
    private Label playerOneOre;
    /**
     * The Player one food.
     */
    @FXML
    private Label playerOneFood;
    /**
     * The Player one energy.
     */
    @FXML
    private Label playerOneEnergy;
    /**
     * The Player two name.
     */
    @FXML
    private Label playerTwoName;
    /**
     * The Player two race.
     */
    @FXML
    private Label playerTwoRace;
    /**
     * The Player two score.
     */
    @FXML
    private Label playerTwoScore;
    /**
     * The Player two money.
     */
    @FXML
    private Label playerTwoMoney;
    /**
     * The Player two ore.
     */
    @FXML
    private Label playerTwoOre;
    /**
     * The Player two food.
     */
    @FXML
    private Label playerTwoFood;
    /**
     * The Player two energy.
     */
    @FXML
    private Label playerTwoEnergy;
    /**
     * The Player three name.
     */
    @FXML
    private Label playerThreeName;
    /**
     * The Player three race.
     */
    @FXML
    private Label playerThreeRace;
    /**
     * The Player three score.
     */
    @FXML
    private Label playerThreeScore;
    /**
     * The Player three money.
     */
    @FXML
    private Label playerThreeMoney;
    /**
     * The Player three ore.
     */
    @FXML
    private Label playerThreeOre;
    /**
     * The Player three food.
     */
    @FXML
    private Label playerThreeFood;
    /**
     * The Player three energy.
     */
    @FXML
    private Label playerThreeEnergy;
    /**
     * The Player four name.
     */
    @FXML
    private Label playerFourName;
    /**
     * The Player four race.
     */
    @FXML
    private Label playerFourRace;
    /**
     * The Player four score.
     */
    @FXML
    private Label playerFourScore;
    /**
     * The Player four money.
     */
    @FXML
    private Label playerFourMoney;
    /**
     * The Player four ore.
     */
    @FXML
    private Label playerFourOre;
    /**
     * The Player four food.
     */
    @FXML
    private Label playerFourFood;
    /**
     * The Player four energy.
     */
    @FXML
    private Label playerFourEnergy;
    /**
     * The Current player.
     */
    @FXML
    private Label currentPlayer;
    /**
     * The Round number.
     */
    @FXML
    private Label roundNumber;
    /**
     * The Timer label.
     */
    @FXML
    private Label timerLabel;
    /**
     * The Timer.
     */
    private Timer timer;
    /**
     * The Purchase qty.
     */
    private String purchaseQty;
    /**
     * The Transaction buy combo data.
     */
// Arrays for Combo - pull down boxes
    private ObservableList<String> transactionBuyComboData = FXCollections
            .observableArrayList();
    /**
     * The Transaction sell combo data.
     */
    private ObservableList<String> transactionSellComboData = FXCollections
            .observableArrayList();
    /**
     * The Save game button.
     */
    @FXML
    private Button saveGameButton;
    /**
     * The Purchase choice box data.
     */
    private javafx.collections.ObservableList<String> purchaseChoiceBoxData =
            javafx.collections.FXCollections.observableArrayList();

    /**
     * Instantiates a new Game controller.
     */
    public GameController() {

    }

    /**
     * Get button array button [ ] [ ].
     *
     * @return the button [ ] [ ]
     */
    public Button[][] getButtonArray() {
        return mapButtonArray;
    }

    /**
     * Sets main app.
     *
     * @param aMainapp the a mainapp
     */
    public void setMainApp(Main aMainapp) {
        this.mainapp = aMainapp;
    }

    /**
     * Initialize.
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
        setupButtons1();
        setupButtons2();


    }

    /**
     * Sets buttons 1.
     */
    public void setupButtons1() {
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
    }

    /**
     * Sets buttons 2.
     */
    public void setupButtons2() {
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

    /**
     * Sets timer.
     *
     * @param time the time
     */
    public void setTimer(int time) {
        timer = new Timer(time);
        setTimerLabel(timer, timerLabel);
        timer.startTimer();
    }

    /**
     * Sets timer label.
     *
     * @param aTimer      the a timer
     * @param aTimerLabel the a timer label
     */
    @FXML
    public void setTimerLabel(Timer aTimer, Label aTimerLabel) {
        aTimerLabel.textProperty().bind(aTimer.getTimeSeconds().asString());
        aTimerLabel.setTextFill(Color.RED);
    }

    /**
     * Handle store action.
     */
    @FXML
    private void handleStoreAction() {
        // System.out.println("Store Opens");
    }

    /**
     * Handle land office action.
     */
    @FXML
    private void handleLandOfficeAction() {
        // System.out.println("Land Office Opens");
    }

    /**
     * Handle assay office action.
     */
    @FXML
    private void handleAssayOfficeAction() {
        // System.out.println("Assay Office Opens");
    }

    /**
     * Go to storeb button.
     */
    @FXML
    private void goToStorebButton() {
        gameManager.updateStoreData();
        town.setVisible(false);
        map.setVisible(false);
        store.setVisible(true);
    }

    /**
     * Handle transaction action.
     */
    @FXML
    private void handleTransactionAction() {

    }

    /**
     * Submit purchase action.
     *
     * @throws Exception the exception
     */
    @FXML
    private void submitPurchaseAction() throws Exception {
        purchaseQty = purchaseQtyBox.getText();
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

        transactionSellCombo.valueProperty().set(null);
        transactionBuyCombo.valueProperty().set(null);
    }

    /**
     * Submit buy action.
     *
     * @throws Exception the exception
     */
    @FXML
    private void submitBuyAction() throws Exception {
        purchaseQty = purchaseQtyBox.getText();
        String selectedSellTransaction = transactionSellCombo.getSelectionModel(
        ).getSelectedItem();
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

    /**
     * Exit store button action.
     *
     * @throws Exception the exception
     */
    @FXML
    private void exitStoreButtonAction() throws Exception {
        store.setVisible(false);
        town.setVisible(true);
        map.setVisible(false);
    }

    /**
     * Go to pub button.
     */
    @FXML
    private void goToPubButton() {
        town.setVisible(false);
        map.setVisible(false);
        pub.setVisible(true);
    }

    /**
     * Exit pub button action.
     *
     * @throws Exception the exception
     */
    @FXML
    private void exitPubButtonAction() throws Exception {
        pub.setVisible(false);
        town.setVisible(true);
        map.setVisible(false);
    }

    /**
     * Gamble button.
     *
     * @throws Exception the exception
     */
    @FXML
    private void gambleButton() throws Exception {
        PlayerManager player = new PlayerManager();
        player.gambleInPub();
        exitButtonAction();
    }

    /**
     * Exit button action.
     *
     * @throws Exception the exception
     */
    @FXML
    public void exitButtonAction() throws Exception {
        pub.setVisible(false);
        store.setVisible(false);
        town.setVisible(false);
        map.setVisible(true);
    }

    /**
     * Go to town button.
     */
    @FXML
    private void goToTownButton() {
        //if (!Game.isLandSelectionPhase()) {
        map.setVisible(false);
        town.setVisible(true);
        // }
    }

    /**
     * Pass turn button.
     */
    @FXML
    private void passTurnButton() {
        RoundManager.playerFinishedTurn(true);
    }

    /**
     * Save game.
     *
     * @throws Exception the exception
     */
    @FXML
    private void saveGame() throws Exception {
        GameManager.saveGame();
    }

    /**
     * Disable player three.
     */
    public void disablePlayerThree() {
        playerthree.setVisible(false);
    }

    /**
     * Disable player four.
     */
    public void disablePlayerFour() {
        playerfour.setVisible(false);
    }

    /**
     * Sets game state label.
     *
     * @param input the input
     */
    public void setGameStateLabel(String input) {
        gamestate.setText(input);
    }

    /**
     * Change player one gui stats.
     *
     * @param name   the name
     * @param race   the race
     * @param score  the score
     * @param money  the money
     * @param ore    the ore
     * @param food   the food
     * @param color  the color
     * @param energy the energy
     */
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

    /**
     * Change player two gui stats.
     *
     * @param name   the name
     * @param race   the race
     * @param score  the score
     * @param money  the money
     * @param ore    the ore
     * @param food   the food
     * @param color  the color
     * @param energy the energy
     */
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

    /**
     * Change player three gui stats.
     *
     * @param name   the name
     * @param race   the race
     * @param score  the score
     * @param money  the money
     * @param ore    the ore
     * @param food   the food
     * @param color  the color
     * @param energy the energy
     */
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

    /**
     * Change player four gui stats.
     *
     * @param name   the name
     * @param race   the race
     * @param score  the score
     * @param money  the money
     * @param ore    the ore
     * @param food   the food
     * @param color  the color
     * @param energy the energy
     */
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

    /**
     * Sets current player.
     *
     * @param player the player
     */
    public void setCurrentPlayer(String player) {
        currentPlayer.setText(player);
    }

    /**
     * Sets round number.
     *
     * @param round the round
     */
    public void setRoundNumber(int round) {
        roundNumber.setText(String.valueOf(round));
    }

    /**
     * Update store data.
     *
     * @param food         the food
     * @param energy       the energy
     * @param smithore     the smithore
     * @param crystite     the crystite
     * @param foodMule     the food mule
     * @param energyMule   the energy mule
     * @param crystiteMule the crystite mule
     * @param oreMule      the ore mule
     */
    public void updateStoreData(
            int food, int energy, int smithore, int
            crystite, int foodMule, int energyMule, int crystiteMule, int
                    oreMule) {
        foodLabel.setText(Integer.toString(food));
        energyLabel.setText(Integer.toString(energy));
        smithOreLabel.setText(Integer.toString(smithore));
        crystiteLabel.setText(Integer.toString(crystite));
        foodMuleLabel.setText(Integer.toString(foodMule));
        energyMuleLabel.setText(Integer.toString(energyMule));
        crystiteMuleLabel.setText(Integer.toString(crystiteMule));
        oreMuleLabel.setText(Integer.toString(oreMule));
    }

    /**
     * You got no resources.
     */
    public void youGotNoResources() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("You don't have enough item");

        alert.showAndWait();
    }

    /**
     * Placing mule.
     *
     * @throws Exception the exception
     */
    public void placingMule() throws Exception {
        Image imageplain = new Image(getClass()
                .getResourceAsStream("../resources/baby.png"));

        map.setCursor(new ImageCursor(imageplain));
        exitButtonAction();
    }

    /**
     * Bad mule placement.
     */
    public void badMulePlacement() {
        map.setCursor(Cursor.DEFAULT);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("You lost your mule!");
        alert.showAndWait();
    }

    /**
     * You got no money.
     */
    public void youGotNoMoney() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("You don't have enough money");

        alert.showAndWait();
    }

    /**
     * Random event dialog.
     *
     * @param random the random
     */
    public void randomEventDialog(String random) {
        map.setCursor(Cursor.DEFAULT);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(random);
        alert.showAndWait();
    }

    /**
     * Add mule to button.
     *
     * @param button the button
     * @param tile   the tile
     */
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

    /**
     * Add image to button.
     *
     * @param button the button
     * @param tile   the tile
     */
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

    /**
     * Sets cursor default.
     */
    public void setCursorDefault() {
        map.setCursor(Cursor.DEFAULT);
    }

    /**
     * Gets time left.
     *
     * @return the time left
     */
    public int getTimeLeft() {
        return timer.getIntTimeLeft();
    }

    /**
     * Stop timer.
     */
    public void stopTimer() {
        timer.stopTimer();
    }
}





