package mule.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import mule.GameManager;
import mule.MapManager;

/**
 * The type Player.
 */
public final class Player implements Comparable, Serializable {

    /**
     * The Player name.
     */
    private String playerName;

    /**
     * The Player race.
     */
    private String playerRace;

    /**
     * The Player color.
     */
    private String playerColor;
    /**
     * The Score.
     */
    private int score;
    /**
     * The Money.
     */
    private int money;
    /**
     * The Food.
     */
    private int food;
    /**
     * The Smithore.
     */
    private int smithore;
    /**
     * The Crystite.
     */
    private int crystite;
    /**
     * The Energy.
     */
    private int energy;

    /**
     * The Mule.
     */
    private int mule;

    /**
     * The Food mule.
     */
    private int foodMule;
    /**
     * The Energy mule.
     */
    private int energyMule;
    /**
     * The Crystite mule.
     */
    private int crystiteMule;
    /**
     * The Ore mule.
     */
    private int oreMule;
    /**
     * The Unicorn mule.
     */
    private int unicornMule;
    /**
     * The Tiles.
     */
    private List<Tile> tiles;
    /**
     * The Unplaced mule.
     */
    private Mule unplacedMule;


    /**
     * Instantiates a new Player.
     */
    public Player() {
    }

    /**
     * Instantiates a new Player.
     *
     * @param aplayerName  the aplayer name
     * @param aplayerRace  the aplayer race
     * @param aplayerColor the aplayer color
     */
    public Player(String aplayerName, String aplayerRace, String aplayerColor) {
        this.playerName = aplayerName;
        this.playerRace = aplayerRace;
        this.playerColor = aplayerColor;
        this.money = getStartMoney(aplayerRace);
        this.score = 0;
        setStartFoodOreEnergy();
        tiles = new ArrayList<Tile>();
    }

    /**
     * Sets start food ore energy.
     */
    private void setStartFoodOreEnergy() {

        this.food = 8;
        this.energy = 4;
        this.smithore = 0;
        this.crystite = 0;
    }

    /**
     * Gets start money.
     *
     * @param race the race
     * @return the start money
     */
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

    /**
     * Gets player name.
     *
     * @return the player name
     */
// Getters and setters
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Sets player name.
     *
     * @param aPlayerName the a player name
     */
    public void setPlayerName(String aPlayerName) {
        this.playerName = aPlayerName;
    }

    /**
     * Gets player race.
     *
     * @return the player race
     */
    public String getPlayerRace() {
        return playerRace;
    }

    /**
     * Sets player race.
     *
     * @param aplayerRace the aplayer race
     */
    public void setPlayerRace(String aplayerRace) {
        this.playerRace = aplayerRace;
    }

    /**
     * Gets player color.
     *
     * @return the player color
     */
    public String getPlayerColor() {
        return playerColor;
    }

    /**
     * Sets player color.
     *
     * @param aplayerColor the aplayer color
     */
    public void setPlayerColor(String aplayerColor) {
        this.playerColor = aplayerColor;
    }


    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }


    /**
     * Calculate score.
     */
    public void calculateScore() {
        int landAmount = this.getTiles().size() * 500;
        int newscore = this.getMoney() + landAmount + this
                .getDollarValueOfGoods();
        this.score = newscore;
    }

    /**
     * Gets dollar value of goods.
     *
     * @return the dollar value of goods
     */
    private int getDollarValueOfGoods() {
        int dollarValOfFood = 30 * this.getFood();
        int dollarValOfEnergy = 25 * this.getEnergy();
        int dollarValOfOre = 50 * this.getSmithore();
        return dollarValOfFood + dollarValOfEnergy + dollarValOfOre;
    }

    /**
     * Gets money.
     *
     * @return the money
     */
    public int getMoney() {
        return money;
    }

    /**
     * Sets money.
     *
     * @param amoney the amoney
     */
    public void setMoney(int amoney) {
        if (amoney > 0) {
            this.money = amoney;
        } else {
            this.money = 0;
        }
    }

    /**
     * Gets energy.
     *
     * @return the energy
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * Sets energy.
     *
     * @param aenergy the aenergy
     */
    public void setEnergy(int aenergy) {
        if (aenergy > 0) {
            this.energy = aenergy;
        } else {
            this.energy = 0;
        }
    }

    /**
     * Gets food.
     *
     * @return the food
     */
    public int getFood() {
        return food;
    }

    /**
     * Sets food.
     *
     * @param afood the afood
     */
    public void setFood(int afood) {
        if (afood > 0) {
            this.food = afood;
        } else {
            this.food = 0;
        }
    }


    /**
     * Gets smithore.
     *
     * @return the smithore
     */
    public int getSmithore() {
        return smithore;
    }

    /**
     * Sets smithore.
     *
     * @param aore the aore
     */
    public void setSmithore(int aore) {
        if (aore > 0) {
            this.smithore = aore;
        } else {
            this.smithore = 0;
        }
    }


    /**
     * Gets crystite.
     *
     * @return the crystite
     */
    public int getCrystite() {
        return crystite;
    }

    /**
     * Sets crystite.
     *
     * @param crysTite the crys tite
     */
    public void setCrystite(int crysTite) {
        if (crysTite > 0) {
            this.crystite = crysTite;
        } else {
            this.crystite = 0;
        }
    }


    /**
     * Gets mule.
     *
     * @return the mule
     */
    public int getMule() {
        this.mule = getFoodMule() + getCrystiteMule() + getenergyMule()
                + getOreMule();
        return mule;
    }

    /**
     * Sets mule.
     *
     * @param amule the amule
     */
    public void setMule(int amule) {
        this.mule = amule;
    }

    /**
     * Gets food mule.
     *
     * @return the food mule
     */
    public int getFoodMule() {
        return foodMule;
    }

    /**
     * Sets food mule.
     *
     * @param foodMuleQty the food mule qty
     */
    public void setFoodMule(int foodMuleQty) {
        foodMule = foodMuleQty;
    }

    /**
     * Gets mule.
     *
     * @return the mule
     */
    public int getenergyMule() {
        return energyMule;
    }

    /**
     * Sets energy mule.
     *
     * @param energyMuleQty the energy mule qty
     */
    public void setEnergyMule(int energyMuleQty) {
        energyMule = energyMuleQty;
    }

    /**
     * Gets crystite mule.
     *
     * @return the crystite mule
     */
    public int getCrystiteMule() {
        return crystiteMule;
    }

    /**
     * Sets crystite mule.
     *
     * @param crystiteMuleQty the crystite mule qty
     */
    public void setCrystiteMule(int crystiteMuleQty) {
        crystiteMule = crystiteMuleQty;
    }

    /**
     * Gets ore mule.
     *
     * @return the ore mule
     */
    public int getOreMule() {
        return oreMule;
    }

    /**
     * Sets ore mule.
     *
     * @param oreMuleQty the ore mule qty
     */
    public void setOreMule(int oreMuleQty) {
        oreMule = oreMuleQty;
    }

    /**
     * Gets unicorn mule.
     *
     * @return the unicorn mule
     */
    public int getUnicornMule() {
        return unicornMule;
    }

    /**
     * Sets unicorn mule.
     *
     * @param unicornMuleQty the unicorn mule qty
     */
    public void setUnicornMule(int unicornMuleQty) {
        unicornMule = unicornMuleQty;
    }


    /**
     * Gets tiles.
     *
     * @return the tiles
     */
    public List<Tile> getTiles() {
        return tiles;
    }

    /**
     * Sets tiles.
     *
     * @param atiles the atiles
     */
    public void setTiles(List<Tile> atiles) {
        this.tiles = atiles;
    }

    /**
     * Addtile.
     *
     * @param tile the tile
     */
    public void addtile(Tile tile) {
        tiles.add(tile);
    }

    /**
     * Gets total number of mules.
     *
     * @return the total number of mules
     */
    public int getTotalNumberOfMules() {
        int totalNumMules = 0;
        List<Tile> atiles = this.getTiles();
        Iterator<Tile> tileIterator = atiles.iterator();
        while (tileIterator.hasNext()) {
            totalNumMules += tileIterator.next().getMule().size();
        }
        return totalNumMules;
    }


    /**
     * Compare to int.
     *
     * @param comparePlayer the compare player
     * @return the int
     */
    public int compareTo(Object comparePlayer) {
        int compareScore = ((Player) comparePlayer).getScore();
        //ascending order
        return this.getScore() - compareScore;
    }

    /**
     * Calc player time int.
     *
     * @return the int
     */
    public int calcPlayerTime() {
        int time = 50;
        int round = GameManager.getGameManager().getMulegame().getRound()
                .getRoundNum();
        if (round >= 1 || round <= 4) {
            if (food >= 3) {
                time = 50;
            }
            if (food < 3 && food > 0) {
                time = 30;
            }
            if (food == 0) {
                time = 5;
            }
        }
        if (round > 4 || round <= 8) {
            if (food >= 4) {
                time = 50;
            }
            if (food < 4 && food > 0) {
                time = 30;
            }
            if (food == 0) {
                time = 5;
            }
        }
        if (round > 8 || round <= 12) {
            if (food >= 5) {
                time = 50;
            }
            if (food < 5 && food > 0) {
                time = 30;
            }
            if (food == 0) {
                time = 5;
            }
        }
        return time;
    }

    /**
     * Gets unplaced mule.
     *
     * @return the unplaced mule
     */
    public Mule getUnplacedMule() {
        return unplacedMule;
    }

    /**
     * Sets unplaced mule.
     *
     * @param aunplacedMule the aunplaced mule
     */
    public void setUnplacedMule(Mule aunplacedMule) {
        this.unplacedMule = aunplacedMule;
    }


    /**
     * Player buy property.
     *
     * @param property the property
     */
    public void playerBuyProperty(Tile property) {
        setMoney(getMoney() - MapManager.costOfTile());
        addtile(property);

    }
}
