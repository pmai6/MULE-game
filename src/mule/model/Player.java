package mule.model;
import mule.GameManager;
import mule.MapManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by travisclement on 9/8/15.
 */

public class Player implements Comparable, Serializable {

    private String playerName;

    private String playerRace;

    private String playerColor;
    private int score;
    private int money;
    private int food;
    private int smithore;
    private int crystite;
    private int energy;

    private int mule;

    private int foodMule;
    private int energyMule;
    private int crystiteMule;
    private int oreMule;
    private int unicornMule;
    private int combatMule;
    private int wineMule;
    private int santaMule;
    private String difficulty;

    private List<Tile> tiles;
    private Mule unplacedMule;


    public Player () {}
    public Player(String aplayerName, String aplayerRace, String
        aplayerColor, String adifficulty) {
        this.playerName = aplayerName;
        this.playerRace = aplayerRace;
        this.playerColor = aplayerColor;
        this.money = getStartMoney(aplayerRace,adifficulty);
        this.score = 0;
        setStartFoodOreEnergy();
        this.difficulty = adifficulty;
        tiles = new ArrayList<Tile>();
    }

    private void setStartFoodOreEnergy() {

        this.food = 8;
        this.energy = 4;
        this.smithore = 0;
        this.crystite = 0;
    }

    private int getStartMoney(String race,String difficulty) {
        if (difficulty.equals("Standard")) {
            if (race == null) {
                return 0;
            } else if (race.equals("Human")) {
                return 600;
            } else if (race.equals("Flapper")) {
                return 1600;
            } else if (race.equals("Splashor")) {
                return 1100;
            } else if (race.equals("Hipchic")) {
                return 750;
            } else if (race.equals("Ragann")) {
                return 1425;
            }
        } else if (difficulty.equals("Beginner")) {
            if (race == null) {
                return 0;
            } else if (race.equals("Human")) {
                return 2000;
            } else if (race.equals("Flapper")) {
                return 20000;
            } else if (race.equals("Splashor")) {
                return 2000;
            } else if (race.equals("Hipchic")) {
                return 6666;
            } else {
                return 55555;
            }
        } else if (difficulty.equals("Beginner")) {
            if (race == null) {
                return 0;
            } else if (race.equals("Human")) {
                return 200;
            } else if (race.equals("Flapper")) {
                return 300;
            } else if (race.equals("Splashor")) {
                return 100;
            } else if (race.equals("Hipchic")) {
                return 100;
            }
        }

    return 300;
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


    public int getScore() {
        return score;
    }



    public void calculateScore() {
        int landAmount = this.getTiles().size() * 500;
        int newscore = this.getMoney() + landAmount + this
                .getDollarValueOfGoods() ;
        this.score = newscore;
    }

    private int getDollarValueOfGoods() {
        int dollarValOfFood = 30 * this.getFood();
        int dollarValOfEnergy = 25 * this.getEnergy();
        int dollarValOfOre = 50 * this.getSmithore();
        return dollarValOfFood + dollarValOfEnergy + dollarValOfOre;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if(money > 0)
            this.money = money;
        else
            this.money = 0;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        if(energy > 0)
            this.energy = energy;
        else
            this.energy = 0;
    }

    public int getFood() {
        return food;
    }
    public void setFood(int food) {
        if(food > 0)
            this.food = food;
        else
            this.food = 0;
    }


    public int getSmithore() {
        return smithore;
    }
    public void setSmithore(int ore) {
        if(ore > 0)
            this.smithore = ore;
        else
            this.smithore = 0;
    }



    public int getCrystite() { return crystite; }
    public void setCrystite(int crysTite) {
        if(crysTite > 0)
            this.crystite = crysTite;
        else
            this.crystite = 0;
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

    public int getWineMule() {
        return wineMule;
    }
    public void setWineMule(int wineMuleQty) {
        wineMule = wineMuleQty;
    }

    public int getSantaMule() {
        return santaMule;
    }
    public void setSantaMule(int santaMuleQty) {
        santaMule = santaMuleQty;
    }

    public int getCombatMule() {
        return combatMule;
    }
    public void setCombatMule(int combatMuleQty) {
        combatMule = combatMuleQty;
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
    public int calcPlayerTime() {
        int time = 50;
        int round = GameManager.getGameManager().getMulegame().getRound().getRoundNum();
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
     * @param property land to buy
     */
    public void playerBuyProperty (Tile property) {
       setMoney(getMoney() -  MapManager.costOfTile());
        addtile(property);

    }
}