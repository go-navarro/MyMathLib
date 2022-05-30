package MyMathLib;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Vector {
    private final int[] values;

    public Vector(int... values) {
        this.values = values;
    }

    public Vector plus(Vector another) {
        int[] added = IntStream.range(0, this.values.length).map(i -> this.values[i] + another.values[i]).toArray();
        return new Vector(added);
    }

    public Vector minus(Vector another) {
        int[] added = IntStream.range(0, this.values.length).map(i -> this.values[i] - another.values[i]).toArray();
        return new Vector(added);
    }

    public Vector times(Vector another) {
        int[] added = IntStream.range(0, this.values.length).map(i -> this.values[i] * another.values[i]).toArray();
        return new Vector(added);
    }

    public static int dot(Vector x1, Vector x2) {
        return Arrays.stream(x1.times(x2).values).sum();
    }

    public int[] where(Predicate predicate) {
        // TODO Return indexes where a statement holds.
        return null;
    }

    public static int[] at(Vector mathVector) {
        // TODO Return indexes where a statement holds.
        return null;
    }

    public void print() {
        Arrays.stream(values).forEach(x -> System.out.print(x + ", "));
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector that = (Vector) o;
        return Arrays.equals(values, that.values);
    }

}
