package mule.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game implements Serializable {

    private int numberOfPlayers;
    private List<Player> playerArray;
    private List<Player> sortedPlayerArray;
    private String difficulty;
    private String map;
    private int n;
    private int playerCounter = 0;
    private List<String> colorList = new ArrayList<>(Arrays.asList(
             "Purple", "Green", "Red", "Blue", "Orange", "Yellow"));

    private boolean isLandSelectionPhase;
    private boolean isMuleBought = false;
    private Tile[][] tiles;
    private int timeLeftInTurn;
    private Round round;
    private Store gamestore;

    public Game() {
    } // default constructor

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

    public void setUpMap() {
        tiles = GameMap.setUpMap();
    }

    public int getPlayerCounter() {
        return playerCounter;
    }

    public void incrementPlayerCounter() {
        playerCounter++;
    }

    public boolean isMuleBought() {
        return isMuleBought;
    }

    public void setIsMuleBought(boolean isMuleBought) {
        this.isMuleBought = isMuleBought;
    }

    public void addPlayerToArray(Player player) {
        playerArray.add(player);
        sortedPlayerArray.add(player);
    }

    public List getColor() {
        return colorList;
    }

    public void removeColor(String color) {
        colorList.remove(color);
    }

    public int getN() {
        return n;
    }

    public void setN(int t) {
        this.n = t;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public List<Player> getPlayerArray() {
        return playerArray;
    }

    public void setPlayerArray(List<Player> playerArray) {
        this.playerArray = playerArray;
    }

    public void createSortedPlayerArray() {
        Collections.sort(sortedPlayerArray);
    }

    public List<Player> getSortedPlayerArray() {
        return sortedPlayerArray;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isLandSelectionPhase() {
        return isLandSelectionPhase;
    }

    public void setIsLandSelectionPhase(boolean isLandSelect) {
        isLandSelectionPhase = isLandSelect;
    }

    public Tile[][] getTiles() {
        return tiles;
    }



    public int getTimeLeftInTurn() {
        return timeLeftInTurn;
    }

    public void setTimeLeftInTurn(int timeLeftInTurn) {
        this.timeLeftInTurn = timeLeftInTurn;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Store getGamestore() {
        return gamestore;
    }

    public void setGamestore(Store gamestore) {
        this.gamestore = gamestore;
    }
}