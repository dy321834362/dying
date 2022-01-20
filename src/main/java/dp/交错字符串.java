package dp;

public class 交错字符串 {
    public static void main(String[] args) {
        boolean interleave = new 交错字符串().isInterleave("aacaac", "aacaaeaac", "aacaaeaaeaacaac");
        System.out.println(interleave);
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        int t1 = 0,t2 = 0,t3 = 0;
        return isInterleave(s1, s2, s3, t1, t2, t3);
    }
    public boolean isInterleave(String s1, String s2, String s3, int t1, int t2, int t3) {
        while (t1 < s1.length() && t2 < s2.length() && t3 < s3.length()) {
            if (s1.charAt(t1) == s2.charAt(t2) && s1.charAt(t1) == s3.charAt(t3)) {
                return isInterleave(s1, s2, s3, t1+1, t2, t3+1) ||
                        isInterleave(s1, s2, s3, t1, t2+1, t3+1);
            } else {
                if (s1.charAt(t1) == s3.charAt(t3)) {
                    t1++;t3++;
                    continue;
                }
                if (s2.charAt(t2) == s3.charAt(t3)) {
                    t2++;t3++;
                    continue;
                }
                return false;
            }
        }
        while (t1 < s1.length()) {
            if (s1.charAt(t1++) != s3.charAt(t3++))return false;
        }
        while (t2 < s2.length()) {
            if (s2.charAt(t2++) != s3.charAt(t3++))return false;
        }
        return  true;
    }
}
