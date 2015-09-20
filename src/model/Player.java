import java.util.ArrayList;
import java.util.List;

/**
 * Created by travisclement on 9/8/15.
 */
public class Player {

    private String playerName;

    private String playerRace;

    private String playerColor;
    private int score;
    private int money;
    private int food;
    private int ore;
    private int energy;
    private List<Tile> tiles;


    public Player () {}
    public Player(String aplayerName,
                  String aplayerRace, String aplayerColor) {

        playerName = aplayerName;
        playerRace = aplayerRace;
        playerColor = aplayerColor;
        score = 0;
        money = getStartMoney(playerRace);
        setStartFoodOreEnergy();
        tiles = new ArrayList<Tile>();

    }

    private void setStartFoodOreEnergy() {

        food = 8;
        energy =
        ore = 0;


    }

    private int getStartMoney(String race) {
        if (race == null) {
            return 0;
        } else if (race.equals("Human")) {
            return 600;
        } else if (race.equals("Flapper")) {
            return 1600;
        } else {
            return 1000;
        }
    }


    // Getters and setters
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerRace() {
        return playerRace;
    }

    public void setPlayerRace(String playerRace) {
        this.playerRace = playerRace;
    }

    public String getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(String playerColor) {
        this.playerColor = playerColor;
    }

    public static void createNewGamePlayer (String playerName,
                                            String selectedRace,
                                            String selectedColor) {
        Player newplayer = new Player(playerName, selectedRace, selectedColor);
        Game.getMulegame().addPlayerToArray(newplayer);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getOre() {
        return ore;
    }

    public void setOre(int ore) {
        this.ore = ore;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }
}