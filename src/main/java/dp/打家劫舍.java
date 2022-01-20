package dp;

public class 打家劫舍 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)return -1;
        if(nums.length == 1)return nums[0];
        int prepre = nums[0];
        int pre = Math.max(nums[0], nums[1]);
        int cur = pre;
        for (int i = 2; i < nums.length; i++) {
            cur = Math.max(pre, prepre+nums[i]);
            prepre = pre;
            pre = cur;
        }
        return cur;
    }

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0)return -1;
        if(nums.length == 1)return nums[0];
        return Math.max(rob(nums, 1, nums.length-1), rob(nums, 2, nums.length-2)+nums[0]);
    }

    public int rob(int[] nums, int start, int end) {
        if (start >= nums.length || end < 0 || start > end)return -1;
        if (start == end) return nums[end];
        int prepre = nums[start];
        int pre = Math.max(nums[start], nums[start+1]);
        int cur = pre;
        for (int i = start+2; i <= end; i++) {
            cur = Math.max(pre, prepre+nums[i]);
            prepre = pre;
            pre = cur;
        }
        return cur;
    }
}
