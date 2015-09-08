import javafx.stage.Stage;

/**
 * Created by travisclement on 9/7/15.
 */
public class Game {

    private int numberOfPlayers;
    private Player [] playerArray;
    private Stage stage;
    private String difficulty;
    private String map;

    public Game (String adifficulty, int anumPlayers, String amap, Stage astage){
        difficulty = adifficulty;
        numberOfPlayers = anumPlayers;
        playerArray = new Player[anumPlayers];
        stage = astage;
        map = amap;
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