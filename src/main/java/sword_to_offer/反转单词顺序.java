package sword_to_offer;

public class 反转单词顺序 {
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s) +"aaa");
    }
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        s = s.trim();
        int end = s.length()-1;
        int cur = end;
        String result = "";
        while (cur > 0) {
            while (cur > 0 && s.charAt(cur) != ' ') cur--;
            result = result + " " + s.substring(cur+1, end+1);
            while (cur > 0 && s.charAt(cur) == ' ') cur--;
            end = cur;
        }
        return result.substring(1);
    }
}
