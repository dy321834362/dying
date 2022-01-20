package sword_to_offer;

public class 数组中重复的数字 {
    public static void main(String[] args) {

    }

    public int findRepeatNumber(int[] nums) {
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (++tmp[nums[i]] > 1) {
                return nums[i];
            }
        }
        return -1;
    }
}
