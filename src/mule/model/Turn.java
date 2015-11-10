package mule.model;

/**
 * Created by ryyanj on 9/20/15.
 */

public class Turn {

    private Player player; //which player's turn

    public Turn() {

    }

    public void setPlayer(Player aplayer) {
        this.player = aplayer;
    }

    public Player getPlayer() {
        return this.player;
    }

    public boolean isTurnOver() {
        //some conditions
        return false;
    }

}