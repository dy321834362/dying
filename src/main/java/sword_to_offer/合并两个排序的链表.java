package sword_to_offer;

public class 合并两个排序的链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode s = l1.val >= l2.val ? l2 : l1;
        ListNode l = l1.val >= l2.val ? l1 : l2;
        ListNode pre = s;
        while (s != null && l != null) {
           if (s.val <= l.val) {
               pre = s;
               s = s.next;
           } else {
               pre.next = l;
               ListNode tmp = l.next;
               l.next = s;
               pre = l;
               l = tmp;
           }
        }
        if (l != null) {
            pre.next = l;
        }
        return l1.val >= l2.val ? l2 : l1;
    }
}
