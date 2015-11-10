package mule;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import mule.model.*;
import mule.view.GameController;

import java.util.List;

/**
 * Created by travisclement on 9/18/15.
 */

/**
 * The type Game manager.
 */
public class GameManager {
    /**
     * The constant gameManager.
     */
    private static GameManager gameManager = new GameManager();
    /**
     * The constant mulegame.
     */
    private static Game mulegame;
    /**
     * The constant controller.
     */
    private static GameController controller;
    /**
     * The constant gamestore.
     */
    private static Store gamestore;
    /**  */
    /**
     * The Game manager.
     */
    public GameManager() {}

    /**
     * Instantiates a new Get game manager.
     */
    public static GameManager getGameManager() {
        return gameManager;
    }


    /**
     * Instantiates a new Create game.
     *
     * @param difficulty      the difficulty
     * @param numberOfPlayers the number of players
     * @param map             the map
     * @param n               the n
     */
    public void createGame(String difficulty,
                           int numberOfPlayers,
                           String map, int n) {
        mulegame = new Game(difficulty, numberOfPlayers, map, n);
        gamestore = mulegame.getGamestore();
    }


    /**
     * Sets game from save.
     *
     * @param mulegame the mulegame
     * @param stage    the stage
     * @return the game from save
     * @throws Exception the exception
     */
    public void setGameFromSave(Game mulegame, Stage stage) throws Exception {
        this.mulegame = mulegame;

        RoundManager.startFromSave(gameManager);
        gameManager.startGameController(stage);
        gameManager.setGameStateLabel();
        gameManager.disablePlayers(mulegame.getNumberOfPlayers());
        gameManager.initializePlayerGuiStats();
        MapManager.setupMap(mulegame, controller);
        if (!this.mulegame.isLandSelectionPhase()) {
            gameManager.setTimer(mulegame.getTimeLeftInTurn());
        }
        gameManager.updateGamePlayerRound();
        gamestore = mulegame.getGamestore();
    }

    /**
     * Start the game.
     *
     * @param stage the stage
     * @throws Exception the exception
     */
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


   /*     InputStream in = new FileInputStream
                ("src/mule/8-bit-circus-music.wav");
        // create an audiostream from the inputstream
        AudioStream audioStream = new AudioStream(in);

        // play the audio clip with the audioplayer class
        AudioPlayer.player.start(audioStream);*/
    }


    /**
 */
    /**
     * Place mule.
     *
     * @throws Exception the exception
     */
    public void placeMule() throws Exception {
        controller.placingMule();
    }


    /**
     * Go to map.
     *
     * @throws Exception the exception
     */
    public void goToMap() throws Exception {
        controller.exitButtonAction();
    }
    /**Disables the player areas in the main GUI screen so there
     * score and info do not show up
     * @param numPlayers number of players not playing
     */
    /**
     * Disable players.
     *
     * @param numPlayers the num players
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
    /**
     * Start game controller.
     *
     * @param astage the astage
     * @throws Exception the exception
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
    /**
     * Sets game state label.
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

    /**
     * Update game player round.
     */
    public  void updateGamePlayerRound() {
        controller.setCurrentPlayer(RoundManager.getCurrentPlayer()
                .getPlayerName());
        controller.setRoundNumber(mulegame.getRound().getRoundNum());
        gameManager.setGameStateLabel();
    }


    /**
     * Update store data.
     */
    public void updateStoreData () {
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

    /**
     * Initialize player gui stats.
     */
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
                case 2:
                    controller.changePlayerThreeGuiStats(name, race, score,
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

    /**
     * Sets timer.
     *
     * @param time the time
     */
    public  void setTimer(int time) {
        controller.setTimer(time);
    }

    /**
     * Mule alert.
     */
    public  void muleAlert() {
        controller.badMulePlacement();
    }

    /**
     * Not enough money.
     */
    public  void notEnoughMoney() {
        controller.youGotNoMoney();
    }

    /**
     * Notify random event.
     *
     * @param random the random
     */
    public  static void notifyRandomEvent(String random) {
        controller.randomEventDialog(random);
    }

    /**
     * Not enough item.
     */
    public  void notEnoughItem() {
        controller.youGotNoResources();
    }

    /**
     * Add mule to button.
     *
     * @param button the button
     * @param tile   the tile
     */
    public  void addMuleToButton(Button button,Tile tile) {
        controller.addMuleToButton(button, tile);
    }

    /**
     * Is land selection phase boolean.
     *
     * @return the boolean
     */
    public  boolean isLandSelectionPhase() {
        return mulegame.isLandSelectionPhase();
    }

    /**
     * Sets is land selection phase.
     *
     * @param isLandSelect the is land select
     */
    public  void setIsLandSelectionPhase(boolean isLandSelect) {
        mulegame.setIsLandSelectionPhase(isLandSelect);
    }

    /**
     * Gets mulegame.
     *
     * @return the mulegame
     */
    public  Game getMulegame() {
        return mulegame;
    }

    /**
     * Is mule bought boolean.
     *
     * @return the boolean
     */
    public  boolean isMuleBought() {
        return mulegame.isLandSelectionPhase();
    }

    /**
     * Sets is mule bought.
     *
     * @param isMuleBought the is mule bought
     */
    public  void setIsMuleBought(boolean isMuleBought) {
        mulegame.setIsMuleBought(isMuleBought);
    }

    /**
     * Create sorted player array.
     */
    public void createSortedPlayerArray() {
        mulegame.createSortedPlayerArray();
    }

    /**
     * Gets sorted player array.
     *
     * @return the sorted player array
     */
    public List<Player> getSortedPlayerArray() {
        return mulegame.getSortedPlayerArray();
    }

    /**
     * Gets number of players.
     *
     * @return the number of players
     */
    public  int getNumberOfPlayers() {
        return mulegame.getNumberOfPlayers();
    }

    /**
     * Sets number of players.
     *
     * @param numberOfPlayers the number of players
     */
    public void setNumberOfPlayers(int numberOfPlayers) {
        mulegame.setNumberOfPlayers(numberOfPlayers);
    }

    /**
     * Handle map button.
     *
     * @param button the button
     */
    public void handleMapButton(Button button) {
    /*    try {
            InputStream in = new FileInputStream
                    ("src/mule/button-select.wav");
            // create an audiostream from the inputstream
            AudioStream audioStream = new AudioStream(in);

            // play the audio clip with the audioplayer class
            AudioPlayer.player.start(audioStream);
        }
        catch (FileNotFoundException e) {
            System.out.println("no such file");
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
*/
        MapManager.handleMapButton(button);
    }

    /**
     * Sets cursor default.
     */
    public void setCursorDefault() {
        controller.setCursorDefault();
    }

    /**
     * Save game.
     */
    public static void saveGame() {
        LoadSave.saveGame();
    }

    /**
     * Load game.
     *
     * @param stage the stage
     * @throws Exception the exception
     */
    public static void loadGame(Stage stage) throws Exception {
        LoadSave.loadGame(stage);
    }

    /**
     * Gets time left.
     *
     * @return the time left
     */
    public int getTimeLeft() {
        return controller.getTimeLeft();
    }

    /**
     * Stop timer.
     */
    public void stopTimer() {
        controller.stopTimer();
    }

    /**
     * Gets game store.
     *
     * @return the game store
     */
    public Store getGameStore() {
       return  mulegame.getGamestore();
    }
}
