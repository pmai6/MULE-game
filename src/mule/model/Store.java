package mule.model;

import java.io.Serializable;

/**
 * The type Store.
 */
public class Store implements Serializable {
    /**
     * The Food.
     */
    private  int food = 16;
    /**
     * The Energy.
     */
    private  int energy = 16;
    /**
     * The Smithore.
     */
    private  int smithore = 0;
    /**
     * The Crystite.
     */
    private  int crystite = 0;
    /**
     * The Food mule.
     */
    private  int foodMule = 7;
    /**
     * The Crystite mule.
     */
    private  int crystiteMule = 6;
    /**
     * The Ore mule.
     */
    private  int oreMule = 6;
    /**
     * The Energy mule.
     */
    private  int energyMule = 6;
    /**
     * The Mule.
     */
    private  int mule = 25;


    /**
     * Instantiates a new Store.
     */
    public Store() {

    }

    /**
     * Instantiates a new Store.
     *
     * @param food     the food
     * @param energy   the energy
     * @param smithore the smithore
     * @param crystite the crystite
     * @param mule     the mule
     */
    public Store(int food, int energy, int smithore, int crystite, int mule) {
        this.food = food;
        this.energy = energy;
        this.smithore = smithore;
        this.crystite = crystite;
        this.mule = mule;
    }
/*    private void setStartStoreQuantity() {
        food = 16;
        energy = 16;
        smithore = 0;
        crystite = 0;
        mule = 25;
    }*/

    /**
     * Gets food qty.
     *
     * @return the food qty
     */
    public  int getFoodQty() {
        return food;
    }

    /**
     * Gets food price.
     *
     * @return the food price
     */
    public  int getFoodPrice() {
        return 30;
    }

    /**
     * Sets food qty.
     *
     * @param foodQty the food qty
     */
    public  void setFoodQty(int foodQty) {
        food = foodQty;
    }

    /**
     * Gets energy qty.
     *
     * @return the energy qty
     */
    public  int getEnergyQty() {
        return energy;
    }

    /**
     * Gets energy price.
     *
     * @return the energy price
     */
    public  int getEnergyPrice() {
        return 25;
    }

    /**
     * Sets energy qty.
     *
     * @param energyQty the energy qty
     */
    public  void setEnergyQty(int energyQty) {
        energy = energyQty;
    }

    /**
     * Gets smithore qty.
     *
     * @return the smithore qty
     */
    public  int getSmithoreQty() {
        return smithore;
    }

    /**
     * Gets smithore price.
     *
     * @return the smithore price
     */
    public  int getSmithorePrice() {
        return 50;
    }

    /**
     * Sets smithore qty.
     *
     * @param smithoreQty the smithore qty
     */
    public  void setSmithoreQty(int smithoreQty) {
        smithore = smithoreQty;
    }

    /**
     * Gets crystite qty.
     *
     * @return the crystite qty
     */
    public  int getCrystiteQty() {
        return crystite;
    }

    /**
     * Gets crystite price.
     *
     * @return the crystite price
     */
    public  int getCrystitePrice() {
        return 100;
    }

    /**
     * Sets crystite qty.
     *
     * @param crystiteQty the crystite qty
     */
    public  void setCrystiteQty(int crystiteQty) {
        crystite = crystiteQty;
    }

    /**
     * Gets mule qty.
     *
     * @return the mule qty
     */
    public  int getMuleQty() {
        mule = getSmithoreMuleQty() + getFoodMuleQty();
        mule = mule + getEnergyMuleQty() + getCrystiteMuleQty();
        return mule;
    }

    /**
     * Sets mule qty.
     *
     * @param muleQty the mule qty
     */
    public  void setMuleQty(int muleQty) {
        mule = muleQty;
    }

    /**
     * Gets food mule qty.
     *
     * @return the food mule qty
     */
    public  int getFoodMuleQty() {
        return foodMule;
    }

    /**
     * Gets food mule price.
     *
     * @return the food mule price
     */
    public  int getFoodMulePrice() {
        return 125;
    }

    /**
     * Sets food mule qty.
     *
     * @param foodMuleQty the food mule qty
     */
    public  void setFoodMuleQty(int foodMuleQty) {
        foodMule = foodMuleQty;
    }

    /**
     * Gets energy mule qty.
     *
     * @return the energy mule qty
     */
    public  int getEnergyMuleQty() {
        return energyMule;
    }

    /**
     * Gets energy mule price.
     *
     * @return the energy mule price
     */
    public  int getEnergyMulePrice() {
        return 150;
    }

    /**
     * Sets energy mule qty.
     *
     * @param energyMuleQty the energy mule qty
     */
    public  void setEnergyMuleQty(int energyMuleQty) {
        energyMule = energyMuleQty;
    }

    /**
     * Gets crystite mule qty.
     *
     * @return the crystite mule qty
     */
    public  int getCrystiteMuleQty() {
        return crystiteMule;
    }

    /**
     * Gets crystite mule price.
     *
     * @return the crystite mule price
     */
    public  int getCrystiteMulePrice() {
        return 200;
    }

    /**
     * Sets crystite mule qty.
     *
     * @param crystiteMuleQty the crystite mule qty
     */
    public  void setCrystiteMuleQty(int crystiteMuleQty) {
        crystiteMule = crystiteMuleQty;
    }

    /**
     * Gets smithore mule qty.
     *
     * @return the smithore mule qty
     */
    public  int getSmithoreMuleQty() {
        return oreMule;
    }

    /**
     * Gets smithore mule price.
     *
     * @return the smithore mule price
     */
    public  int getSmithoreMulePrice() {
        return 175;
    }

    /**
     * Sets smithore mule qty.
     *
     * @param oreMuleQty the ore mule qty
     */
    public  void setSmithoreMuleQty(int oreMuleQty) {
        oreMule = oreMuleQty;
    }
}
