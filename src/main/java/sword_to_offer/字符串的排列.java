package sword_to_offer;

import java.util.*;
import java.util.stream.Collectors;

public class 字符串的排列 {
    Set<String> set = new HashSet<>();
    Deque<Character> list = new LinkedList<>();
    public String[] permutation(String s) {
        char[] ch = s.toCharArray();
        permutation(ch, 0, s.length()-1);
        String[] ss = set.toArray(new String[0]);
        return  ss;
    }

    private void permutation(char[] ch, int start, int end) {
        if (start == end) {
            list.add(ch[start]);
            set.add(listToString(list));
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(ch, start, i);
            list.add(ch[start]);
            permutation(ch, start+1, end);
            swap(ch, start, i);
            remove(list, start);
        }
    }

    private void remove(Deque<Character> list, int start) {
        while (list.size() > start) {
            list.removeLast();
        }
    }

    private String listToString(Deque<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (Character ch : list) {
            sb.append(ch);
        }
        return sb.toString();
    }

    private void swap(char[] ch, int start, int i) {
        char c = ch[start];
        ch[start] = ch[i];
        ch[i] = c;
    }

    public static void main(String[] args) {
        String[] s = new 字符串的排列().permutation("abcd");
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
