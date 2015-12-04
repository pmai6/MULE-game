package mule.model;

import java.io.*;

/**
 * Created by redcream12 on 9/18/15.
 */
public class Store implements Serializable {
    private  int food = 16;
    private  int energy = 16;
    private  int smithore = 0;
    private  int crystite = 0;
    private  int foodMule = 7;
    private  int crystiteMule = 6;
    private  int oreMule = 6;
    private  int energyMule = 6;
    private  int mule = 25;
    private  int combatMule = 6;
    private  int santaMule = 2;
    private  int wineMule = 6;


    public Store() {}

    public Store(int food, int energy, int smithore, int crystite, int mule, int wineMule, int combatMule, int santaMule) {
        this.food = food;
        this.energy = energy;
        this.smithore = smithore;
        this.crystite = crystite;
        this.wineMule = wineMule;
        this.combatMule = combatMule;
        this.santaMule = santaMule;
        this.mule = mule;
    }
/*    private void setStartStoreQuantity() {
        food = 16;
        energy = 16;
        smithore = 0;
        crystite = 0;
        mule = 25;
    }*/

    public  int getFoodQty() { return food; }
    public  int getFoodPrice() { return 30; }
    public  void setFoodQty(int foodQty) { food = foodQty; }

    public  int getEnergyQty() { return energy; }
    public  int getEnergyPrice() { return 25; }
    public  void setEnergyQty(int energyQty) { energy = energyQty; }

    public  int getSmithoreQty() { return smithore; }
    public  int getSmithorePrice() { return 50; }
    public  void setSmithoreQty(int smithoreQty) { smithore = smithoreQty; }

    public  int getCrystiteQty() { return crystite; }
    public  int getCrystitePrice() { return 100; }
    public  void setCrystiteQty(int crystiteQty) { crystite = crystiteQty; }

    public  int getMuleQty() {
        mule = getSmithoreMuleQty() + getFoodMuleQty() + getCrystiteMuleQty() + getEnergyMuleQty();
        return mule;
    }
    public  void setMuleQty(int muleQty) {
        mule = muleQty;
    }

    public  int getFoodMuleQty() { return foodMule; }
    public  int getFoodMulePrice() { return 125; }
    public  void setFoodMuleQty(int foodMuleQty) { foodMule = foodMuleQty; }

    public  int getEnergyMuleQty() { return energyMule; }
    public  int getEnergyMulePrice() { return 150; }
    public  void setEnergyMuleQty(int energyMuleQty) { energyMule = energyMuleQty; }

    public  int getCrystiteMuleQty() { return crystiteMule; }
    public  int getCrystiteMulePrice() { return 200; }
    public  void setCrystiteMuleQty(int crystiteMuleQty) { crystiteMule = crystiteMuleQty; }

    public  int getSmithoreMuleQty() { return oreMule; }
    public  int getSmithoreMulePrice() { return 175; }
    public  void setSmithoreMuleQty(int oreMuleQty) { oreMule = oreMuleQty; }


    public  int getSantaMuleQty() { return santaMule; }
    public  int getSantaMulePrice() { return 350; }
    public  void setSantaMuleQty(int santaMuleQty) { santaMule = santaMuleQty; }

    public  int getWineMuleQty() { return wineMule; }
    public  int getWineMulePrice() { return 110; }
    public  void setWineMuleQty(int wineMuleQty) { wineMule = wineMuleQty; }

    public  int getCombatMuleQty() { return combatMule; }
    public  int getCombatMulePrice() { return 155; }
    public  void setCombatMuleQty(int combatMuleQty) { combatMule = combatMuleQty; }

}
