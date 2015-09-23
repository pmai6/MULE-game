package mule.model;
/**
 * Created by ryyanj on 9/20/15.
 */

public class Turn {

    Player player; //which player's turn
    boolean isOver;

    public Turn() {

    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public boolean isTurnOver() {
        //some conditions
        return isOver;
    }

    public void endTurn() {
        isOver = true;
    }
}