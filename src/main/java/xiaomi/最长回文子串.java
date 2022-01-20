package xiaomi;

import java.util.Locale;

public class 最长回文子串 {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        int left1 = 0;
        int right1 = 0;
        for (int i = 0; i < chars.length; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right <= chars.length-1 && chars[left] == chars[right]) {
                if (count < right-left+1) {
                    left1 = left;
                    right1 = right;
                }
                count = Math.max(count, right-left+1);
                left--;right++;
            }
        }
        return s.substring(left1+1,right1);

    }
}
