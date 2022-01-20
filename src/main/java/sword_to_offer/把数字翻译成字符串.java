package sword_to_offer;

public class 把数字翻译成字符串 {
    public static int translateNum(int num) {
        String s = String.valueOf(num);
        char[] ch = s.toCharArray();
        int[] arr = new int[ch.length];
        for (int i = 0; i < ch.length; i++) {
            arr[i] = ch[i] - '0';
        }
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int tmp = i == 1 ? 1 : dp[i - 2];
            if ((arr[i-1] == 2 && arr[i] > 5) || arr[i-1] > 2 || arr[i-1] <= 0) {
                dp[i] = dp[i-1];
            } else {
                dp[i] = dp[i-1] + tmp;
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        System.out.println(translateNum(25));
    }
}
