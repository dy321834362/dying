package Daily_qustion;

import java.util.*;

public class 全排列 {
    List<List<Integer>> list = new ArrayList<>();
    Deque<Integer> tmp = new LinkedList<>();
    HashSet<Integer> hm = new HashSet();
    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0);
        return list;
    }

    private void permute(int[] nums, int count) {
        if (count == nums.length) {
            list.add(new LinkedList<>(tmp));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!hm.contains(nums[j])) {
                hm.add(nums[j]);
                tmp.offerLast(nums[j]);
                permute(nums, count+1);
                tmp.removeLast();
                hm.remove(nums[j]);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new 全排列().permute(new int[]{1, 2, 3});

    }
}
