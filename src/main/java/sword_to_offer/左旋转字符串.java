package sword_to_offer;

public class 左旋转字符串 {
    public static void main(String[] args) {

    }

    public String reverseLeftWords(String s, int n) {
        StringBuffer sb = new StringBuffer(s);
        String s1 = sb.substring(0, n);
        String s2 = sb.substring(n, sb.length());
        return s2+s1;
    }
}
