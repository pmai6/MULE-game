package mule.junit;

import junit.framework.Assert;
import mule.model.Mule;
import mule.model.EnergyMule;
import mule.model.Player;
import mule.model.River;
import mule.model.Tile;
import org.junit.Test;

/**
 * Created by ryyanj on 12/4/15.
 */
public class MuleTest {

    @Test
    public void testSomething() {

        Mule mule = new EnergyMule();;
        Player player = new Player();
        mule.setOwner(player);
        Tile tile = new River();
        tile.setOwner(player);
        Assert.assertEquals(150, mule.getCost());
        Assert.assertNotNull(mule.getOwner());
        Assert.assertEquals(600,mule.getOwner().getStartMoney("Human"));

    }

}
