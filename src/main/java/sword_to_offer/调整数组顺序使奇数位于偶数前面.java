package sword_to_offer;

import java.util.Arrays;

public class 调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        int[] exchange = exchange(arr);
        Arrays.stream(exchange).forEach(System.out::println);
    }
    public static int[] exchange(int[] nums) {
        if (nums == null) return new int[0];
        int end = nums.length - 1;
        for (int i = 0; i < end;) {
            if ((nums[i] & 1) == 0) {
                exchangeNum(nums ,i, end--);
            } else {
                i++;
            }
        }
        return nums;
    }

    private static void exchangeNum(int[] nums, int i, int end) {
        int tmp = nums[i];
        nums[i] = nums[end];
        nums[end] = tmp;
    }
}
