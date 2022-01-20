package sword_to_offer.er;

import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 允许重复选择元素的组合 {
    private List<List<Integer>> list = new ArrayList<>();
    Deque<Integer> tmp = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum(candidates, target, 0);
        return list;
    }

    private void combinationSum(int[] candidates, int target, int i) {
        if (target == 0) {
            list.add(new LinkedList<>(tmp));
            return;
        }
        if (target < 0) return;
        for (int j = i; j < candidates.length; j++) {
            tmp.offerLast(candidates[j]);
            combinationSum(candidates, target - candidates[j], j);
            tmp.removeLast();
        }
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
