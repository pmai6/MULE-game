package mule;

import mule.model.*;

/**
 * Created by travisclement on 9/30/15.
 */
public class StoreManager {

    /** Stub method
     * Method to deduct store's inventory
     * @param quantityFood - deduct amount
     */
    public static void exportFood(int quantityFood) {
        int foodPrice = Store.getFoodPrice() ;
        Player currentPlayer = RoundManager.getCurrentPlayer();
        //int playerFoodAmount = RoundManager.getCurrentPlayer().getFood();
        int storeFoodAmount = Store.getFoodQty();
        int totalFoodCost = foodPrice * quantityFood;
        //if players has enough money to buy and store has enough food to ell
        if(currentPlayer.getMoney() >= totalFoodCost && storeFoodAmount <= quantityFood) {
           // RoundManager.getCurrentPlayer().setFood(playerFoodAmount + quantityFood);
            PlayerManager.buyResources(currentPlayer,"food", quantityFood);
            //RoundManager.getCurrentPlayer().setMoney(currentPlayerMoney - totalFoodCost);
            Store.setFoodQty(storeFoodAmount - quantityFood);
        }
        else
            System.out.println("insufficient funds");
    }
    /** Stub method
     * Method to add store's inventory
     * @param quantityFood - deduct amount
     */
    public static void importFood(int quantityFood) {
        //int foodPrice = Store.getFoodPrice();
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int playerFoodAmount = currentPlayer.getFood();
        int storeFoodAmount = Store.getFoodQty();
        //int totalFoodCost = foodPrice * storeFoodAmount;
        //if store player has enough food to sell
        if(playerFoodAmount <= quantityFood) {
//            RoundManager.getCurrentPlayer().setFood(playerFoodAmount - quantityFood);
//            RoundManager.getCurrentPlayer().setMoney(currentPlayer.getMoney() + totalFoodCost);
            System.out.println("insufficient food amount");
        }
        else
            PlayerManager.sellResources(currentPlayer, "food", quantityFood);
            Store.setFoodQty(storeFoodAmount + quantityFood);
    }

    public static void exportEnergy(int quantityEnergy) {
        int energyPrice = Store.getEnergyPrice() ;
        Player currentPlayer = RoundManager.getCurrentPlayer();
        //int playerEnergyAmount = RoundManager.getCurrentPlayer().getEnergy();
        int storeEnergyAmount = Store.getEnergyQty();
        int totalEnergyCost = energyPrice * quantityEnergy;
        //if players has enough money to buy and store has enough food to ell
        if(currentPlayer.getMoney() >= totalEnergyCost && storeEnergyAmount <= quantityEnergy) {
            // RoundManager.getCurrentPlayer().setFood(playerFoodAmount + quantityFood);
            PlayerManager.buyResources(currentPlayer,"energy", quantityEnergy);
            //RoundManager.getCurrentPlayer().setMoney(currentPlayerMoney - totalFoodCost);
            Store.setEnergyQty(storeEnergyAmount - quantityEnergy);
        }
        else
            System.out.println("insufficient funds");
    }
    public static void importEnergy(int quantityEnergy) {
        //int energyPrice = Store.getEnergyPrice() ;
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int playerEnergyAmount = currentPlayer.getEnergy();
        int storeEnergyAmount = Store.getEnergyQty();
        //int totalEnergyCost = energyPrice * quantityEnergy;
        //if players has enough money to buy and store has enough food to ell
        if(playerEnergyAmount <= quantityEnergy) {
            // RoundManager.getCurrentPlayer().setFood(playerFoodAmount + quantityFood);
            System.out.println("insufficient funds");
        }
        else
            System.out.println("insufficient funds");
            PlayerManager.sellResources(currentPlayer, "energy", quantityEnergy);
            //RoundManager.getCurrentPlayer().setMoney(currentPlayerMoney - totalFoodCost);
            Store.setEnergyQty(storeEnergyAmount + quantityEnergy);
    }

    public static void exportSmithore(int quantitySmithore) {
        int smithorePrice = Store.getSmithorePrice() ;
        Player currentPlayer = RoundManager.getCurrentPlayer();
        //int playerSmithoreAmount = currentPlayer.getSmithore();
        int storeSmithoreAmount = Store.getSmithoreQty();
        int totalSmithoreCost = smithorePrice * quantitySmithore;
        //if players has enough money to buy and store has enough food to ell
        if(currentPlayer.getMoney() >= totalSmithoreCost && storeSmithoreAmount <= quantitySmithore) {
            // RoundManager.getCurrentPlayer().setFood(playerFoodAmount + quantityFood);
            PlayerManager.buyResources(currentPlayer,"smithore", quantitySmithore);
            //RoundManager.getCurrentPlayer().setMoney(currentPlayerMoney - totalFoodCost);
            Store.setSmithoreQty(storeSmithoreAmount - quantitySmithore);
        }
        else
            System.out.println("insufficient funds");
    }
    public static void importSmithore(int quantitySmithore) {
        //int smithorePrice = Store.getSmithorePrice() ;
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int playerSmithoreAmount = currentPlayer.getSmithore();
        int storeSmithoreAmount = Store.getSmithoreQty();
        //int totalSmithoreCost = smithorePrice * quantitySmithore;
        //if players has enough money to buy and store has enough food to ell
        if(playerSmithoreAmount <= quantitySmithore) {
            // RoundManager.getCurrentPlayer().setFood(playerFoodAmount + quantityFood);
            System.out.println("insufficient funds");
        }
        else
            System.out.println("insufficient funds");
            PlayerManager.sellResources(currentPlayer,"smithore", quantitySmithore);
            //RoundManager.getCurrentPlayer().setMoney(currentPlayerMoney - totalFoodCost);
            Store.setSmithoreQty(storeSmithoreAmount + quantitySmithore);
    }

    public static void exportCrystite(int quantityCrystite) {
        int crystitePrice = Store.getCrystitePrice() ;
        Player currentPlayer = RoundManager.getCurrentPlayer();
        //int playerCrystiteAmount = currentPlayer.getCrystite();
        int storeCrystiteAmount = Store.getCrystiteQty();
        int totalSmithoreCost = crystitePrice * quantityCrystite;
        //if players has enough money to buy and store has enough food to ell
        if(currentPlayer.getMoney() >= totalSmithoreCost && storeCrystiteAmount <= quantityCrystite) {
            // RoundManager.getCurrentPlayer().setFood(playerFoodAmount + quantityFood);
            PlayerManager.buyResources(currentPlayer,"crystite", quantityCrystite);
            //RoundManager.getCurrentPlayer().setMoney(currentPlayerMoney - totalFoodCost);
            Store.setCrystiteQty(storeCrystiteAmount - quantityCrystite);
        }
        else
            System.out.println("insufficient funds");
    }
    public static void importCrystite(int quantityCrystite) {
        int crystitePrice = Store.getCrystitePrice() ;
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int playerCrystiteAmount = currentPlayer.getCrystite();
        int storeCrystiteAmount = Store.getEnergyQty();
       // int totalCrystiteCost = crystitePrice * quantityCrystite;
        //if players has enough money to buy and store has enough food to ell
        if(playerCrystiteAmount <= quantityCrystite) {
            // RoundManager.getCurrentPlayer().setFood(playerFoodAmount + quantityFood);
            System.out.println("insufficient funds");
        }
        else
            PlayerManager.sellResources(currentPlayer, "crystite", quantityCrystite);
            //RoundManager.getCurrentPlayer().setMoney(currentPlayerMoney - totalFoodCost);
            Store.setCrystiteQty(storeCrystiteAmount + quantityCrystite);

    }

    public static void exportOre(int quantityOre) {
        int orePrice = Store.getorePrice() ;
        Player currentPlayer = RoundManager.getCurrentPlayer();
        //int playerCrystiteAmount = currentPlayer.getCrystite();
        int storeOreAmount = Store.getOreQty();
        int totalOreCost = orePrice * quantityOre;
        //if players has enough money to buy and store has enough food to ell
        if(currentPlayer.getMoney() >= totalOreCost && storeOreAmount <= quantityOre) {
            // RoundManager.getCurrentPlayer().setFood(playerFoodAmount + quantityFood);
            PlayerManager.buyResources(currentPlayer,"ore", quantityOre);
            //RoundManager.getCurrentPlayer().setMoney(currentPlayerMoney - totalFoodCost);
            Store.setOreQty(storeOreAmount - quantityOre);
        }
        else
            System.out.println("insufficient funds");
    }
    public static void importOre(int quantityOre) {
        int orePrice = Store.getorePrice() ;
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int playerOreAmount = currentPlayer.getOre();
        int storeOreAmount = Store.getOreQty();
        // int totalCrystiteCost = crystitePrice * quantityCrystite;
        //if players has enough money to buy and store has enough food to ell
        if(playerOreAmount <= quantityOre) {
            // RoundManager.getCurrentPlayer().setFood(playerFoodAmount + quantityFood);
            System.out.println("insufficient funds");
        }
        else
            PlayerManager.sellResources(currentPlayer, "ore", quantityOre);
            //RoundManager.getCurrentPlayer().setMoney(currentPlayerMoney - totalFoodCost);
            Store.setCrystiteQty(storeOreAmount + quantityOre);
            System.out.println("insufficient funds");
    }


    public static void buyMule(String muleName) {
        Player player = RoundManager.getCurrentPlayer();
        Mule mule = null;
        Game.setIsMuleBought(true);
        if (muleName.equals("Food")) {
            mule = new FoodMule();
        } else if (muleName.equals("Energy")) {
            mule = new EnergyMule();
        } else if (muleName.equals("Smithore")) {
            mule = new SmithoreMule();
        } else if (muleName.equals("Crystite")) {
            mule = new CrystiteMule();
        }
        GameManager.setGameStateLabel();
        PlayerManager.buyMule(player,mule);
    }
}
