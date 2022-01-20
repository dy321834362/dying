package sword_to_offer;

import java.util.Arrays;

public class 扑克牌中的顺子 {
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length < 1)return false;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
                continue;
            }
            if (i == 0 || nums[i-1] == 0) {
                continue;
            }
            if (nums[i] - nums[i-1] == 0) {
                return false;
            }
            while (nums[i] - nums[i-1] > 1) {
                if (count < 1)return false;
                nums[i-1] += 1;
                count--;
            }
        }
        return true;
    }
}
