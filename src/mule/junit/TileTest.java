package mule.junit;

import junit.framework.Assert;
import mule.model.EnergyMule;
import mule.model.Player;
import mule.model.River;
import mule.model.Tile;
import mule.model.Mule;
import org.junit.Test;

/**
 * Created by ryyanj on 12/4/15.
 */
public class TileTest {


    @Test
    public void testSomething() {
        Player player = new Player();
        Tile tile = new River();
        Mule mule = new EnergyMule();
        tile.setOwner(player);
        tile.addMule(mule);
        Assert.assertNotNull(tile.getOwner());
        Assert.assertEquals(300,tile.getCost());
        Assert.assertNotNull(tile.getMule());

        //Assert.assertNotNull(player.getTiles());

    }
}
