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
    private static int mule = 25;

    public Store(int food, int ore, int energy, int smithore, int crystite, int mule) {
        this.food = food;
        this.energy = energy;
        this.smithore = smithore;
        this.crystite = crystite;
        this.mule = mule;
    }
    public void showItems() {  // Display Store's menu

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

//    public static int getOreQty() { return ore; }
//    public static int getorePrice() { return 0; }
//    public static void setOreQty(int oreQty) { ore = oreQty; }

    public static int getSmithoreQty() { return smithore; }
    public static int getSmithorePrice() { return 50; }
    public static void setSmithoreQty(int smithoreQty) { smithore = smithoreQty; }

    public static int getCrystiteQty() { return crystite; }
    public static int getCrystitePrice() { return 100; }
    public static void setCrystiteQty(int crystiteQty) { crystite = crystiteQty; }

    public static int getMuleQty() { return mule; }
    public static int getMulePrice() { return 100; }
    public static void setMuleQty(int muleQty) {
        mule = muleQty;
    }

}
