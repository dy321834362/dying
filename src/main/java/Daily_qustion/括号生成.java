package Daily_qustion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class 括号生成 {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) return new ArrayList<>();
        if (n == 1) {
            List<String> list = new ArrayList<String>();
            list.add("()");
            return list;
        }
        Set<String> tmp = new HashSet<>();
        List<String> tmplist = generateParenthesis(n-1);
        for(String s : tmplist) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i <= s.length(); i++) {
                sb.insert(i,'(');
                for (int j = i+1; j <= s.length()+1 ; j++) {
                    sb.insert(j,')');
                    tmp.add(sb.toString());
                    sb.deleteCharAt(j);
                }
                sb.deleteCharAt(i);
            }
        }
        return new ArrayList<>(tmp);
    }

    private void insert(int i, char c, StringBuilder sb) {
        sb.insert(i,c);
    }

    public static void main(String[] args) {
        List<String> list = new 括号生成().generateParenthesis2(3);
        list.stream().forEach(System.out::println);
    }

    List<String>[] al = new ArrayList[100];
    public List<String> generateParenthesis2(int n) {
        if (al[n] != null) {
            return al[n];
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                list.add("");
            }
            for (int j = 0; j < i; j++) {
                for(String a : al[j]) {
                    for(String b : al[i-j-1]) {
                        list.add("(" + a + ")" + b);
                    }
                }
            }
            al[i] = new ArrayList<>(list);
            list.clear();
        }
        return al[n];
    }
}
