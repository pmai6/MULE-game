package mule.model;
/**
 * Created by redcream12 on 9/18/15.
 */
public class Store {
    private static int food;
    private static int ore;
    private static int energy;
    private static int smithore;
    private static int crystite;
    private static int mule;

    public static void setBeginInventory() {
        food = 16;
        ore = 0;
        energy = 16;
        smithore = 0;
        crystite = 0;
        mule = 25;
        //Store store = new Store(16, 0, 16, 0, 0, 25);
    }
    public Store(int food, int ore, int energy, int smithore, int crystite, int mule) {
        this.food = food;
        this.ore = ore;
        this.energy = energy;
        this.smithore = smithore;
        this.crystite = crystite;
        this.mule = mule;
    }
    public void showItems() {  // Display Store's menu

    }

    public static int getFood() { return food; }
    public static int getFoodPrice() { return 30; }
    public static void setFood(int newFood) { food = newFood; }

    public static int getEnergy() { return energy; }
    public static int getEnergyPrice() { return 25; }
    public static void setEnergy(int newEnergy) { energy = newEnergy; }

    public static int getOre() { return ore; }
    public static int orePrice() { return 0; }
    public static void setOre(int newOre) { ore = newOre; }

    public static int getSmithore() { return smithore; }
    public static int getSmithorePrice() { return 50; }
    public static void setSmithore(int newSmithore) { smithore = newSmithore; }

    public static int getCrystite() { return crystite; }
    public static int getCrystitePrice() { return 100; }
    public static void setCrystite(int newCrystite) { crystite = newCrystite; }

    public static int getMule() { return mule; }
    public static int getMulePrice() { return 100; }
    public static void setMule(int newMule) {
        mule = newMule;
    }

}
