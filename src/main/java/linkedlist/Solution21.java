package linkedlist;

import common.ListNode;

/**
 * @author luli
 * @date 2021/8/29
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = new ListNode();
        ListNode q = p;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                q.next = l1;
                l1 = l1.next;
            }else {
                q.next = l2;
                l2 = l2.next;
            }
            q = q.next;
        }
        while (l1 != null) {
            q.next = l1;
            l1 = l1.next;
            q = q.next;
        }

        while (l2 != null) {
            q.next = l2;
            l2 = l2.next;
            q = q.next;
        }
        return p.next;
    }
}
