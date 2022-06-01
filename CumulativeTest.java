package MyMathLib;

import org.junit.Assert;
import org.junit.Test;

public class CumulativeTest {
    final static Vector x1 = new Vector(1, 10, -3);

    @Test
    public void testCumulativeSum() {
        Assert.assertEquals(new Vector(1, 11, 8), Cumulative.sum(x1));
    }

    @Test
    public void testCumulativeProduct() {
        Assert.assertEquals(new Vector(1, 10, -30), Cumulative.product(x1));
    }

}
