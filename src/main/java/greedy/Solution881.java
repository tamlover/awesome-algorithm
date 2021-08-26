package greedy;

import java.util.Arrays;

/**
 * @author luli
 * @date 2021/8/26
 */
public class Solution881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int ans = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            ans++;
        }
        return ans;
    }
}
