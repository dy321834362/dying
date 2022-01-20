package dp;

public class 买卖股票的最佳时机 {
//    public int maxProfit(int[] prices) {
//
//    }

    public int maxProfit2(int[] prices) {
        int count = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                count += prices[i] - prices[i-1];
            }
        }
        return count;
    }

    public int maxProfit3(int[] prices) {
        int[][] dp = new int[prices.length][2];  //0 手里有股票  1 手里没有股票
        dp[0][0] = -prices[0];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][0] = Math.max(dp[i-1][1] - prices[i], dp[i-1][0]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]);
                max = Math.max(max, dp[i][1]);
            }
        }
        return max;
    }
}
