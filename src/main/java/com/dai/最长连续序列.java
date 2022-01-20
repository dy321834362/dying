package com.dai;

import java.util.HashSet;
import java.util.Set;

public class 最长连续序列 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]-1)) continue;
            int tmp = nums[i];
            int count = 0;
            while (set.contains(tmp)) {
                count++;
                tmp++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
