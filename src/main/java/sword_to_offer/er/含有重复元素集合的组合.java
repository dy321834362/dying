package sword_to_offer.er;

import java.util.*;

public class 含有重复元素集合的组合 {
    private List<List<Integer>> list = new ArrayList<>();
    Deque<Integer> tmp = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] b = new boolean[candidates.length];
        combinationSum(candidates, target, 0, b);
        return list;
    }

    private void combinationSum(int[] candidates, int target, int i, boolean[] b) {
        if (target == 0) {
            list.add(new LinkedList<>(tmp));
            return;
        }
        if (target < 0) return;
        for (int j = i; j < candidates.length; j++) {
            if (j-1 >= 0 && candidates[j] == candidates[j-1] && !b[j-1])continue;
            tmp.offerLast(candidates[j]);
            b[j] = true;
            combinationSum(candidates, target - candidates[j], j+1, b);
            tmp.removeLast();
            b[j] = false;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        new 含有重复元素集合的组合().combinationSum(arr, 8);
    }

//第二种方法

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        combinationSum2(candidates, target, 0);
        return list;
    }
    private void combinationSum2(int[] candidates, int target, int i) {
        if (target == 0) {
            list.add(new LinkedList<>(tmp));
            return;
        }
        if (target < 0) return;
        if (i >= candidates.length)return;
        tmp.offerLast(candidates[i]);
        combinationSum2(candidates, target - candidates[i], i);
        tmp.removeLast();
        combinationSum2(candidates, target, i+1);
    }
}
