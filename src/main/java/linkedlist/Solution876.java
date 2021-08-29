package linkedlist;

import common.ListNode;

/**
 * @author luli
 * @date 2021/8/29
 */
public class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            if (fast.next == null) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
