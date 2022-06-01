package MyMathLib;

public class Cumulative {

    public static Vector sum(Vector vector) {
        double[] cumulativeSums = new double[vector.length];
        double totalSum = 0.0;
        for (int i = 0; i < vector.length; i++) {
            totalSum = totalSum + vector.values[i];
            cumulativeSums[i] = totalSum;
        }
        return new Vector(cumulativeSums);
    }

    public static Vector product(Vector vector) {
        double[] cumulativeProducts = new double[vector.length];
        double totalProd = 1.0;
        for (int i = 0; i < vector.length; i++) {
            totalProd = totalProd * vector.values[i];
            cumulativeProducts[i] = totalProd;
        }
        return new Vector(cumulativeProducts);
    }

}
