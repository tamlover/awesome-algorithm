package priorityqueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author luli
 * @date 2021/9/2
 */
class Solution4Test {
    Solution4 solution4 = new Solution4();
    @Test
    public void test1() {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        assertEquals(solution4.findMedianSortedArrays(nums1, nums2), 2);
    }

    @Test
    public void test2() {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        assertEquals(solution4.findMedianSortedArrays(nums1, nums2), 2.5);
    }
}