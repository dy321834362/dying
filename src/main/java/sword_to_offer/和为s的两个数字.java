package sword_to_offer;

public class 和为s的两个数字 {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) return new int[0];
        int start = 0;
        int end = nums.length-1;
        while (start < end) {
            if (nums[start] + nums[end] < target) {
                start++;
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                break;
            }
        }
        if (start < end) return new int[]{nums[start], nums[end]};
        return new int[0];
    }
}
