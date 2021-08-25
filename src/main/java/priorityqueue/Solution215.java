package priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author luli
 * @date 2021/8/25
 */
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int n : nums) {
            queue.offer(n);
        }
        for (int i = 1; i < k; i++) {
            queue.remove();
        }
        return queue.poll();
    }
}
