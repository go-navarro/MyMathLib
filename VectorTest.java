package MyMathLib;

import org.junit.Assert;
import org.junit.Test;

public class VectorTest {
    final static double ERROR_TOLERANCE = 5E-10;

    Vector x1 = new Vector(0, 1, 0);
    Vector x2 = new Vector(4, 0, 6);
    Vector x3 = new Vector(10, 100, 1000, 1000000000);

    @Test
    public void testAddition() throws Exception {
        Assert.assertEquals(new Vector(4, 1, 6), x1.plus(x2));
    }

    @Test
    public void testSubtraction() throws Exception {
        Assert.assertEquals(new Vector(-4, 1, -6), x1.minus(x2));
    }

    @Test
    public void testMultiplication() throws Exception {
        Assert.assertEquals(new Vector(0, 0, 0), x1.times(x2));
    }

    @Test
    public void testDotProduct() throws Exception {
        Assert.assertEquals(0.00, Vector.dot(x1, x2), ERROR_TOLERANCE);
    }

    @Test
    public void testWhich() {
        Assert.assertEquals(new Vector(0, 2), x1.which(x -> x == 0));
    }

    @Test
    public void testAt() {
        Assert.assertEquals(new Vector(0, 0), x1.at(0, 2));
    }

    @Test
    public void testApplyFunction() {
        Vector y3 = x3.applyFunction(x -> Math.log10(x));
        Assert.assertEquals(new Vector(1.00, 2.00, 3.00, 9.00), y3);
    }

}
