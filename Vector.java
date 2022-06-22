package MyMathLib;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Vector {
    static private final String ERROR_UNEQUAL_SIZE = "Unequally sized vectors.";

    public final double[] values;
    public int length;

    public Vector(double... values) {
        this.values = values;
        this.length = values.length;
    }

    public Vector plus(Vector another) throws Exception {
        if (this.length != another.length) {
            throw new Exception(ERROR_UNEQUAL_SIZE);
        }
        double[] added = IntStream.range(0, this.values.length).mapToDouble(i -> this.values[i] + another.values[i]).toArray();
        return new Vector(added);
    }

    public Vector minus(Vector another) throws Exception {
        if (this.length != another.length) {
            throw new Exception(ERROR_UNEQUAL_SIZE);
        }
        double[] added = IntStream.range(0, this.values.length).mapToDouble(i -> this.values[i] - another.values[i]).toArray();
        return new Vector(added);
    }

    public Vector div(Vector another) throws Exception {
        if (this.length != another.length) {
            throw new Exception(ERROR_UNEQUAL_SIZE);
        }
        double[] added = IntStream.range(0, this.values.length).mapToDouble(i -> this.values[i] / another.values[i]).toArray();
        return new Vector(added);
    }

    public Vector times(Vector another) throws Exception {
        if (this.length != another.length) {
            throw new Exception(ERROR_UNEQUAL_SIZE);
        }
        double[] added = IntStream.range(0, this.values.length).mapToDouble(i -> this.values[i] * another.values[i]).toArray();
        return new Vector(added);
    }

    public Vector apply(Function<Double, Double> function) {
        double[] doubles = Arrays.stream(this.values).map(function::apply).toArray();
        return new Vector(doubles);
    }

    public Vector which(Predicate<Double> predicate) {
        IntStream range = IntStream.range(0, this.values.length);
        double[] valueArray = range.filter(i -> predicate.test(this.values[i])).mapToDouble(x -> x).toArray();
        return new Vector(valueArray);
    }

    public Vector at(int... positions) {
        double[] valueArray = Arrays.stream(positions).mapToDouble(i -> this.values[i]).toArray();
        return new Vector(valueArray);
    }

    public Vector at(Vector vector) {
        int[] positions = Arrays.stream(vector.values).mapToInt(x -> (int) x).toArray();
        return at(positions);
    }

    public Vector slice(int start, int stop) {
        int[] ints = IntStream.range(start, stop).toArray();
        return at(ints);
    }

    public Vector slice(int stop) {
        return slice(0, stop);
    }

    public void print() {
        Arrays.stream(values).forEach(x -> System.out.print(x + ", "));
    }

    public static double dot(Vector x1, Vector x2) throws Exception {
        if (x1.length != x2.length) {
            throw new Exception(ERROR_UNEQUAL_SIZE);
        }
        return Arrays.stream(x1.times(x2).values).sum();
    }

    public static Vector concat(Vector x1, Vector x2) {
        DoubleStream s1 = Arrays.stream(x1.values);
        DoubleStream s2 = Arrays.stream(x2.values);
        double[] values = DoubleStream.concat(s1, s2).toArray();
        return new Vector(values);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector that = (Vector) o;
        return Arrays.equals(values, that.values);
    }

}
