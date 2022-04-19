package Daily_qustion;

import java.util.Arrays;
import java.util.Random;

public class 找出缺失的观测数据 {
    public static void main(String[] args) {
        int[] rolls  = new int[] {6,1,5,2};
        int[] result = missingRolls(rolls, 4, 4);
        Arrays.stream(result).forEach(System.out::println);
    }
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int total = (n + rolls.length) * mean;
        for (int roll : rolls) {
            total -= roll;
        }
        if (total > n * 6 || total < n) return new int[0];
        int[] result = new int[n];
        Random r = new Random();
        int i = 0;
        while (i < result.length) {
            int tmp = total/n;
            result[i++] = tmp;
            total = total - tmp;
            n--;
        }
        return result;
    }
}
