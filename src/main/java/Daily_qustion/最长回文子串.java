package Daily_qustion;

public class 最长回文子串 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] ch = s.toCharArray();
        String str = s.charAt(0)+"";
        boolean[][] dp = new boolean[ch.length][ch.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
            if (i+1 < dp.length && ch[i] == ch[i+1]) {
                dp[i][i+1] = true;
                str = s.substring(i,i+2);
            }
        }
        for (int i = ch.length-2; i >= 0; i--) {
            for (int j = i+2; j < ch.length; j++) {
                if (dp[i+1][j-1] && ch[i] == ch[j]){
                    dp[i][j] = true;
                    if (j-i+1 > str.length()) {
                        str = s.substring(i,j+1);
                    }
                }
            }
        }
        return str;

    }
}
