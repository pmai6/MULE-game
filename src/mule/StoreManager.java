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
//        int foodPrice = Store.getFoodPrice();
//        int currentPlayerMoney = RoundManager.getCurrentPlayer().getMoney();
//        int playerFoodAmount = RoundManager.getCurrentPlayer().getFood();
//        int storeFoodAmount = Store.getFoodQuantity();
//        int totalFoodCost = foodPrice * quantityFood;
//        if(currentPlayerMoney >= totalFoodCost) {
//            RoundManager.getCurrentPlayer().setFood(playerFoodAmount + quantityFood);
//            RoundManager.getCurrentPlayer().setMoney(currentPlayerMoney - totalFoodCost);
//            Store.setFoodQuantity(storeFoodAmount - quantityFood);
//        }
//        else
//            System.out.println("insufficient funds");
    }

    public void sellFood(int quantityFood) {
        //waiting for zuri to implement Store class
//        int foodPrice = Store.getFoodPrice();
//        int currentPlayerMoney = RoundManager.getCurrentPlayer().getMoney();
//        int playerFoodAmount = RoundManager.getCurrentPlayer().getFood();
//        int storeFoodAmount = Store.getFoodQuantity();
//        int totalFoodCost = foodPrice * quantityFood;
//        if(playerFoodAmount <= quantityFood) {
//            RoundManager.getCurrentPlayer().setFood(playerFoodAmount - quantityFood);
//            RoundManager.getCurrentPlayer().setMoney(currentPlayerMoney + totalFoodCost);
//            Store.setFoodQuantity(storeFoodAmount - quantityFood);
//        }
//        else
//            System.out.println("insufficient food amount");

    }


}
