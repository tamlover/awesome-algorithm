package bfs;

import java.util.*;

/**
 * @author luli
 * @date 2021/8/24
 */
public class Solution787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] path = new List[n];
        for (int[] flight : flights) {
            if (path[flight[0]] == null){
                path[flight[0]] = new ArrayList<>();
            }
            path[flight[0]].add(flight);
        }
        int[] prices = new int[n];
        prices[src] = 0;
        Arrays.fill(prices, Integer.MAX_VALUE);
        //[0] src [1] depth [2] price
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                if (node[1] > k || node[0] == dst) {
                    continue;
                }
                List<int[]> nextList = path[node[0]];
                if (nextList == null) {
                    continue;
                }
                for (int[] next : nextList) {
                    if (prices[next[1]] > node[2] + next[2]){
                        prices[next[1]] = node[2] + next[2];
                        queue.add(new int[]{next[1], node[1]+1, node[2] + next[2]});
                    }
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
