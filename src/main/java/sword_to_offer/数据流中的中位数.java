package sword_to_offer;

import java.util.PriorityQueue;
import java.util.Queue;

public class 数据流中的中位数 {
    Queue<Integer> lHeap = new PriorityQueue<>((x, y) -> y-x);
    Queue<Integer> sHeap = new PriorityQueue<>();
    public 数据流中的中位数() {

    }

    public void addNum(int num) {
        if (sHeap.size() == 0 || num >= sHeap.peek()) {
            sHeap.add(num);
        } else {
            lHeap.add(num);
        }
        if (sHeap.size() - lHeap.size() > 1) {
            lHeap.add(sHeap.poll());
        }
        if (lHeap.size() - sHeap.size() > 1) {
            sHeap.add(lHeap.poll());
        }
    }

    public double findMedian() {
        if (sHeap.size() == 0 && lHeap.size() == 0) return Double.parseDouble(null);
        if (sHeap.size() > lHeap.size()){
            return sHeap.peek();
        } else if (sHeap.size() < lHeap.size()){
            return lHeap.peek();
        } else {
            return (sHeap.peek() + lHeap.peek()) / 2.0;
        }

    }
}
