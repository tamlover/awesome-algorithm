package linkedlist;

import common.ListNode;
import common.ListNodeHelper;
import org.junit.jupiter.api.Test;

/**
 * @author luli
 * @date 2021/8/29
 */
class Solution23Test {
    Solution23 solution23  = new Solution23();
    @Test
    public void test1(){
        int[][] array = new int[][]{{-2,-1,-1,-1},{}};
        ListNode[] param = new ListNode[2];
        for (int i = 0; i < array.length; i++) {
            param[i] = ListNodeHelper.build(array[i]);
        }
        ListNode res = solution23.mergeKLists(param);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}