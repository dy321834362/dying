package sword_to_offer;

import java.util.Stack;

public class 用两个栈实现队列 {
    public Stack<Integer> stack1 = new Stack<Integer>();
    public Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {

    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() throws Exception {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while(!stack1.isEmpty()) {
            stack2.add(stack1.pop());
        }
        if (stack2.isEmpty()) {
            throw new Exception();
        }
        return stack2.pop();
    }
}
