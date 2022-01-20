package Daily_qustion;

public class MyCircularQueue {
//    实现一个循环队列，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。
//    应支持如下操作：
//            1、MyCircularQueue(k): 构造器，设置队列长度为 k 。
//            2、Front: 从队首获取元素。如果队列为空，返回 -1 。
//            3、Rear: 获取队尾元素。如果队列为空，返回 -1 。
//            4、enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
//            5、deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
//            6、isEmpty(): 检查循环队列是否为空。
//            7、isFull(): 检查循环队列是否已满。
    int[] arr;
    int head = 0;
    int tail = 0;
    int k = -1;
    MyCircularQueue(int k) {
        arr = new int[k];
    }

    int front(){
        if (tail >= 0)
            return arr[tail];
        return -1;
    }
    int rear(){
        if (head > 0) {
            return arr[head-1];
        }
        return -1;
    }
    boolean enQueue(int value) {
        if (head == arr.length -1) {
            arr[head] = value;
            head = 0;
            if (head == tail) {
                k = 1;
            }else {
                k = 0;
            }
            return true;
        }
        if (head < arr.length-1){
            arr[head++] = value;
            if (head == tail){
                k = 1;
            }else {
                k = 0 ;
            }
            return true;
        }
        return false;
    }
    boolean deQueue(int value) {
        if (tail < arr.length-1) {
            tail++;
            if (tail == head)k = -1;
            return true;
        }
        if (tail == arr.length-1) {
            tail = 0;
            if (tail == head)k = -1;
            return true;
        }
        return false;
    }

    boolean isEmpty() {
        return k == -1 ? true : false;
    }

    boolean isFull() {
        return k == 1 ? true : false;
    }

}
