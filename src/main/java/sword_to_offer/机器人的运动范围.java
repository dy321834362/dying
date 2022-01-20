package sword_to_offer;

public class 机器人的运动范围 {
    public static void main(String[] args) {
        int extracted = movingCount(26, 16, 4);
        System.out.println(extracted);
    }
    public static int movingCount(int m, int n, int k) {
        int[][] arr = new int[m][n];
        arr[0][0] = 1;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (in(i, j, k, arr))count++;
            }
        }
        return count;
    }

    private static boolean in(int i, int j, int k, int[][] arr) {
        if (i == 0 && j == 0) return true;
        if (((i>=1 && arr[i-1][j] == 1) || (j>=1 && arr[i][j-1] == 1)) && extracted(i) + extracted(j) <= k) {
            arr[i][j] = 1;
            return true;
        }
        return false;
    }

    private static int extracted(int m) {
        int tmp = 0;
        while (m/10 !=0 || m%10 != 0) {
            tmp += m%10;
            m = m /10;
        }
        return tmp;
    }
}
