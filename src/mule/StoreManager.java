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
        int storeFoodAmount = Store.getFoodQty();
        int totalFoodCost = foodPrice * quantityFood;
        if(currentPlayer.getMoney() >= totalFoodCost && storeFoodAmount <= quantityFood) {
            PlayerManager.buyResources(currentPlayer,"food", quantityFood);
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
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int playerFoodAmount = currentPlayer.getFood();
        int storeFoodAmount = Store.getFoodQty();
        if(playerFoodAmount <= quantityFood) {
            System.out.println("insufficient food amount");
        }
        else
            PlayerManager.sellResources(currentPlayer, "food", quantityFood);
            Store.setFoodQty(storeFoodAmount + quantityFood);
    }

    public static void exportEnergy(int quantityEnergy) {
        int energyPrice = Store.getEnergyPrice() ;
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int storeEnergyAmount = Store.getEnergyQty();
        int totalEnergyCost = energyPrice * quantityEnergy;
        if(currentPlayer.getMoney() >= totalEnergyCost && storeEnergyAmount <= quantityEnergy) {
            PlayerManager.buyResources(currentPlayer,"energy", quantityEnergy);
            Store.setEnergyQty(storeEnergyAmount - quantityEnergy);
        }
        else
            System.out.println("insufficient funds");
    }
    public static void importEnergy(int quantityEnergy) {
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int playerEnergyAmount = currentPlayer.getEnergy();
        int storeEnergyAmount = Store.getEnergyQty();
        if(playerEnergyAmount <= quantityEnergy) {
            System.out.println("insufficient funds");
        }
        else
            System.out.println("insufficient funds");
            PlayerManager.sellResources(currentPlayer, "energy", quantityEnergy);
            Store.setEnergyQty(storeEnergyAmount + quantityEnergy);
    }

    public static void exportSmithore(int quantitySmithore) {
        int smithorePrice = Store.getSmithorePrice() ;
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int storeSmithoreAmount = Store.getSmithoreQty();
        int totalSmithoreCost = smithorePrice * quantitySmithore;
        if(currentPlayer.getMoney() >= totalSmithoreCost && storeSmithoreAmount <= quantitySmithore) {
            PlayerManager.buyResources(currentPlayer,"smithore", quantitySmithore);
            Store.setEnergyQty(storeSmithoreAmount - quantitySmithore);
        }
        else
            System.out.println("insufficient funds");
    }
    public static void importSmithore(int quantitySmithore) {
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int playerSmithoreAmount = currentPlayer.getSmithore();
        int storeSmithoreAmount = Store.getSmithoreQty();
        if(playerSmithoreAmount <= quantitySmithore) {
            System.out.println("insufficient funds");
        }
        else
            System.out.println("insufficient funds");
            PlayerManager.sellResources(currentPlayer, "smithore", quantitySmithore);
            Store.setSmithoreQty(storeSmithoreAmount + quantitySmithore);
    }

    public static void exportCrystite(int quantityCrystite) {
        int crystitePrice = Store.getCrystitePrice() ;
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int storeCrystiteAmount = Store.getCrystiteQty();
        int totalSmithoreCost = crystitePrice * quantityCrystite;
        if(currentPlayer.getMoney() >= totalSmithoreCost && storeCrystiteAmount <= quantityCrystite) {
            PlayerManager.buyResources(currentPlayer,"crystite", quantityCrystite);
            Store.setCrystiteQty(storeCrystiteAmount - quantityCrystite);
        }
        else
            System.out.println("insufficient funds");
    }
    public static void importCrystite(int quantityCrystite) {
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int playerCrystiteAmount = currentPlayer.getCrystite();
        int storeCrystiteAmount = Store.getEnergyQty();
        if(playerCrystiteAmount <= quantityCrystite) {
            System.out.println("insufficient funds");
        }
        else
            System.out.println("insufficient funds");
            PlayerManager.sellResources(currentPlayer, "crystite", quantityCrystite);
            Store.setCrystiteQty(storeCrystiteAmount + quantityCrystite);

    }

//    public static void exportOre(int quantityOre) {
//        int orePrice = Store.getorePrice() ;
//        Player currentPlayer = RoundManager.getCurrentPlayer();
//        int storeOreAmount = Store.getOreQty();
//        int totalOreCost = orePrice * quantityOre;
//        if(currentPlayer.getMoney() >= totalOreCost && storeOreAmount <= quantityOre) {
//            PlayerManager.buyResources(currentPlayer,"ore", quantityOre);
//            Store.setOreQty(storeOreAmount - quantityOre);
//        }
//        else
//            System.out.println("insufficient funds");
//    }
//    public static void importOre(int quantityOre) {
//        int orePrice = Store.getorePrice() ;
//        Player currentPlayer = RoundManager.getCurrentPlayer();
//        int playerOreAmount = currentPlayer.getOre();
//        int storeOreAmount = Store.getOreQty();
//        if(playerOreAmount <= quantityOre) {
//            System.out.println("insufficient funds");
//        }
//        else
//            PlayerManager.sellResources(currentPlayer, "ore", quantityOre);
//            Store.setCrystiteQty(storeOreAmount + quantityOre);
//            System.out.println("insufficient funds");
//    }


    public static void buyMule(String muleName) {
        Player player = RoundManager.getCurrentPlayer();
        Mule mule = null;
        Game.setIsMuleBought(true);
        if (muleName.equals("Food Mule")) {
            mule = new FoodMule();
        } else if (muleName.equals("Energy Mule")) {
            mule = new EnergyMule();
        } else if (muleName.equals("Smithore Mule")) {
            mule = new SmithoreMule();
        } else if (muleName.equals("Crystite Mule")) {
            mule = new CrystiteMule();
        }
        GameManager.setGameStateLabel();
        PlayerManager.buyMule(player,mule);
    }
}
