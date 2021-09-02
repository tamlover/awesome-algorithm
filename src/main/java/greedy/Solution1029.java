package greedy;

import java.util.*;

/**
 * @author luli
 * @date 2021/9/2
 */
public class Solution1029 {
    public int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        int[] con = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            sum += costs[i][0];
            con[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(con);
        for (int i = 0; i < con.length / 2; i++) {
            sum += con[i];
        }
        return sum;
    }
}
