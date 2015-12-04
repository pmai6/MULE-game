package mule.junit;

import junit.framework.Assert;
import mule.model.RandomEvent;
import org.junit.Test;

/**
 * Created by ryyanj on 12/3/15.
 */
public class RandomEventTest {

    @Test
    public void testSomething() {

        Assert.assertEquals(25, RandomEvent.getM(2));
        Assert.assertEquals(50, RandomEvent.getM(5));
        Assert.assertEquals(75, RandomEvent.getM(8));
        Assert.assertEquals(100, RandomEvent.getM(25));

    }
}
