package mule.model;
import java.util.ArrayList;
import java.util.Iterator;
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
    private IntegerProperty smithore;
    private IntegerProperty crystite;
    private IntegerProperty energy;

    private int mule;

    private int foodMule;
    private int energyMule;
    private int crystiteMule;
    private int oreMule;
    private int unicornMule;
    private List<Tile> tiles;
    private Mule unplacedMule;


    public Player () {}
    public Player(String aplayerName, String aplayerRace, String aplayerColor) {
        this.playerName = new SimpleStringProperty(aplayerName);
        this.playerRace = new SimpleStringProperty(aplayerRace);
        this.playerColor = new SimpleStringProperty(aplayerColor);
        this.money = new SimpleIntegerProperty(getStartMoney(aplayerRace));
        this.score = new SimpleIntegerProperty(0);
        setStartFoodOreEnergy();
        tiles = new ArrayList<Tile>();
    }

    private void setStartFoodOreEnergy() {

        this.food = new SimpleIntegerProperty(8);
        this.energy = new SimpleIntegerProperty(4);
        this.smithore = new SimpleIntegerProperty(0);
        this.crystite = new SimpleIntegerProperty(0);
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



    public int getScore() {
        return score.getValue();
    }
    public IntegerProperty getScoreProperty() {
        return score;
    }


    public void calculateScore() {
        int landAmount = this.getTiles().size() * 500;
        int score = this.getMoney() + landAmount + this.getDollarValueOfGoods() ;
        this.score.set(score);
    }

    private int getDollarValueOfGoods() {
        int dollarValOfFood = 30 * this.getFood();
        int dollarValOfEnergy = 25 * this.getEnergy();
        int dollarValOfOre = 50 * this.getSmithore();
        return dollarValOfFood + dollarValOfEnergy + dollarValOfOre;
    }

    public int getMoney() {
        return money.get();
    }
    public IntegerProperty getMoneyProperty() {
        return money;
    }
    public void setMoney(int money) {
        if(money > 0)
            this.money.set(money);
        else
            this.money.set(0);
    }

    public int getEnergy() {
        return energy.get();
    }
    public IntegerProperty getEnergyProperty() {
        return energy;
    }
    public void setEnergy(int energy) {
        if(energy > 0)
            this.energy.set(energy);
        else
            this.energy.set(0);
    }

    public int getFood() {
        return food.get();
    }
    public void setFood(int food) {
        if(food > 0)
            this.food.set(food);
        else
            this.food.set(0);
    }
    public IntegerProperty getFoodProperty() {
        return food;
    }

    public int getSmithore() {
        return smithore.get();
    }
    public void setSmithore(int ore) {
        if(ore > 0)
            this.smithore.set(ore);
        else
            this.smithore.set(0);
    }
    public IntegerProperty getSmithoreProperty() {
        return smithore;
    }



    public int getCrystite() { return crystite.get(); }
    public void setCrystite(int crysTite) {
        if(crysTite > 0)
            this.crystite.set(crysTite);
        else
            this.crystite.set(0);
    }
    public IntegerProperty getCrystiteProperty() {
        return crystite;
    }

    public int getMule() {
        this.mule = getFoodMule()+getCrystiteMule()+getenergyMule()+getOreMule();
        return mule;
    }
    public void setMule(int mule) {
        this.mule = mule;
    }

    public int getFoodMule() {
        return foodMule;
    }
    public void setFoodMule(int foodMuleQty) {
        foodMule = foodMuleQty;
    }

    public int getenergyMule() {
        return energyMule;
    }
    public void setEnergyMule(int energyMuleQty) {
        energyMule = energyMuleQty;
    }

    public int getCrystiteMule() {
        return crystiteMule;
    }
    public void setCrystiteMule(int crystiteMuleQty) {
        crystiteMule = crystiteMuleQty;
    }

    public int getOreMule() {
        return oreMule;
    }
    public void setOreMule(int oreMuleQty) {
        oreMule = oreMuleQty;
    }

    public int getUnicornMule() {
        return unicornMule;
    }
    public void setUnicornMule(int unicornMuleQty) {
        unicornMule = unicornMuleQty;
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

    public int getTotalNumberOfMules() {
        int totalNumMules = 0;
        List<Tile> tiles = this.getTiles();
        Iterator<Tile> tileIterator = tiles.iterator();
        while(tileIterator.hasNext()) {
            totalNumMules += tileIterator.next().getMule().size();
        }
        return  totalNumMules;
    }



    public int compareTo(Object comparePlayer) {
        int compareScore = ((Player) comparePlayer).getScore();
        //ascending order
        return this.getScore() - compareScore;
    }
    public static int calcPlayerTime(Player player) {
        int time = 50;
        int round = Round.getRoundNum();
        int food = player.getFood();
        if (round >= 1 || round <= 4) {
            if (food >= 3) { time = 50; }
            if (food < 3 && food > 0) { time = 30; }
            if (food == 0) { time = 5; }
        }
        if (round > 4 || round <= 8) {
            if (food >= 4) { time = 50; }
            if (food < 4 && food > 0) { time = 30; }
            if (food == 0) { time = 5; }
        }
        if (round > 8 || round <= 12) {
            if (food >= 5) { time = 50; }
            if (food < 5 && food > 0) { time = 30; }
            if (food == 0) { time = 5; }
        }
        return time;
    }

    public Mule getUnplacedMule() {
        return unplacedMule;
    }

    public void setUnplacedMule(Mule unplacedMule) {
        this.unplacedMule = unplacedMule;
    }



    /**
     * Method to deduct the an amount of money a player spent on land
     * @param player current player
     * @param property land to buy
     */
    public static void playerBuyProperty (Player player, Tile property) {
        player.setMoney(player.getMoney() - property.getCost());
        player.addtile(property);

    }
}