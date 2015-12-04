package mule.junit;

import junit.framework.Assert;
import mule.model.Player;
import mule.model.River;
import mule.model.Tile;
import org.junit.Test;

/**
 * Created by ryyanj on 12/3/15.
 */
public class PlayerTest {

    @Test
    public void testSomething() {

        Player player = new Player();
        Tile tile = new River();
        tile.setOwner(player);
        //player.addtile(tile);
        Assert.assertEquals(0, player.getStartMoney(null));
        Assert.assertEquals(600, player.getStartMoney("Human"));
        Assert.assertEquals(1600, player.getStartMoney("Flapper"));
        Assert.assertEquals(1000, player.getStartMoney("randomRace"));
        Assert.assertNotNull(tile.getOwner());
        //Assert.assertNotNull(player.getTiles());

    }
}
