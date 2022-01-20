package sword_to_offer;

import java.util.HashMap;

public class 最长不含重复字符的子字符串 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)return 0;
        char[] ch = s.toCharArray();
        int[] dp = new int[ch.length];
        HashMap<Character, Integer> hm = new HashMap<>();
        dp[0] = 1;
        hm.put(ch[0], 0);
        for (int i = 1; i < ch.length; i++) {
            if (!hm.containsKey(ch[i])) {
                hm.put(ch[i], i);
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = Math.min(i- hm.get(ch[i]), dp[i-1]+1);
                hm.put(ch[i], i);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int a = lengthOfLongestSubstring("abba");
        System.out.println(a);
    }
}
