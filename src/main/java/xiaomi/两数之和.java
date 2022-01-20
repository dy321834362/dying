package xiaomi;

import java.util.Arrays;

public class 两数之和 {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0)return new int[0];
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        while (start < end) {
            if (nums[start] + nums[end] > target) end--;
            if (nums[start] + nums[end] < target) start++;
            if (nums[start] + nums[end] == target) return new int[]{start, end};
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr = {3,2,4};
        int[] k = twoSum(arr, 6);
        Arrays.stream(k).forEach(System.out::println);
    }
}
