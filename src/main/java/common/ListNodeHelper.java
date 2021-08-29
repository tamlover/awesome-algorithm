package common;

/**
 * @author luli
 * @date 2021/8/29
 */
public class ListNodeHelper {
    public static ListNode build(int[] arr){
        if (arr.length == 0) {
            return null;
        }
        ListNode node  = new ListNode();
        ListNode q = node;
        for (int val : arr) {
            q.next = new ListNode(val);
            q = q.next;
        }
        return node.next;
    }
}
