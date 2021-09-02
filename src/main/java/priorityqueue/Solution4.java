package priorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author luli
 * @date 2021/9/2
 */
public class Solution4 {
    PriorityQueue<Integer> largest = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    PriorityQueue<Integer> small = new PriorityQueue<>((Comparator.comparingInt(o -> o)));

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        addQueue(nums1);
        addQueue(nums2);
        if (small.size() == largest.size()) {
            return (small.poll() + largest.poll()) / 2.0;
        } else {
            return small.isEmpty() ? largest.poll() : small.poll();
        }
    }

    private void addQueue(int[] nums) {
        for (int n : nums) {
            if (largest.isEmpty()) {
                largest.add(n);
                continue;
            }
            if (n > largest.peek()) {
                small.add(n);
                if (small.size() - 1 > largest.size()) {
                    largest.add(small.poll());
                }
            } else {
                largest.add(n);
                if (largest.size() > small.size()) {
                    small.add(largest.poll());
                }
            }
        }
    }
}
