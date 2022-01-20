package sword_to_offer.er;

public class 排序数组中两个数字之和 {
    public int[] twoSum(int[] numbers, int target) {
        int head= 0;
        int tail = numbers.length-1;
        while (head < tail) {
            if (numbers[head] + numbers[tail] < target) {
                head++;
            } else if (numbers[head] + numbers[tail] > target) {
                tail--;
            } else {
                return new int[]{head, tail};
            }
        }
        return new int[]{-1, -1};
    }
}
