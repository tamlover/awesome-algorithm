package greedy;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author luli
 * @date 2021/9/2
 */
public class Solution1029 {
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int i = 0; i < costs.length; i++) {
            priorityQueue.add(new int[]{i, costs[i][1] - costs[i][0]});
        }
        Set<Integer> visited = new HashSet<>();
        int k = costs.length / 2;
        while (k-- > 0) {
            visited.add(priorityQueue.poll()[0]);
        }

        int sum = 0;
        for (int i = 0; i < costs.length; i++) {
            if (visited.contains(i)) {
                sum += costs[i][1];
            } else {
                sum += costs[i][0];
            }
        }
        return sum;
    }
}
