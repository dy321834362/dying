package sword_to_offer;

public class 斐波那契数列 {
    public static void main(String[] args) {
        int fib = fib(6);
        System.out.println(fib);
    }
//    public static int fib(int n) {
//        if (n == 1 || n == 0)return n;
//        return fib(n-1) + fib(n-2);
//    }
    public static int fib(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 1 || i == 0) {
                arr[i] = i;
            } else {
                arr[i] = (arr[i-1] + arr[i-2]) % 1000000007;
            }
        }
        return (arr[n-1] + arr[n-2]) % 1000000007;
    }
}
