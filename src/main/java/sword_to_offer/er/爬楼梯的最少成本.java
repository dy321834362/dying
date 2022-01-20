package sword_to_offer.er;

public class 爬楼梯的最少成本 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0)return 0;
        if (cost.length == 1) return cost[0];
        int[] greedy = new int[cost.length];
        for (int i = 2; i < cost.length; i++) {
            greedy[i] = Math.min(greedy[i-1]+cost[i-1], greedy[i-2]+cost[i-2]);
        }
        return Math.min(greedy[greedy.length-1]+cost[greedy.length-1], greedy[greedy.length-2]+cost[greedy.length-2]);
    }

    //方法二
    public int minCostClimbingStairs2(int[] cost) {
        if (cost == null || cost.length == 0)return 0;
        if (cost.length == 1) return cost[0];
        int[] greedy = new int[cost.length];
        for (int i = 2; i < cost.length; i++) {
            greedy[i] = Math.min(greedy[i-1]+cost[i-1], greedy[i-2]+cost[i-2]);
        }
        return Math.min(greedy[greedy.length-1]+cost[greedy.length-1], greedy[greedy.length-2]+cost[greedy.length-2]);
    }
}
