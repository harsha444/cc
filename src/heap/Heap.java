package heap;

public class Heap {
    public static int getLeftIndex(int[] arr, int i) {
        return 2 * i;
    }

    public static int getRightIndex(int[] arr, int i) {
        return 2 * i + 1;
    }

    public static void maxHeapify(int[] arr, int i) {
        int l = getLeftIndex(arr, i);
        int r = getRightIndex(arr, i);
        int largest = i;
        if (l < arr.length && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < arr.length && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            maxHeapify(arr, largest);
        }
    }

    public static void buildHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            maxHeapify(arr, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {};

    }
}
