package topquestions.easy.dp;

public class BestTimeToBuyAndSell {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        if (len == 2) {
            if (prices[1] > prices[0]) {
                return prices[1] - prices[0];
            } else {
                return 0;
            }
        }
        int[] minPrices = new int[len];
        int[] maxPrices = new int[len];
        minPrices[0] = prices[0];
        for (int i = 1; i < len; i++) {
            minPrices[i] = Math.min(prices[i], minPrices[i - 1]);
        }
        maxPrices[len - 1] = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            maxPrices[i] = Math.max(prices[i], prices[i + 1]);
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, maxPrices[i] - minPrices[i]);
        }
        return res;
    }

    private int maxProfitOnePass(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                max = Math.max(max, price - min);
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
