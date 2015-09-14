import javafx.stage.Stage;

/**
 * Created by travisclement on 9/7/15.
 */
public class Game {

    private int numberOfPlayers;
    private Player [] playerArray;
    private String difficulty;
    private String map;
    private int n;

    public Game (String adifficulty, int anumPlayers, String amap, int number) {
        difficulty = adifficulty;
        numberOfPlayers = anumPlayers;
        playerArray = new Player[anumPlayers];
        n = number;
        map = amap;
    }

    public int getN() {return n;}

    public void setN(int t) {this.n = t;}

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

    public Player[] getPlayerArray() {
        return playerArray;
    }

    public void setPlayerArray(Player[] playerArray) {
        this.playerArray = playerArray;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}