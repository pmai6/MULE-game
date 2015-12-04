package mule.junit;

import junit.framework.Assert;
import mule.PlayerManager;
import mule.model.Player;
import org.junit.Test;

/**
 * Created by ryyanj on 12/4/15.
 */
public class PlayerManagerTest {

    @Test
    public void testSomething() {

        Player player = new Player();
        PlayerManager.addPlayerFood(player, 50);
        Assert.assertEquals(50, player.getFood());
        PlayerManager.addPlayerFood(player, 50);
        Assert.assertEquals(100, player.getFood());

    }

}
