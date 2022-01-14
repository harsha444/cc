package facebook.ab.two;

import java.util.NoSuchElementException;

public class Vector2D {
    private int[][] vector;

    private int inner = 0;

    private int outer = 0;

    public Vector2D(int[][] vec) {
        this.vector = vec;
        this.inner = 0;
        this.outer = 0;
    }

    private void advanceToNext() {
        while (outer < vector.length && inner == vector[outer].length) {
            outer++;
            inner = 0;
        }
    }

    public boolean hasNext() {
        advanceToNext();
        return outer < vector.length;
    }

    public int next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return vector[outer][inner++];
    }
}
