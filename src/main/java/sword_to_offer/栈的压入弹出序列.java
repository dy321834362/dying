package sword_to_offer;

import java.util.Stack;

public class 栈的压入弹出序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        if (pushed.length == 1)return true;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        stack.push(pushed[i++]);
        while (i < pushed.length) {
            if (stack.peek() != popped[j]) {
                stack.push(pushed[i++]);
            } else {
                stack.pop();
                j++;
            }
            if (stack.isEmpty()) {
                stack.push(pushed[i++]);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() != popped[j]) {
                return false;
            }
            stack.pop();
            j++;
        }
        return true;
    }
}
