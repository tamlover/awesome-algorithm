package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luli
 * @date 2021/8/24
 */
public class Solution787 {
    Map<Integer, List<int[]>> pathMap;
    int[][] memory;
    int INF= 100*10000+7;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        pathMap = new HashMap<>();
        memory = new int[n][k+2];
        for (int[] path : flights) {
            List<int[]> list = pathMap.getOrDefault(path[0], new ArrayList<>());
            list.add(path);
            pathMap.put(path[0], list);
        }
        int res = dfs(src, dst, k+1);
        return res == INF ? -1 : res;
    }

    private int dfs(int from, int dst, int k) {
        if (k < 0) {
            return INF;
        }
        if (from == dst) {
            return 0;
        }
        if (memory[from][k] > 0) {
            return memory[from][k];
        }
        int min = INF;
        List<int[]> paths = pathMap.get(from);
        if (paths != null) {
            for (int[] p : paths) {
                min = Math.min(min, dfs(p[1], dst, k - 1) + p[2]);
            }
        }
        memory[from][k] = min;
        return min;
    }
}
