package MyMathLib;

import org.junit.Assert;
import org.junit.Test;

public class VectorTest {
    final static double ERROR_TOLERANCE = 5E-10;

    Vector x1 = new Vector(0, 1, 0);
    Vector x2 = new Vector(4, 0, 6);
    Vector x3 = new Vector(10, 100, 1000);

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
    public void testDiv() throws Exception {
        Assert.assertEquals(x1, x1.div(new Vector(1, 1, 1)));
    }

    @Test
    public void testApplyFunction() {
        Assert.assertEquals(new Vector(1.00, 2.00, 3.00), x3.apply(x -> Math.log10(x)));
    }

    @Test
    public void testWhich() {
        Assert.assertEquals(new Vector(0, 2), x1.which(x -> x == 0));
    }

    @Test
    public void testAtIntegers() {
        Assert.assertEquals(new Vector(0, 0), x1.at(0, 2));
    }

    @Test
    public void testAtVector() {
        Assert.assertEquals(new Vector(0, 0), x1.at(new Vector(0, 2)));
    }

    @Test
    public void testVectorConcatenation() {
        Assert.assertEquals(new Vector(0, 1, 0, 4, 0, 6), Vector.concat(x1, x2));
    }

}
