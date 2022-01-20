package Daily_qustion;

import javax.imageio.metadata.IIOMetadataFormatImpl;

public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) return true;
        int cur = 0;
        int tail = 0;
        while(cur <= tail) {
            tail = Math.max(tail, cur+nums[cur++]);
            if (tail >= nums.length-1)return true;
        }
        return false;
    }

    //跳跃游戏2
    public int jump(int[] nums) {int[] dp = new int[nums.length];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j <= i+nums[i] && j < nums.length; j++) {
                dp[j] = Math.min(dp[j], dp[i]+1);
            }
        }
        return dp[dp.length-1];

    }
}
