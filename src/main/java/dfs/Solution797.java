package dfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author luli
 * @date 2021/8/25
 */
public class Solution797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Deque<Integer> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(0);
        dfs(0, graph, queue, res);
        return res;
    }

    private void dfs(int index, int[][] graph, Deque<Integer> queue, List<List<Integer>> res) {
        if (index == graph.length - 1) {
            res.add(new ArrayList<>(queue));
            return;
        }
        int[] next = graph[index];
        for (int n : next) {
            queue.offer(n);
            dfs(n, graph, queue, res);
            queue.removeLast();
        }
    }
}
