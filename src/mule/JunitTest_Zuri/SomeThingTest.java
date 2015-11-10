package mule.JunitTest_Zuri;

import static org.junit.Assert.*;

import mule.GameManager;
import mule.model.Store;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

/**
 * Created by redcream12 on 11/6/15.
 */
public class SomeThingTest {
    /**
     * The test fixture
     */
    GameManager gameManager;
    Store gameStore;
    /**
     * This method is run before each test
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        gameManager = GameManager.getGameManager();
        gameStore = new Store(8,10,0,3,5);

    }
    /**
     * Test method for {@link edu.gatech.github.rsmith368.cs2340_MULE.src.mule.MapManager#placeMule()}.
     */
    @Test
    public void testExportFood() {
        Assert.assertEquals("Wrong", 100, theStack.getCapacity());
    }
    @After


}
