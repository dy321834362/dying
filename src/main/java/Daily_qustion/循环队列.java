package Daily_qustion;

public class 循环队列 {
    private int[] arr;
    private int count;
    private int tail;
    private int head;
    public 循环队列(int k) {
        arr = new int[k];
    }

    public boolean enQueue(int value) {
        if (count < arr.length) {
            arr[tail] = value;
            tail = (tail+1)%arr.length;
            count++;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if (count > 0) {
            head = (head+1)%arr.length;
            count--;
            return true;
        }
        return false;
    }

    public int Front() {
        if (count > 0) {
            return arr[head%arr.length];
        }
        return -1;
    }

    public int Rear() {
        if (count > 0) {
            return arr[(tail+arr.length-1)%arr.length];
        }
        return  -1;
    }

    public boolean isEmpty() {
        return count==0;
    }

    public boolean isFull() {
        return count==arr.length;
    }
}
