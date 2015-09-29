package mule.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * Created by travisclement on 9/8/15.
 */

public class Player implements Comparable {

    private StringProperty playerName;

    private StringProperty playerRace;

    private StringProperty playerColor;
    private IntegerProperty score;
    private IntegerProperty money;
    private IntegerProperty food;
    private IntegerProperty ore;
    private IntegerProperty energy;

    private int mule;
    private List<Tile> tiles;
    //add list of mules;


    public Player () {}
    public Player(String aplayerName,
                  String aplayerRace, String aplayerColor) {

        this.playerName = new SimpleStringProperty(aplayerName);
        this.playerRace = new SimpleStringProperty(aplayerRace);
        this.playerColor = new SimpleStringProperty(aplayerColor);
        this.score = new SimpleIntegerProperty(0);
        this.money = new SimpleIntegerProperty(getStartMoney(aplayerRace));
        setStartFoodOreEnergy();
        tiles = new ArrayList<Tile>();

    }

    private void setStartFoodOreEnergy() {

        this.food = new SimpleIntegerProperty(8);
        this.energy = new SimpleIntegerProperty(0);
        this.ore = new SimpleIntegerProperty(0);


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
        return playerName.get();
    }

    public void setPlayerName(String playerName) {
        this.playerName.set(playerName);
    }

    public String getPlayerRace() {
        return playerRace.get();
    }

    public void setPlayerRace(String playerRace) {
        this.playerRace.setValue(playerRace);
    }

    public String getPlayerColor() {
        return playerColor.get();
    }

    public void setPlayerColor(String playerColor) {
        this.playerColor.set(playerColor);
    }

    public static void createNewGamePlayer (String playerName2,
                                            String selectedRace2,
                                            String selectedColor2) {
        Player newplayer = new Player(playerName2, selectedRace2,
                selectedColor2);
        Game.getMulegame().addPlayerToArray(newplayer);
    }


    public int getScore() {
        return score.getValue();
    }

    public void setScore(int score) {
        this.score.set(score);
    }

    public IntegerProperty getScoreProperty() {
        return score;
    }

    public int getMoney() {
        return money.get();
    }

    public IntegerProperty getMoneyProperty() {
        return money;
    }


    public void setMoney(int money) {
        this.money.set(money);
    }

    public int getEnergy() {
        return energy.get();
    }

    public void setEnergy(int energy) {
        this.energy.set(energy);
    }

    public int getFood() {
        return food.get();
    }

    public void setFood(int food) {
        this.food.set(food);
    }
    public IntegerProperty getFoodProperty() {
        return food;
    }
    public int getOre() {
        return ore.get();
    }

    public void setOre(int ore) {
        this.ore.set(ore);
    }
    public IntegerProperty getOreProperty() {
        return ore;
    }

    public int getMule() {
        return mule;
    }

    public void setMule(int mule) {
        this.mule = mule;
    }



    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public void addtile (Tile tile) {
        tiles.add(tile);
    }

    public int compareTo(Object comparePlayer) {
        int compareScore = ((Player) comparePlayer).getMoney();
        //ascending order
        return this.getMoney() - compareScore;
    }
}