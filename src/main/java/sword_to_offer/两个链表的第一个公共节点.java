package sword_to_offer;

import javax.management.MBeanAttributeInfo;
import java.util.List;
import java.util.zip.CheckedOutputStream;

public class 两个链表的第一个公共节点 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null)return headB;
        if (headB == null)return headA;
        int countA = 0;
        int countB = 0;
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while (tmpA != null) {
            countA++;
            tmpA = tmpA.next;
        }
        while (tmpB != null) {
            countB++;
            tmpB = tmpB.next;
        }
        tmpA = countA >= countB ? headA : headB;
        tmpB = countA >= countB ? headB : headA;
        countA = Math.abs(countA - countB);
        for (int i = 0; i < countA; i++) {
            tmpA = tmpA.next;
        }
        while (tmpA != tmpB || tmpA != null) {
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }
        return tmpA;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l6.next = l4;
        ListNode in = getIntersectionNode(l1, l6);
        System.out.println(in);
    }
}
