package prefixsum;

/**
 * @author luli
 * @date 2021/8/28
 */
public class Solution1480 {
    public int[] runningSum(int[] nums) {
        int curr = 0;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = curr + nums[i];
            curr += nums[i];
        }
        return res;
    }
}
