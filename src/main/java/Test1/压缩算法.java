package Test1;

import java.util.Stack;

public class 压缩算法 {

    public String compress (String str) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ']') {
                stack.push(str.charAt(i));
            } else {
                dealwith(stack);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    private void dealwith(Stack<Character> stack) {
        StringBuffer sb = new StringBuffer();
        Character c = stack.pop();
        while ((c-'A'>=0 && c-'Z'<=0) || (c-'a'>=0 && c-'z'<=0)) {
            sb.append(c);
            c = stack.pop();
        }
        sb.reverse();
        if (c == '|') {
            c = stack.pop();
        }
        int count = 0;
        int x = 0;
        while (Character.isDigit(c)) {
            count += (int) ((c-'0')*Math.pow(10, x++));
            c = stack.pop();
        }
        String s = sb.toString();
        for (int j = 0; j < count-1; j++) {
            sb = sb.append(s);
        }
        if (c == '[') {
            for (int i = 0; i < sb.length(); i++) {
                stack.push(sb.charAt(i));
            }
            return;
        }
    }
}
