package sword_to_offer;

public class 股票的最大利润 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)return 0;
        int min = prices[0];
        int[] dp = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                dp[i] = Math.max(dp[i-1], prices[i] - min);
            } else {
                min = prices[i];
                dp[i] = dp[i-1];
            }
        }
        return dp[prices.length-1];
    }
}
