package mule.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import mule.model.*;

public class GameController {
    private GameManager gameManager;
    private Main mainapp;
    @FXML
    private Button goToTown;
    @FXML
    private Button goToPub;
    @FXML
    private Button goToStore;
    @FXML
    private Button passTurn;
    @FXML
    private Button startTurn;
    @FXML
    private Button submitPurchase;
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
    private Button store;

    @FXML
    private ChoiceBox<String> purchaseFood;
    @FXML
    private ChoiceBox<String> purchaseCrystite;
    @FXML
    private ChoiceBox<String> purchaseEnergy;
    @FXML
    private ChoiceBox<String> purchaseSmithore;
    @FXML
    private Button food;
    @FXML
    private Button ore;
    @FXML
    private Button smithore;
    @FXML
    private Button mule;
    @FXML
    private Button energys;
    @FXML
    private Button landOffice;
    @FXML
    private Button assayOffice;
    @FXML
    private Button pub;
    @FXML
    private Button exit;
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
    private Label currentPlayer;
    @FXML
    private Label roundNumber;
    @FXML
    private Label timerLabel;
    private timer Timer = new timer(10);

    private String selectedBuyTransaction;
    private String selectedSellTransaction;
    private String purchaseQty;

    // Arrays for Combo - pull down boxes
    private ObservableList<String> transactionBuyComboData = FXCollections.observableArrayList();
    private ObservableList<String> transactionSellComboData = FXCollections.observableArrayList();

    public GameController() {

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
        String[][] defaultMapLayout = GameMap.getMapLayout();
        for(int i=0; i<5; i++) {
                for (int j = 0; j<9 ; j++) {
                    mapButtonArray[i][j] = new Button();
                mapGrid.add(mapButtonArray[i][j], j, i);
                    String tileType = defaultMapLayout[i][j];

                    mapButtonArray[i][j].minWidth(45.0);
                    mapButtonArray[i][j].minWidth(45.0);
                    mapButtonArray[i][j].prefHeight(60.0);
                    mapButtonArray[i][j].prefWidth(60.0);

                    if (tileType.equals("P")) {
                        Image imageplain = new Image(getClass()
                                .getResourceAsStream("brown.png"));

                        mapButtonArray[i][j].setGraphic(new ImageView(imageplain));

                    } else if (tileType.equals("R")) {
                        Image imageplain = new Image(getClass()
                                .getResourceAsStream("river.png"));

                        mapButtonArray[i][j].setGraphic(new ImageView(imageplain));

                    } else if (tileType.equals("M1"))  {
                        Image imageplain = new Image(getClass()
                                .getResourceAsStream("mountain1.png"));

                        mapButtonArray[i][j].setGraphic(new ImageView(imageplain));
                    } else if (tileType.equals("M2")) {
                        Image imageplain = new Image(getClass()
                                .getResourceAsStream("mountain2.png"));

                        mapButtonArray[i][j].setGraphic(new ImageView(imageplain));
                    } else if (tileType.equals("M3")) {
                        Image imageplain = new Image(getClass()
                                .getResourceAsStream("mountain3.png"));

                        mapButtonArray[i][j].setGraphic(new ImageView(imageplain));
                    } else {
                        Image imageplain = new Image(getClass()
                                .getResourceAsStream("town.png"));

                        mapButtonArray[i][j].setGraphic(new ImageView(imageplain));
                    }

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

        gameManager.getMulegame().getPlayerArray().get(0).getMoneyProperty()
            .addListener
                (new
                     ChangeListener() {
                         @Override
                         public void changed(ObservableValue o, Object oldVal,
                                             Object newVal) {
                             playerOneMoney.setText(String.valueOf
                                 (gameManager
                                     .getMulegame().getPlayerArray().get
                                         (0).getMoney()));
                         }
                     });
        gameManager.getMulegame().getPlayerArray().get(1).getMoneyProperty()
            .addListener
                (new
                     ChangeListener() {
                         @Override
                         public void changed(ObservableValue o, Object oldVal,
                                             Object newVal) {
                             playerTwoMoney.setText(String.valueOf
                                 (gameManager
                                     .getMulegame().getPlayerArray().get
                                         (1).getMoney()));
                         }
                     });




        //get score listeners

        gameManager.getMulegame().getPlayerArray().get(0).getScoreProperty()
            .addListener
                (new
                     ChangeListener() {
                         @Override
                         public void changed(ObservableValue o, Object oldVal,
                                             Object newVal) {
                             playerOneScore.setText(String.valueOf
                                 (gameManager
                                     .getMulegame().getPlayerArray().get
                                         (0).getScore()));
                         }
                     });

        gameManager.getMulegame().getPlayerArray().get(1).getScoreProperty()
            .addListener
                (new
                     ChangeListener() {
                         @Override
                         public void changed(ObservableValue o, Object oldVal,
                                             Object newVal) {
                             playerTwoScore.setText(String.valueOf
                                 (gameManager
                                     .getMulegame().getPlayerArray().get
                                         (1).getScore()));
                         }
                     });



        //get score listeners

        gameManager.getMulegame().getPlayerArray().get(0).getScoreProperty()
            .addListener
                (new
                     ChangeListener() {
                         @Override
                         public void changed(ObservableValue o, Object oldVal,
                                             Object newVal) {
                             playerOneScore.setText(String.valueOf
                                 (gameManager
                                     .getMulegame().getPlayerArray().get
                                         (0).getScore()));
                         }
                     });

        gameManager.getMulegame().getPlayerArray().get(1).getScoreProperty()
            .addListener
                (new
                     ChangeListener() {
                         @Override
                         public void changed(ObservableValue o, Object oldVal,
                                             Object newVal) {
                             playerTwoScore.setText(String.valueOf
                                 (gameManager
                                     .getMulegame().getPlayerArray().get
                                         (1).getScore()));
                         }
                     });


        //get Ore listeners

        Game.getMulegame().getPlayerArray().get(0).getSmithoreProperty()
            .addListener
                (new
                     ChangeListener() {
                         @Override
                         public void changed(ObservableValue o, Object oldVal,
                                             Object newVal) {
                             playerOneOre.setText(String.valueOf
                                 (gameManager
                                     .getMulegame().getPlayerArray().get
                                         (0).getSmithore()));
                         }
                     });

        gameManager.getMulegame().getPlayerArray().get(1).getOreProperty()
            .addListener
                (new
                     ChangeListener() {
                         @Override
                         public void changed(ObservableValue o, Object oldVal,
                                             Object newVal) {
                             playerTwoOre.setText(String.valueOf
                                 (gameManager
                                     .getMulegame().getPlayerArray().get
                                         (1).getSmithore()));
                         }
                     });



        //get Food listeners

        gameManager.getMulegame().getPlayerArray().get(0).getFoodProperty()
            .addListener
                (new
                     ChangeListener() {
                         @Override
                         public void changed(ObservableValue o, Object oldVal,
                                             Object newVal) {
                             playerOneFood.setText(String.valueOf
                                 (gameManager
                                     .getMulegame().getPlayerArray().get
                                         (0).getFood()));
                         }
                     });

        gameManager.getMulegame().getPlayerArray().get(1).getFoodProperty()
            .addListener
                (new
                     ChangeListener() {
                         @Override
                         public void changed(ObservableValue o, Object oldVal,
                                             Object newVal) {
                             playerTwoFood.setText(String.valueOf
                                 (gameManager
                                     .getMulegame().getPlayerArray().get
                                         (1).getFood()));
                         }
                     });

        if (gameManager.getMulegame().getNumberOfPlayers() == 4) {


            gameManager.getMulegame().getPlayerArray().get(2).getMoneyProperty()
                .addListener
                    (new
                         ChangeListener() {
                             @Override
                             public void changed(ObservableValue o, Object oldVal,
                                                 Object newVal) {
                                 playerThreeMoney.setText(String.valueOf
                                     (gameManager
                                         .getMulegame().getPlayerArray().get
                                             (2).getMoney()));
                             }
                         });

            gameManager.getMulegame().getPlayerArray().get(3).getMoneyProperty()
                .addListener
                    (new
                         ChangeListener() {
                             @Override
                             public void changed(ObservableValue o, Object oldVal,
                                                 Object newVal) {
                                 playerFourMoney.setText(String.valueOf
                                     (gameManager
                                         .getMulegame().getPlayerArray().get
                                             (3).getMoney()));
                             }
                         });


            //get score listeners


            gameManager.getMulegame().getPlayerArray().get(2).getScoreProperty()
                .addListener
                    (new
                         ChangeListener() {
                             @Override
                             public void changed(ObservableValue o, Object oldVal,
                                                 Object newVal) {
                                 playerThreeScore.setText(String.valueOf
                                     (gameManager
                                         .getMulegame().getPlayerArray().get
                                             (2).getScore()));
                             }
                         });

            gameManager.getMulegame().getPlayerArray().get(3).getMoneyProperty()
                .addListener
                    (new
                         ChangeListener() {
                             @Override
                             public void changed(ObservableValue o, Object oldVal,
                                                 Object newVal) {
                                 playerFourScore.setText(String.valueOf
                                     (gameManager
                                         .getMulegame().getPlayerArray().get
                                             (3).getScore()));
                             }
                         });

            //get score listeners


            gameManager.getMulegame().getPlayerArray().get(2).getScoreProperty()
                .addListener
                    (new
                         ChangeListener() {
                             @Override
                             public void changed(ObservableValue o, Object oldVal,
                                                 Object newVal) {
                                 playerThreeScore.setText(String.valueOf
                                     (gameManager
                                         .getMulegame().getPlayerArray().get
                                             (2).getScore()));
                             }
                         });

            gameManager.getMulegame().getPlayerArray().get(3).getScoreProperty()
                .addListener
                    (new
                         ChangeListener() {
                             @Override
                             public void changed(ObservableValue o, Object oldVal,
                                                 Object newVal) {
                                 playerFourScore.setText(String.valueOf
                                     (gameManager
                                         .getMulegame().getPlayerArray().get
                                             (3).getScore()));
                             }
                         });

            //get Ore listeners

            
            gameManager.getMulegame().getPlayerArray().get(2).getSmithoreProperty()
                .addListener
                    (new
                         ChangeListener() {
                             @Override
                             public void changed(ObservableValue o, Object oldVal,
                                                 Object newVal) {
                                 playerThreeOre.setText(String.valueOf
                                     (gameManager
                                         .getMulegame().getPlayerArray().get
                                             (2).getSmithore()));
                             }
                         });
            
            gameManager.getMulegame().getPlayerArray().get(3).getSmithoreProperty()
                .addListener
                    (new
                         ChangeListener() {
                             @Override
                             public void changed(ObservableValue o, Object oldVal,
                                                 Object newVal) {
                                 playerFourOre.setText(String.valueOf
                                     (gameManager
                                         .getMulegame().getPlayerArray().get
                                             (3).getSmithore()));
                             }
                         });

            //get Food listeners


            gameManager.getMulegame().getPlayerArray().get(2).getFoodProperty()
                .addListener
                    (new
                         ChangeListener() {
                             @Override
                             public void changed(ObservableValue o, Object oldVal,
                                                 Object newVal) {
                                 playerThreeFood.setText(String.valueOf
                                     (gameManager
                                         .getMulegame().getPlayerArray().get
                                             (2).getFood()));
                             }
                         });

            gameManager.getMulegame().getPlayerArray().get(3).getFoodProperty()
                .addListener
                    (new
                         ChangeListener() {
                             @Override
                             public void changed(ObservableValue o, Object oldVal,
                                                 Object newVal) {
                                 playerFourFood.setText(String.valueOf
                                     (gameManager
                                         .getMulegame().getPlayerArray().get
                                             (3).getFood()));
                             }
                         });
        }

        if (gameManager.getMulegame().getNumberOfPlayers() == 3) {


            gameManager.getMulegame().getPlayerArray().get(2).getMoneyProperty()
                .addListener
                    (new
                         ChangeListener() {
                             @Override
                             public void changed(ObservableValue o, Object oldVal,
                                                 Object newVal) {
                                 playerThreeMoney.setText(String.valueOf
                                     (gameManager
                                         .getMulegame().getPlayerArray().get
                                             (2).getMoney()));
                             }
                         });




            //get score listeners



            gameManager.getMulegame().getPlayerArray().get(2).getScoreProperty()
                .addListener
                    (new
                         ChangeListener() {
                             @Override
                             public void changed(ObservableValue o, Object oldVal,
                                                 Object newVal) {
                                 playerThreeScore.setText(String.valueOf
                                     (gameManager
                                         .getMulegame().getPlayerArray().get
                                             (2).getScore()));
                             }
                         });



            //get score listeners


            gameManager.getMulegame().getPlayerArray().get(2).getScoreProperty()
                .addListener
                    (new
                         ChangeListener() {
                             @Override
                             public void changed(ObservableValue o, Object oldVal,
                                                 Object newVal) {
                                 playerThreeScore.setText(String.valueOf
                                     (gameManager
                                         .getMulegame().getPlayerArray().get
                                             (2).getScore()));
                             }
                         });



            //get Ore listeners



            gameManager.getMulegame().getPlayerArray().get(2).getSmithoreProperty()
                .addListener
                    (new
                         ChangeListener() {
                             @Override
                             public void changed(ObservableValue o, Object oldVal,
                                                 Object newVal) {
                                 playerThreeOre.setText(String.valueOf
                                     (gameManager
                                         .getMulegame().getPlayerArray().get
                                             (2).getSmithore()));
                             }
                         });



            //get Food listeners



            gameManager.getMulegame().getPlayerArray().get(2).getFoodProperty()
                .addListener
                    (new
                         ChangeListener() {
                             @Override
                             public void changed(ObservableValue o, Object oldVal,
                                                 Object newVal) {
                                 playerThreeFood.setText(String.valueOf
                                     (gameManager
                                         .getMulegame().getPlayerArray().get
                                             (2).getFood()));
                             }
                         });
        }
        }

    private javafx.collections.ObservableList<String> purchaseChoiceBoxData =
            javafx.collections.FXCollections.observableArrayList();


    public void setTimer() {
        setTimerLabel(Timer, timerLabel);
        Timer.startTimer();
    }
    @FXML
    public void setTimerLabel(timer Timer, Label timerLabel) {
        timerLabel.textProperty().bind(Timer.getTimeSeconds().asString());
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
        selectedSellTransaction = transactionSellCombo.getSelectionModel().getSelectedItem();
        selectedBuyTransaction = transactionBuyCombo.getSelectionModel().getSelectedItem();
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
        } else if (selectedBuyTransaction.equalsIgnoreCase("Smithore Mule")) {
            StoreManager.buyMule(selectedBuyTransaction);
        } else if (selectedBuyTransaction.equalsIgnoreCase("Energy Mule")) {
            StoreManager.buyMule(selectedBuyTransaction);
        } else if (selectedBuyTransaction.equalsIgnoreCase("Crystite Mule")) {
            StoreManager.buyMule(selectedBuyTransaction);
    }

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
    private void exitButtonAction() throws Exception {
        Pub.setVisible(false);
        Store.setVisible(false);
        town.setVisible(false);
        map.setVisible(true);
    }
    @FXML
    private void goToTownButton()  {
        //if (!Game.isLandSelectionPhase()) {
        map.setVisible(false);
        town.setVisible(true);
        // }
    }

    @FXML
    private void passTurnButton()  {
        RoundManager.playerFinishedTurn(true);


    }
   /* @FXML
    private void startTurnButton()  {
        startTurn.setDisable(true);
        passTurn.setVisible(true);
    }*/

    public void disablePlayerThree() {
        playerthree.setVisible(false);
    }

    public void disablePlayerFour() {
        playerfour.setVisible(false);
    }

    public void setGameStateLabel(String input) {
        gamestate.setText(input);
    }

    public void changePlayerOneGuiStats (String name, String race, int score,
                                         int money, int ore, int food, String
                                         color) {
        playerOneName.setText(name);
        playerOneName.setStyle(" -fx-text-fill :" + color + ";");
        playerOneRace.setText(race);
        playerOneScore.setText(String.valueOf(score));
        playerOneMoney.setText(String.valueOf(money));
        playerOneOre.setText(String.valueOf(ore));
        playerOneFood.setText(String.valueOf(food));
    }


    public void changePlayerTwoGuiStats (String name, String race, int score,
                                         int money, int ore, int food, String
                                         color) {
        playerTwoName.setText(name);
        playerTwoName.setStyle(" -fx-text-fill :" + color + ";");

        playerTwoRace.setText(race);
        playerTwoScore.setText(String.valueOf(score));
        playerTwoMoney.setText(String.valueOf(money));
        playerTwoOre.setText(String.valueOf(ore));
        playerTwoFood.setText(String.valueOf(food));

    }

    public void changePlayerThreeGuiStats (String name, String race, int score,
                                           int money, int ore, int food,
                                           String color) {
        playerThreeName.setText(name);
        playerThreeName.setStyle(" -fx-text-fill :" + color + ";");
        playerThreeRace.setText(race);
        playerThreeScore.setText(String.valueOf(score));
        playerThreeMoney.setText(String.valueOf(money));
        playerThreeOre.setText(String.valueOf(ore));
        playerThreeFood.setText(String.valueOf(food));
    }

    public void changePlayerFourGuiStats (String name, String race, int score,
                                          int money, int ore, int food,
                                          String color) {
        playerFourName.setText(name);
        playerFourName.setStyle(" -fx-text-fill :" + color + ";");
        playerFourRace.setText(race);
        playerFourScore.setText(String.valueOf(score));
        playerFourMoney.setText(String.valueOf(money));
        playerFourOre.setText(String.valueOf(ore));
        playerFourFood.setText(String.valueOf(food));
    }

    public void setCurrentPlayer (String player) {
        currentPlayer.setText(player);
    }

    public void setRoundNumber (int round) {
        roundNumber.setText(String.valueOf(round));
    }

/*

    @FXML
    private void handleMuleCombo() {
        selectedMuleType =
                muleCombo.getSelectionModel().getSelectedItem();
    }

    public void handleBuyMule() throws Exception {
        StoreManager.buyMule(selectedMuleType);
        exitButtonAction();


        Image   imageplain = new Image(getClass()
                .getResourceAsStream("baby.png"));

        map.setCursor(new ImageCursor(imageplain));
    }

*/


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

public void addMuleToButton (Button button, Tile tile) {
    Image imageplain;
           if (tile instanceof Plain) {
               imageplain = new Image(getClass()
                       .getResourceAsStream("brownMule.png"));
            } else if (tile instanceof Mountain1) {
               imageplain = new Image(getClass()
                       .getResourceAsStream("mountain1Mule.png"));
            } else if (tile instanceof Mountain2) {
               imageplain = new Image(getClass()
                       .getResourceAsStream("mountain2Mule.png"));
            } else if (tile instanceof Mountain3) {
               imageplain = new Image(getClass()
                       .getResourceAsStream("mountain3Mule.png"));
            } else {
               imageplain = new Image(getClass()
                       .getResourceAsStream("riverMule.png"));
            }

    button.setGraphic(new ImageView(imageplain));
    map.setCursor(Cursor.DEFAULT);
}

}




