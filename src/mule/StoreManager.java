package mule;

import mule.Store;
import mule.model.Player;
import mule.model.Round;

/**
 * Created by travisclement on 9/30/15.
 */
public class StoreManager {


    public void buyFood(int quantityFood) {
        //waiting for zuri to implement Store class
        int foodPrice = Store.getFoodPrice() ;
        int currentPlayerMoney = RoundManager.getCurrentPlayer().getMoney();
        int playerFoodAmount = RoundManager.getCurrentPlayer().getFood();
        int storeFoodAmount = Store.getFoodQty();
        int totalFoodCost = foodPrice * quantityFood;
        //if players has enough money to buy and store has enough food to ell
        if(currentPlayerMoney >= totalFoodCost && storeFoodAmount <= quantityFood) {
            RoundManager.getCurrentPlayer().setFood(playerFoodAmount + quantityFood);
            RoundManager.getCurrentPlayer().setMoney(currentPlayerMoney - totalFoodCost);
            Store.setFoodQty(storeFoodAmount - quantityFood);
        }
        else
            System.out.println("insufficient funds");
    }

    public void sellFood(int quantityFood) {
        //waiting for zuri to implement Store class
        int foodPrice = Store.getFoodPrice();
        int currentPlayerMoney = RoundManager.getCurrentPlayer().getMoney();
        int playerFoodAmount = RoundManager.getCurrentPlayer().getFood();
        int storeFoodAmount = Store.getFoodQty();
        int totalFoodCost = foodPrice * storeFoodAmount;
        //if store player has enough food to sell
        if(playerFoodAmount <= quantityFood) {
            RoundManager.getCurrentPlayer().setFood(playerFoodAmount - quantityFood);
            RoundManager.getCurrentPlayer().setMoney(currentPlayerMoney + totalFoodCost);
            Store.setFoodQty(storeFoodAmount + quantityFood);
        }
        else
            System.out.println("insufficient food amount");

    }


}
