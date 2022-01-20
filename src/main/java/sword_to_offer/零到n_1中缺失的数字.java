package sword_to_offer;

public class 零到n_1中缺失的数字 {
    public static void main(String[] args) {

    }
    public int missingNumber(int[] nums) {
        if (nums[0] != 0) {
            return 0;
        }
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] > 1) {
                return nums[i]-1;
            }
        }
        return -1;
    }
}
