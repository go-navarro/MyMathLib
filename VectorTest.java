package MyMathLib;

import org.junit.Assert;
import org.junit.Test;

public class VectorTest {
    Vector x1 = new Vector(0, 1, 0);
    Vector x2 = new Vector(4, 0, 6);

    @Test
    public void testAddition() throws Exception {
        Assert.assertEquals(x1.plus(x2), new Vector(4, 1, 6));
    }

    @Test
    public void testAddition2() throws Exception {
        Assert.assertEquals(x1.plus(x2), new Vector(4, 1, 6));
    }

    @Test
    public void testSubtraction() throws Exception {
        Assert.assertEquals(x1.minus(x2), new Vector(-4, 1, -6));
    }

    @Test
    public void testMultiplication() throws Exception {
        Assert.assertEquals(x1.times(x2), new Vector(0, 0, 0));
    }

    @Test
    public void testDotProduct() throws Exception {
        Assert.assertEquals(Vector.dot(x1, x2), 0);
    }

    @Test
    public void testWhich() {
        Assert.assertEquals(x1.which(x -> x == 0), new Vector(0, 2));
    }

    @Test
    public void testAt() {
        Assert.assertEquals(x1.at(0, 2), new Vector(0, 0));
    }

}
