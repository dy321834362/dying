package Test1;

import java.util.*;

public class 并查集 {
    static int[] parent = new int[100001];
    static int[] rank = new int[100001];
    static HashMap<Integer, Integer> hm = new HashMap<>();
    static void init() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    static int find(int i) {
        int tmp = parent[i];
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
     static void union(int x, int y, int[] rank) {
        int x_root = find(x);
        int y_root = find(y);
        if (x_root == y_root)return;
        if (rank[x_root] > rank[y_root]) {
            parent[y_root] = x_root;
        }else if (rank[x_root] < rank[y_root]) {
            parent[x_root] = y_root;
        } else {
            rank[y_root]++;
            parent[x_root] = y_root;
        }

    }

    static void clear() {
        init();
        hm.clear();
    }



    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        init();
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(sc.nextLine());
            for (int j = 0; j < n; j++) {
                String str = sc.nextLine();
                String[] s = str.split(" ");
                union(Integer.parseInt(s[0]), Integer.parseInt(s[1]),rank);
            }
            for (int j = 0; j < parent.length; j++) {
                int j_root = find(j);
                if (!hm.containsKey(j_root)) {
                    hm.put(j_root, 1);
                }else {
                    hm.put(j_root, hm.get(j_root)+1);
                }
            }
            int max = 0;
            for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                max = Math.max(max, entry.getValue());
            }
            list.add(max);
            clear();
        }
        list.stream().forEach(System.out::println);
    }
}
