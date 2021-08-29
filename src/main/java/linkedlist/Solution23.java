package linkedlist;

import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author luli
 * @date 2021/8/29
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node!=null) {
                priorityQueue.add(node);
            }
        }
        ListNode q = new ListNode();
        ListNode p = q;
        while (!priorityQueue.isEmpty()) {
            p.next = priorityQueue.poll();
            p = p.next;
            if (p.next != null) {
                priorityQueue.add(p.next);
            }
        }
        return q.next;
    }
}
