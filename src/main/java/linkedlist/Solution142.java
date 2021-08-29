package linkedlist;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author luli
 * @date 2021/8/29
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (visited.contains(p)) {
                return p;
            }
            visited.add(p);
            p = p.next;
        }
        return null;
    }
}
