package mule.model;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class Game {

    private static int numberOfPlayers;
    private List<Player> playerArray;
    private List<Player> sortedPlayerArray;
    private String difficulty;
    private String map;
    private int n;
    private static Game mulegame;
    private static int  playerCounter = 0;
    private List<String> colorList = new ArrayList<>(Arrays.asList
            ("Purple","Green","Red","Blue"));

    private static boolean isLandSelectionPhase;
private static boolean isMuleBought = false;

    public Game (String adifficulty, int anumPlayers, String amap, int number) {
        difficulty = adifficulty;
        numberOfPlayers = anumPlayers;
        playerArray = new ArrayList<>(anumPlayers);
        sortedPlayerArray = new ArrayList<>(anumPlayers);
        n = number;
        map = amap;

    }


    public static void createGame(String difficulty,
                           int numberOfPlayers,
                           String map, int n) {
        mulegame = new Game(difficulty, numberOfPlayers, map, n);
    }

    public static Game getMulegame() {
        return mulegame;
    }

    public static int getPlayerCounter() {
        return playerCounter;
    }

    public static void incrementPlayerCounter() {
        Game.playerCounter++;
    }

    public static boolean isMuleBought() {
        return isMuleBought;
    }

    public static void setIsMuleBought(boolean isMuleBought) {
        Game.isMuleBought = isMuleBought;
    }

    public void addPlayerToArray(Player player) {
        playerArray.add(player);
        sortedPlayerArray.add(player);
    }
    public  List getColor() {
        return colorList;
    }

    public int getN() {return n;}

    public void setN(int t) {this.n = t;}

    public static int getNumberOfPlayers() {
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

    public List<Player> getSortedPlayerArray() {
        Collections.sort(sortedPlayerArray);
        return sortedPlayerArray;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public static boolean isLandSelectionPhase() {
        return isLandSelectionPhase;
    }

    public static void setIsLandSelectionPhase(boolean isLandSelect) {
        isLandSelectionPhase = isLandSelect;
    }
}