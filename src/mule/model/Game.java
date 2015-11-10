package mule.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The type Game.
 */
public class Game implements Serializable {

    /**
     * The Number of players.
     */
    private int numberOfPlayers;
    /**
     * The Player array.
     */
    private List<Player> playerArray;
    /**
     * The Sorted player array.
     */
    private List<Player> sortedPlayerArray;
    /**
     * The Difficulty.
     */
    private String difficulty;
    /**
     * The Map.
     */
    private String map;
    /**
     * The N.
     */
    private int n;
    /**
     * The Player counter.
     */
    private int playerCounter = 0;
    /**
     * The Color list.
     */
    private List<String> colorList = new ArrayList<>(Arrays.asList(
             "Purple", "Green", "Red", "Blue", "Orange", "Yellow"));

    /**
     * The Is land selection phase.
     */
    private boolean isLandSelectionPhase;
    /**
     * The Is mule bought.
     */
    private boolean isMuleBought = false;
    /**
     * The Tiles.
     */
    private Tile[][] tiles;
    /**
     * The Time left in turn.
     */
    private int timeLeftInTurn;
    /**
     * The Round.
     */
    private Round round;
    /**
     * The Gamestore.
     */
    private Store gamestore;

    /**
     * Instantiates a new Game.
     */
    public Game() {
    } // default constructor

    /**
     * Instantiates a new Game.
     *
     * @param adifficulty the adifficulty
     * @param anumPlayers the anum players
     * @param amap        the amap
     * @param number      the number
     */
    public Game(String adifficulty, int anumPlayers, String amap, int number) {
        difficulty = adifficulty;
        numberOfPlayers = anumPlayers;
        playerArray = new ArrayList<>(anumPlayers);
        sortedPlayerArray = new ArrayList<>(anumPlayers);
        n = number;
        map = amap;
        timeLeftInTurn = 0;
        round = new Round();
        gamestore = new Store();
    }

    /**
     * Sets up map.
     */
    public void setUpMap() {
        tiles = GameMap.setUpMap();
    }

    /**
     * Gets player counter.
     *
     * @return the player counter
     */
    public int getPlayerCounter() {
        return playerCounter;
    }

    /**
     * Increment player counter.
     */
    public void incrementPlayerCounter() {
        playerCounter++;
    }

    /**
     * Is mule bought boolean.
     *
     * @return the boolean
     */
    public boolean isMuleBought() {
        return isMuleBought;
    }

    /**
     * Sets is mule bought.
     *
     * @param isMuleBought the is mule bought
     */
    public void setIsMuleBought(boolean isMuleBought) {
        this.isMuleBought = isMuleBought;
    }

    /**
     * Add player to array.
     *
     * @param player the player
     */
    public void addPlayerToArray(Player player) {
        playerArray.add(player);
        sortedPlayerArray.add(player);
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public List getColor() {
        return colorList;
    }

    /**
     * Remove color.
     *
     * @param color the color
     */
    public void removeColor(String color) {
        colorList.remove(color);
    }

    /**
     * Gets n.
     *
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * Sets n.
     *
     * @param t the t
     */
    public void setN(int t) {
        this.n = t;
    }

    /**
     * Gets number of players.
     *
     * @return the number of players
     */
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    /**
     * Sets number of players.
     *
     * @param numberOfPlayers the number of players
     */
    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    /**
     * Gets map.
     *
     * @return the map
     */
    public String getMap() {
        return map;
    }

    /**
     * Sets map.
     *
     * @param map the map
     */
    public void setMap(String map) {
        this.map = map;
    }

    /**
     * Gets player array.
     *
     * @return the player array
     */
    public List<Player> getPlayerArray() {
        return playerArray;
    }

    /**
     * Sets player array.
     *
     * @param playerArray the player array
     */
    public void setPlayerArray(List<Player> playerArray) {
        this.playerArray = playerArray;
    }

    /**
     * Create sorted player array.
     */
    public void createSortedPlayerArray() {
        Collections.sort(sortedPlayerArray);
    }

    /**
     * Gets sorted player array.
     *
     * @return the sorted player array
     */
    public List<Player> getSortedPlayerArray() {
        return sortedPlayerArray;
    }

    /**
     * Gets difficulty.
     *
     * @return the difficulty
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * Sets difficulty.
     *
     * @param difficulty the difficulty
     */
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Is land selection phase boolean.
     *
     * @return the boolean
     */
    public boolean isLandSelectionPhase() {
        return isLandSelectionPhase;
    }

    /**
     * Sets is land selection phase.
     *
     * @param isLandSelect the is land select
     */
    public void setIsLandSelectionPhase(boolean isLandSelect) {
        isLandSelectionPhase = isLandSelect;
    }

    /**
     * Get tiles tile [ ] [ ].
     *
     * @return the tile [ ] [ ]
     */
    public Tile[][] getTiles() {
        return tiles;
    }


    /**
     * Gets time left in turn.
     *
     * @return the time left in turn
     */
    public int getTimeLeftInTurn() {
        return timeLeftInTurn;
    }

    /**
     * Sets time left in turn.
     *
     * @param timeLeftInTurn the time left in turn
     */
    public void setTimeLeftInTurn(int timeLeftInTurn) {
        this.timeLeftInTurn = timeLeftInTurn;
    }

    /**
     * Gets round.
     *
     * @return the round
     */
    public Round getRound() {
        return round;
    }

    /**
     * Sets round.
     *
     * @param round the round
     */
    public void setRound(Round round) {
        this.round = round;
    }

    /**
     * Gets gamestore.
     *
     * @return the gamestore
     */
    public Store getGamestore() {
        return gamestore;
    }

    /**
     * Sets gamestore.
     *
     * @param gamestore the gamestore
     */
    public void setGamestore(Store gamestore) {
        this.gamestore = gamestore;
    }
}