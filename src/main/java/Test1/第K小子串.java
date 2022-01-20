package Test1;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 第K小子串 {
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < Math.min(str.length(), i+k); j++) {
                String sub = str.substring(i, j+1);
                if (pq.size() < k && !pq.contains(sub)) {
                    pq.offer(sub);
                } else if (pq.size() == k && !pq.contains(sub)) {
                    pq.offer(sub);
                    pq.poll();
                }
            }
        }
        System.out.println(pq.peek());
    }
}
