package sword_to_offer.er;

import java.util.*;

public class 含有重复元素集合的全排列 {
    List<List<Integer>> list = new ArrayList<>();
    Deque<Integer> tmp = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        permute(nums, 0);
        return list;
    }

    private void permute(int[] nums, int k) {
        if (k == nums.length) {
            list.add(new LinkedList<>(tmp));
            return;
        }
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = k; i < nums.length; i++) {
            if (hs.contains(nums[i]))continue;
            swap(nums, i, k);
            tmp.offerLast(nums[k]);
            hs.add(nums[k]);
            permute(nums, k+1);
            tmp.removeLast();
            swap(nums, i, k);
        }

    }

    private void swap(int[] nums, int i, int k) {
        int t = nums[i];
        nums[i] = nums[k];
        nums[k] = t;
    }

}
