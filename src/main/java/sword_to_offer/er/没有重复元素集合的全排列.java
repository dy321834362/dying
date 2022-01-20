package sword_to_offer.er;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 没有重复元素集合的全排列 {
    List<List<Integer>> list = new ArrayList<>();
    Deque<Integer> tmp = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0);
        return list;
    }

    private void permute(int[] nums, int k) {
        if (k == nums.length) {
            list.add(new LinkedList<>(tmp));
            return;
        }
        for (int i = k; i < nums.length; i++) {
            swap(nums, i, k);
            tmp.offerLast(nums[k]);
            permute(nums, k+1);
            tmp.removeLast();
            swap(nums, i, k);
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> permute = new 没有重复元素集合的全排列().permute(arr);
        System.out.println(permute);
    }

    private void swap(int[] nums, int i, int k) {
        int t = nums[i];
        nums[i] = nums[k];
        nums[k] = t;
    }
}
