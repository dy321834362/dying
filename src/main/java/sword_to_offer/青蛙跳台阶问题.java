package sword_to_offer;

public class 青蛙跳台阶问题 {
    public int numWays(int n) {
        if (n <= 0)return 0;
        if (n == 1 || n == 2)return n;
        int[] arr = new int[n];
        for (int i = 1; i < n; i++) {
            if (i == 1 || i == 2) {
                arr[i] = i;
            } else {
                arr[i] = (arr[i-1] + arr[i-2]) % 1000000007;
            }
        }
        return (arr[n-1] + arr[n-2]) % 1000000007;
    }
}
