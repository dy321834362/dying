package sword_to_offer;

import java.util.HashMap;

public class 复杂链表的复制 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> nextMap = new HashMap<>();
        Node cur = head;
        while(cur != null) {
            Node newNode = new Node(cur.val);
            nextMap.put(cur, newNode);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node newCur = nextMap.get(cur);
            newCur.next = nextMap.get(cur.next);
            newCur.random = nextMap.get(cur.random);
            cur = cur.next;
        }
        return nextMap.get(head);
    }
}
