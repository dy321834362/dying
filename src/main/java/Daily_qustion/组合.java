package Daily_qustion;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 组合 {
    //回溯法
    List<List<Integer>> list = new ArrayList<>();
    Deque<Integer> tmp = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        combine(n, k, 0, 1);
        return list;
    }

    private void combine(int n, int k, int x, int m) {
        if (n-m+1+x < k) return;
        if (x == k) {
            list.add(new LinkedList<>(tmp));
            return;
        }
        for (int i = m; i <= n; i++) {
            if (tmp.contains(i)) continue;
            tmp.offerLast(i);
            combine(n, k, x+1, i+1);
            tmp.removeLast();
        }
    }

}
