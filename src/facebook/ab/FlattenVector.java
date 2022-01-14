package facebook.ab;

import java.util.NoSuchElementException;

public class FlattenVector {
    class Vector2D {
        int[][] vector;

        int inner = 0;

        int outer = 0;

        public Vector2D(int[][] vec) {
            vector = vec;
        }

        public int next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return vector[outer][inner++];
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
    }
}
