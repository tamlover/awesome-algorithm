package prefixsum;

/**
 * @author luli
 * @date 2021/8/31
 */
public class Solution1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] sum = new int[n];
        for (int[] book : bookings) {
            sum[book[0] - 1] += book[2];
            if (book[1] < n) {
                sum[book[1]] -= book[2];
            }
        }
        for (int i = 1; i < sum.length; i++) {
            sum[i] += sum[i - 1];
        }
        return sum;
    }
}
