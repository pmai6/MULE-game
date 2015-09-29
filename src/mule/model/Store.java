package mule;
/**
 * Created by redcream12 on 9/18/15.
 */
public class Store {
    private int food;
    private int ore;
    private int energy;
    private int smithore;
    private int crystite;
    private int mule;

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
    private void setStartStoreQuantity() {
        food = 16;
        energy = 16;
        smithore = 0;
        crystite = 0;
        mule = 25;
    }

    public int getFood() { return food; }
    public int getFoodPrice() { return 30; }
    public void setFood(int food) { this.food = food; }

    public int getEnergy() { return energy; }
    public int getEnergyPrice() { return 25; }
    public void setEnergy(int energy) { this.energy = energy; }

    public int getOre() { return ore; }
    public int orePrice() { return 0; }
    public void setOre(int ore) { this.ore = ore; }

    public int getSmithore() { return smithore; }
    public int getSmithorePrice() { return 50; }
    public void setSmithore(int smithore) { this.smithore = smithore; }

    public int getCrystite() { return crystite; }
    public int getCrystitePrice() { return 100; }
    public void setCrystite(int crystite) { this.crystite = crystite; }

    public int getMule() { return mule; }
    public int getMulePrice() { return 100; }
    public void setMule(int mule) {
        this.mule = mule;
    }

}
