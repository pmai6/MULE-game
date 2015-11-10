package mule;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import mule.model.Game;
import mule.model.Store;
import mule.model.Player;
import mule.model.Tile;
import mule.model.LoadSave;
import mule.view.GameController;
//import sun.audio.AudioPlayer;
//import sun.audio.AudioStream;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
import java.util.List;

/**
 * Created by travisclement on 9/18/15.
 */
public class GameManager {
    private static GameManager gameManager = new GameManager();
    private static Game mulegame;
    private static GameController controller;
    private static Store gamestore;
    public static GameManager getGameManager() {
        return gameManager;
    }

    public  static void notifyRandomEvent(String random) {
        controller.randomEventDialog(random);
    }

    public static void saveGame() {
        LoadSave.saveGame();
    }

    public static void loadGame(Stage stage) throws Exception {
        LoadSave.loadGame(stage);
    }

    public void createGame(String difficulty,
                           int numberOfPlayers,
                           String map, int n) {
        mulegame = new Game(difficulty, numberOfPlayers, map, n);
        gamestore = mulegame.getGamestore();
    }

    public void setGameFromSave(Game amulegame, Stage stage) throws Exception {
        this.mulegame = amulegame;
//        for (Player p: amulegame.getPlayerArray()) {
//            //System.out.println(p.getPlayerName());
//        }
//        for (Player p: amulegame.getPlayerArray()) {
//            //System.out.println(p.getMoney());
//        }
        RoundManager.startFromSave(gameManager);
        gameManager.startGameController(stage);
        gameManager.setGameStateLabel();
        gameManager.disablePlayers(mulegame.getNumberOfPlayers());
        gameManager.initializePlayerGuiStats();
        MapManager.setupMap(amulegame, controller);
        if (!this.mulegame.isLandSelectionPhase()) {
            gameManager.setTimer(amulegame.getTimeLeftInTurn());
        }
        gameManager.updateGamePlayerRound();
        gamestore = amulegame.getGamestore();
    }

    public void startTheGame(Stage stage) throws Exception {

        mulegame.setIsLandSelectionPhase(true);
        mulegame.setUpMap();
        RoundManager.startRounds(gameManager);
        gameManager.startGameController(stage);
        MapManager.setupMap(mulegame, controller);
        gameManager.setGameStateLabel();
        gameManager.disablePlayers(mulegame.getNumberOfPlayers());

        gameManager.initializePlayerGuiStats();
        updateGamePlayerRound();


        //InputStream in = new FileInputStream
        // ("src/mule/8-bit-circus-music.wav");
        // create an audiostream from the inputstream
        /***checkstyle not liking deprecated library**/
        //AudioStream audioStream = new AudioStream(in);

        // play the audio clip with the audioplayer class
        /***checkstyle not liking deprecated library***/
        //AudioPlayer.player.start(audioStream);
    }

    public void placeMule() throws Exception {
        controller.placingMule();
    }

    public void goToMap() throws Exception {
        controller.exitButtonAction();
    }

    /**Disables the player areas in the main GUI screen so there
     * score and info do not show up
     * @param numPlayers number of players not playing
     */
    public void disablePlayers(int numPlayers) {
        if (numPlayers == 2) {
            controller.disablePlayerThree();
            controller.disablePlayerFour();
        } else if (numPlayers == 3) {
            controller.disablePlayerFour();
        }
    }

    /** start the game controller - the main window of the game
     *
     * @param astage stage which game is happening
     * @throws Exception
     */
    public void startGameController(Stage astage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "view/GameScreen.fxml"));
        Parent root = fxmlLoader.load();
        astage.setScene(new Scene(root));
        astage.setTitle("U.N.I.C.O.R.N Game Screen");
        controller = fxmlLoader.getController();
        astage.show();
    }

    /**  sets the label in the main area of the game with the current game
     * state
     *
     */
    public   void setGameStateLabel() {
        if (gameManager.getMulegame().isLandSelectionPhase()) {
            controller.setGameStateLabel("LAND SELECTION PHASE");
        } else if (gameManager.getMulegame().isMuleBought()) {
            controller.setGameStateLabel("PLACE YOUR MULE");
        } else {
            controller.setGameStateLabel("NORMAL GAME MODE");
        }
    }

    public  void updateGamePlayerRound() {
        controller.setCurrentPlayer(RoundManager.getCurrentPlayer()
                .getPlayerName());
        controller.setRoundNumber(mulegame.getRound().getRoundNum());
        gameManager.setGameStateLabel();
    }

    public void updateStoreData() {
        int food = gamestore.getFoodQty();
        int energy = gamestore.getEnergyQty();
        int smithore = gamestore.getSmithoreQty();
        int crystite = gamestore.getCrystiteQty();
        int foodMule = gamestore.getFoodMuleQty();
        int energyMule = gamestore.getEnergyMuleQty();
        int crystiteMule = gamestore.getCrystiteMuleQty();
        int smithoreMule = gamestore.getSmithoreMuleQty();

        controller.updateStoreData(food, energy, smithore, crystite, foodMule,
                energyMule, crystiteMule, smithoreMule);
    }

    public  void initializePlayerGuiStats() {
        int numberOfPlayers = mulegame.getNumberOfPlayers();

        for (int i = 0; i < numberOfPlayers; i++) {
            String name = mulegame.getPlayerArray().get(i).getPlayerName();
            String race = mulegame.getPlayerArray().get(i)
                    .getPlayerRace();
            String color = mulegame.getPlayerArray().get(i)
                    .getPlayerColor();
            int score = mulegame.getPlayerArray().get(i).getScore();
            int money = mulegame.getPlayerArray().get(i).getMoney();
            int ore = mulegame.getPlayerArray().get(i).getSmithore();
            int food = mulegame.getPlayerArray().get(i).getFood();
            int energy = mulegame.getPlayerArray().get(i).getEnergy();

            switch (i) {
            case 0:
                controller.changePlayerOneGuiStats(name, race, score,
                        money, ore, food, color, energy);
                break;
            case 1:
                controller.changePlayerTwoGuiStats(name, race, score,
                        money, ore, food, color, energy);
                break;
            case 2:controller.changePlayerThreeGuiStats(name, race, score,
                        money, ore, food, color, energy);
                break;
            case 3:
                controller.changePlayerFourGuiStats(name, race, score,
                        money, ore, food, color, energy);
                break;
            default:
                break;
            }
        }
    }

    public  void setTimer(int time) {
        controller.setTimer(time);
    }

    public  void muleAlert() {
        controller.badMulePlacement();
    }

    public  void notEnoughMoney() {
        controller.youGotNoMoney();
    }

    public  void notEnoughItem() {
        controller.youGotNoResources();
    }

    public  void addMuleToButton(Button button, Tile tile) {
        controller.addMuleToButton(button, tile);
    }

    public  boolean isLandSelectionPhase() {
        return mulegame.isLandSelectionPhase();
    }

    public  void setIsLandSelectionPhase(boolean isLandSelect) {
        mulegame.setIsLandSelectionPhase(isLandSelect);
    }

    public  Game getMulegame() {
        return mulegame;
    }

    public  boolean isMuleBought() {
        return mulegame.isLandSelectionPhase();
    }

    public  void setIsMuleBought(boolean isMuleBought) {
        mulegame.setIsMuleBought(isMuleBought);
    }

    public void createSortedPlayerArray() {
        mulegame.createSortedPlayerArray();
    }

    public List<Player> getSortedPlayerArray() {
        return mulegame.getSortedPlayerArray();
    }

    public  int getNumberOfPlayers() {
        return mulegame.getNumberOfPlayers();
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        mulegame.setNumberOfPlayers(numberOfPlayers);
    }

    public void handleMapButton(Button button) {
//        try {
//            //InputStream in = new FileInputStream
//            //("src/mule/button-select.wav");
//            // create an audiostream from the inputstream
//            /***checkstyle not liking deprecated library**/
//            //AudioStream audioStream = new AudioStream(in);
//
//            // play the audio clip with the audioplayer class
//            /***checkstyle not liking deprecated library**/
//            //AudioPlayer.player.start(audioStream);
//        } catch (FileNotFoundException e) {
//            System.out.println("no such file");
//        } catch (IOException e) {
//            System.err.println("Caught IOException: " + e.getMessage());
//        }

        MapManager.handleMapButton(button);
    }

    public void setCursorDefault() {
        controller.setCursorDefault();
    }

    public int getTimeLeft() {
        return controller.getTimeLeft();
    }

    public void stopTimer() {
        controller.stopTimer();
    }

    public Store getGameStore() {
        return  mulegame.getGamestore();
    }
}
