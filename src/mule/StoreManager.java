package mule;

import mule.model.*;

/**
 * The type Store manager.
 */
public class StoreManager {
    /**
     * The constant gameManager.
     */
    private static GameManager gameManager = GameManager.getGameManager();
    /**
     * The constant gamestore.
     */
    private static Store gamestore = gameManager.getGameStore();

    /**
     * Export food.
     *
     * @param quantityFood the quantity food
     */
    public static void exportFood(int quantityFood) {
        int foodPrice = gamestore.getFoodPrice();
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int storeFoodAmount = gamestore.getFoodQty();
        int totalFoodCost = foodPrice * quantityFood;
        if (currentPlayer.getMoney() >= totalFoodCost && storeFoodAmount >=
                quantityFood) {
            PlayerManager.buyResources(currentPlayer, "food", quantityFood);
            gamestore.setFoodQty(storeFoodAmount - quantityFood);
            GameManager.getGameManager().updateStoreData();
        } else {
            gameManager.notEnoughMoney();
        }
    }

    /**
     * Import food.
     *
     * @param quantityFood the quantity food
     */
    public static void importFood(int quantityFood) {
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int playerFoodAmount = currentPlayer.getFood();
        int storeFoodAmount = gamestore.getFoodQty();
        if (playerFoodAmount <= quantityFood) {
            gameManager.notEnoughItem();
        } else {
            PlayerManager.sellResources(currentPlayer, "food", quantityFood);
            gamestore.setFoodQty(storeFoodAmount + quantityFood);
            GameManager.getGameManager().updateStoreData();
        }
    }

    /**
     * Export energy.
     *
     * @param quantityEnergy the quantity energy
     */
    public static void exportEnergy(int quantityEnergy) {
        int energyPrice = gamestore.getEnergyPrice();
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int storeEnergyAmount = gamestore.getEnergyQty();
        int totalEnergyCost = energyPrice * quantityEnergy;
        if (currentPlayer.getMoney() >= totalEnergyCost && storeEnergyAmount >=
                quantityEnergy) {
            PlayerManager.buyResources(currentPlayer, "energy", quantityEnergy);
            gamestore.setEnergyQty(storeEnergyAmount - quantityEnergy);
            GameManager.getGameManager().updateStoreData();

        } else {
            gameManager.notEnoughMoney();
        }
    }

    /**
     * Import energy.
     *
     * @param quantityEnergy the quantity energy
     */
    public static void importEnergy(int quantityEnergy) {
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int playerEnergyAmount = currentPlayer.getEnergy();
        int storeEnergyAmount = gamestore.getEnergyQty();
        if (playerEnergyAmount <= quantityEnergy) {
            gameManager.notEnoughItem();
        } else {
            PlayerManager.sellResources(currentPlayer, "energy", quantityEnergy);
            gamestore.setEnergyQty(storeEnergyAmount + quantityEnergy);
            GameManager.getGameManager().updateStoreData();
        }
    }

    /**
     * Export smithore.
     *
     * @param quantitySmithore the quantity smithore
     */
    public static void exportSmithore(int quantitySmithore) {
        int smithorePrice = gamestore.getSmithorePrice();
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int storeSmithoreAmount = gamestore.getSmithoreQty();
        int totalSmithoreCost = smithorePrice * quantitySmithore;
        if (currentPlayer.getMoney() >= totalSmithoreCost &&
                storeSmithoreAmount >= quantitySmithore) {
            PlayerManager.buyResources(currentPlayer, "smithore", quantitySmithore);
            gamestore.setEnergyQty(storeSmithoreAmount - quantitySmithore);
            GameManager.getGameManager().updateStoreData();

        } else {
            gameManager.notEnoughMoney();
        }
    }

    /**
     * Import smithore.
     *
     * @param quantitySmithore the quantity smithore
     */
    public static void importSmithore(int quantitySmithore) {
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int playerSmithoreAmount = currentPlayer.getSmithore();
        int storeSmithoreAmount = gamestore.getSmithoreQty();
        if (playerSmithoreAmount <= quantitySmithore) {
            gameManager.notEnoughItem();
        } else {
            PlayerManager.sellResources(currentPlayer, "smithore", quantitySmithore);
            gamestore.setSmithoreQty(storeSmithoreAmount + quantitySmithore);
            GameManager.getGameManager().updateStoreData();
        }
    }

    /**
     * Export crystite.
     *
     * @param quantityCrystite the quantity crystite
     */
    public static void exportCrystite(int quantityCrystite) {
        int crystitePrice = gameManager.getGameStore().getCrystitePrice();
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int storeCrystiteAmount = gamestore.getCrystiteQty();
        int totalSmithoreCost = crystitePrice * quantityCrystite;
        if (currentPlayer.getMoney() >= totalSmithoreCost &&
                storeCrystiteAmount >= quantityCrystite) {
            PlayerManager.buyResources(currentPlayer, "crystite", quantityCrystite);
            gamestore.setCrystiteQty(storeCrystiteAmount - quantityCrystite);
            GameManager.getGameManager().updateStoreData();

        } else {
            gameManager.notEnoughMoney();
        }
    }

    /**
     * Import crystite.
     *
     * @param quantityCrystite the quantity crystite
     */
    public static void importCrystite(int quantityCrystite) {
        Player currentPlayer = RoundManager.getCurrentPlayer();
        int playerCrystiteAmount = currentPlayer.getCrystite();
        int storeCrystiteAmount = gamestore.getEnergyQty();
        if (playerCrystiteAmount <= quantityCrystite) {
            gameManager.notEnoughItem();
        } else {
            PlayerManager.sellResources(currentPlayer, "crystite", quantityCrystite);
            gamestore.setCrystiteQty(storeCrystiteAmount + quantityCrystite);
            GameManager.getGameManager().updateStoreData();

        }
    }

    /**
     * Buy mule.
     *
     * @param muleName the mule name
     * @throws Exception the exception
     */
    public static void buyMule(String muleName) throws Exception{
        Player player = RoundManager.getCurrentPlayer();
        if (gamestore.getMuleQty() >= 1 && player.getUnplacedMule() == null) {
            Mule mule = null;
            gameManager.getMulegame().setIsMuleBought(true);
            if (muleName.equals("Food Mule")) {
                mule = new FoodMule();
            } else if (muleName.equals("Energy Mule")) {
                mule = new EnergyMule();
            } else if (muleName.equals("Smithore Mule")) {
                mule = new SmithoreMule();
            } else if (muleName.equals("Crystite Mule")) {
                mule = new CrystiteMule();
            }
            gameManager.setGameStateLabel();

            PlayerManager.buyMule(player, mule);
        } else {
            System.out.println("no more mules");
        }
    }
}
