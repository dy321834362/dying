package dp;

public class 最佳买卖股票时机含冷冻期 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)return 0;
        int[][] dp = new int[prices.length][2];  //0 手里有股票  1 手里没有股票
        dp[0][0] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], -prices[1]);
        dp[1][1] = prices[1] > prices[0] ? prices[1]-prices[0] : 0;
        int max = dp[1][1];
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][0] = Math.max(dp[i-2][1] - prices[i], dp[i-1][0]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]);
                max = Math.max(max, dp[i][1]);
            }
        }
        return max;
    }
}
