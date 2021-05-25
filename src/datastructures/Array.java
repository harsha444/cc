package datastructures;

import java.util.Iterator;
import java.util.function.Consumer;

@SuppressWarnings ("unchecked")
public class Array<T> implements Iterable<T> {
    private T[] arr;

    private int len;

    private int capacity;

    public Array() {
        this(16);
    }

    public Array(int capacity) {
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        return arr[index];
    }

    public void set(int index, T value) {
        arr[index] = value;
    }

    public void add(T elem) {
        if (capacity == 0) {
            capacity = 1;
        }
        if (len + 1 > capacity) {
            capacity = 2 * capacity;
            T[] new_arr = (T[]) new Object[capacity];
            if (len >= 0) {
                System.arraycopy(arr, 0, new_arr, 0, len);
            }
            arr = new_arr;
        }
        arr[len++] = elem;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }
}
