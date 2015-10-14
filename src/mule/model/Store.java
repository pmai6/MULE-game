package mule.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by redcream12 on 9/18/15.
 */
public class Store {
    private static int food = 16;
   // private static int ore;
    private static int energy = 16;
    private static int smithore = 0;
    private static int crystite = 0;
    private static int foodMule = 7;
    private static int energyMule = 6;
    private static int crystiteMule = 6;
    private static int oreMule = 6;


    public Store(int food, int ore, int energy, int smithore, int crystite, int foodMule,
                    int energyMule, int crystiteMule, int oreMule) {
        this.food = food;
        this.energy = energy;
        this.smithore = smithore;
        this.crystite = crystite;
        this.foodMule = foodMule;
        this.energyMule = energyMule;
        this.crystiteMule = crystiteMule;
        this.oreMule = oreMule;
    }

/*    private void setStartStoreQuantity() {
        food = 16;
        energy = 16;
        smithore = 0;
        crystite = 0;
        mule = 25;
    }*/

    public static int getFoodQty() { return food; }
    public static int getFoodPrice() { return 30; }
    public static void setFoodQty(int foodQty) { food = foodQty; }

    public static int getEnergyQty() { return energy; }
    public static int getEnergyPrice() { return 25; }
    public static void setEnergyQty(int energyQty) { energy = energyQty; }

    public static int getSmithoreQty() { return smithore; }
    public static int getSmithorePrice() { return 50; }
    public static void setSmithoreQty(int smithoreQty) { smithore = smithoreQty; }

    public static int getCrystiteQty() { return crystite; }
    public static int getCrystitePrice() { return 100; }
    public static void setCrystiteQty(int crystiteQty) { crystite = crystiteQty; }

    public static int getMuleQty() {
        return oreMule + foodMule + crystiteMule + energyMule;
    }
    public static void setMuleQty(int muleQty) {
        int mule = muleQty;
    }


    public static int getFoodMuleQty() { return foodMule; }
    public static int getFoodMulePrice() { return 100; }
    public static void setFoodMuleQty(int foodMuleQty) {
        foodMule = foodMuleQty;
    }

    public static int getEnergyMuleQty() { return energyMule; }
    public static int getEnergyMulePrice() { return 100; }
    public static void setEnergyMuleQty(int energyMuleQty) {
        energyMule = energyMuleQty;
    }

    public static int getCrystiteMuleQty() { return crystiteMule; }
    public static int getCrystiteMulePrice() { return 100; }
    public static void setCrystiteMuleQty(int crystiteMuleQty) {
        crystiteMule = crystiteMuleQty;
    }

    public static int getSmithoreMuleQty() { return oreMule; }
    public static int getSmithoreMulePrice() { return 100; }
    public static void setSmithoreMuleQty(int oreMuleQty) { oreMule = oreMuleQty; }

}
