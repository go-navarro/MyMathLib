package MyMathLib;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Vector {
    static private final String ERROR_UNEQUAL_SIZE = "Unequally sized vectors.";

    public final int[] values;
    public int length;

    public Vector(int... values) {
        this.values = values;
        this.length = values.length;
    }

    public Vector plus(Vector another) throws Exception {
        if(this.length != another.length) {
            throw new Exception(ERROR_UNEQUAL_SIZE);
        }
        int[] added = IntStream.range(0, this.values.length).map(i -> this.values[i] + another.values[i]).toArray();
        return new Vector(added);
    }

    public Vector minus(Vector another) throws Exception {
        if(this.length != another.length) {
            throw new Exception(ERROR_UNEQUAL_SIZE);
        }
        int[] added = IntStream.range(0, this.values.length).map(i -> this.values[i] - another.values[i]).toArray();
        return new Vector(added);
    }

    public Vector times(Vector another) throws Exception {
        if(this.length != another.length) {
            throw new Exception(ERROR_UNEQUAL_SIZE);
        }
        int[] added = IntStream.range(0, this.values.length).map(i -> this.values[i] * another.values[i]).toArray();
        return new Vector(added);
    }

    public Vector which(IntPredicate predicate) {
        IntStream range = IntStream.range(0, this.values.length);
        int [] valueArray = range.filter(i -> predicate.test(this.values[i])).toArray();
        return new Vector(valueArray);
    }

    public Vector at(int... positions) {
        // TODO Handle negative values for the entries of "positions". Either allow x.at(-1) to represent last element or not.
        int [] valueArray = Arrays.stream(positions).map(i -> this.values[i]).toArray();
        return new Vector(valueArray);
    }

    public Vector at(Vector vector) {
        return at(vector.values);
    }

    public void print() {
        Arrays.stream(values).forEach(x -> System.out.print(x + ", "));
    }

    public static int dot(Vector x1, Vector x2) throws Exception {
        if(x1.length != x2.length) {
            throw new Exception(ERROR_UNEQUAL_SIZE);
        }
        return Arrays.stream(x1.times(x2).values).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector that = (Vector) o;
        return Arrays.equals(values, that.values);
    }

}
