package Test1;

import java.util.Scanner;

public class 逆序对 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        String[] s = str.split(" ");
        int m = Integer.parseInt(sc.nextLine());
        int q = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            //1.翻转
            for (int j = 0; j < s.length; j = j + (int)Math.pow(2,q)) {
                int start = 0;
                int end = j + (int)Math.pow(2,q)-1;
                while (start < end) {
                    swap(start++,end--,s);
                }
            }
//            reversePairs(s);
        }

    }

//    public int reversePairs(int[] nums) {
//
//    }


    private static void swap(int start, int end, String[] s) {
        String tmp = s[start];
        s[start] = s[end];
        s[end] = tmp;
    }
}
