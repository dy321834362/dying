package sword_to_offer;

public class 包含min的栈 {
    int[] array = new int[10];
    int[] tmp = new int[10];
    int i = 0;

    public void push(int x) {
        array[i] = x;
        tmp[i] = i > 0 ? Math.min(tmp[i-1], x) : x;
        i++;
    }

    public void pop() {
        i--;
    }

    public int top() {
        if (i == 0) {
            return -1;
        }
        return array[i-1];
    }

    public int min() {
        if (i > 0) {
            return tmp[i-1];
        }
        return -1;
    }

}
