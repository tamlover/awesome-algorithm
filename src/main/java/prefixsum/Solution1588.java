package prefixsum;

/**
 * @author luli
 * @date 2021/8/29
 */
public class Solution1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] prefixArr = new int[arr.length+1];
        int curr = 0;
        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];
            prefixArr[i+1] = curr;
        }

        int res = curr;
        int i = 1;
        while (i + 2 <= arr.length) {
            i = i + 2;
            for (int j = 0; j <= arr.length - 2; j++) {
                res += prefixArr[j + i] - prefixArr[j];
            }
        }
        return res;
    }
}
