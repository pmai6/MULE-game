package mule.junit;

import junit.framework.Assert;
import mule.model.*;
import org.junit.Test;

/**
 * Created by ryyanj on 12/4/15.
 */
public class GameTest {

    @Test
    public void testSomething() {

        Player playerOne = new Player();
        Player playerTwo = new Player();
        Player playerThree = new Player();

        Game game = new Game("hard", 3, "random", 7);
        game.addPlayerToArray(playerOne);
        game.addPlayerToArray(playerTwo);
        game.addPlayerToArray(playerThree);

        Assert.assertEquals(3,game.getNumberOfPlayers());
        Assert.assertEquals(3,game.getPlayerArray().size());
        Assert.assertEquals(3,game.getSortedPlayerArray().size());

        Store store = new Store(30,30,30,30,30,30);
        game.setGamestore(store);
        Assert.assertNotNull(game.getGamestore());



    }
}
