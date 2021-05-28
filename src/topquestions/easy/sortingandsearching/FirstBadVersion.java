package topquestions.easy.sortingandsearching;

public class FirstBadVersion {
    private static boolean isBadVersion(int version) {
        return version >= 3;
    }

    private static int binarySearch(int[] a, int n, int l, int h) {
        int mid = (l + h) / 2;
        if (a[mid] == n) {
            return mid;
        }
        if (a[mid] > n) {
            return binarySearch(a, n, l, mid - 1);
        } else {
            return binarySearch(a, n, mid + 1, h);
        }
    }

    public static int firstBadVersion(int n) {
        int l = 1;
        int h = n;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (isBadVersion(mid)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 3, 4, 5, 6 };
        System.out.println(binarySearch(a, 6, 0, 5));
        System.out.println(firstBadVersion(5));
    }
}
