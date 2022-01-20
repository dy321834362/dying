package Daily_qustion;

import java.util.TreeMap;

public class 滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)return new int[0];
        int[] dp = new int[nums.length+1-k];
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            if (!tm.containsKey(nums[i])) {
                tm.put(nums[i],1);
                continue;
            }
            tm.put(nums[i], tm.get(nums[i])+1);
        }
        dp[0] = tm.lastKey();
        for (int i = 1; i < dp.length; i++) {
            if (tm.containsKey(nums[i+k-1])) {
                tm.put(nums[i+k-1], tm.get(nums[i+k-1])+1);
            }else {
                tm.put(nums[i+k-1], 1);
            }
            if (tm.containsKey(nums[i-1])) {
                if (tm.get(nums[i-1]) == 1) {
                    tm.remove(nums[i-1]);
                } else {
                    tm.put(nums[i-1], tm.get(nums[i-1])-1);
                }
            }
            dp[i] = tm.lastKey();
        }
        return dp;
    }
}
