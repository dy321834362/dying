package Daily_qustion;

import com.sun.source.tree.NewArrayTree;

import java.util.logging.Handler;

public class 反转链表 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode cur = newHead;
        ListNode leftBefore = newHead;
        ListNode rightn = newHead;
        int count = 1;
        while (cur != null) {
            if (count == left) {
                leftBefore = cur;
            }
            if (count == right+1) {
                rightn = cur;
            }
            count++;
            cur = cur.next;
        }
        reverse(leftBefore, rightn);
        head = newHead.next;
        newHead.next = null;
        return head;

    }

    private void reverse(ListNode leftBefore, ListNode rightn) {
        ListNode left = leftBefore.next;
        leftBefore.next = rightn;
        ListNode rightNext = null;
        if (rightn != null)  rightNext = rightn.next;
        ListNode pre = rightNext;
        ListNode cur = left;
        while (cur != rightNext) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(5);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);
        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
        ListNode listNode = new 反转链表().reverseBetween(l1, 1, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
