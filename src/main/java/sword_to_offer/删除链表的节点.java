package sword_to_offer;

public class 删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;
        if (head.val == val)return head.next;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur.next = null;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
