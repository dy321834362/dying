package sword_to_offer;

public class 链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k < 0)return null;
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        cur = head;
        int m = count + 1 - k;
        while(true) {
            if (m == 1)return cur;
            m--;
            cur = cur.next;
        }
    }
}
