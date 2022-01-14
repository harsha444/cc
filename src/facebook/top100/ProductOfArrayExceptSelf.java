package facebook.top100;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] response = new int[nums.length];
        response[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            response[i] = response[i - 1] * nums[i - 1];
        }
        int r = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            response[i] = response[i] * r;
            r = r * nums[i];
        }
        return response;
    }

    public static void main(String[] args) {

    }
}
