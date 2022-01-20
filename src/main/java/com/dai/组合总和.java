package com.dai;

import java.util.*;

public class 组合总和 {
    List<List<Integer>> list = new ArrayList<>();
    Deque<Integer> tmp = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        sum(candidates, 0, target);
        return list;
    }

    private void sum(int[] candidates, int k, int target) {
        if (target == 0) {
            list.add(new LinkedList<>(tmp));
            return;
        }
        if (target < 0) return;
        for (int i = k; i < candidates.length; i++) {
            tmp.offer(candidates[i]);
            sum(candidates, i, target - candidates[i]);
            tmp.removeLast();
            if (target - candidates[i] <= 0)break;

        }

    }
}
