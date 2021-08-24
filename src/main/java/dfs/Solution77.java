package dfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author luli
 * @date 2021/8/24
 */
public class Solution77 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(new LinkedList<>(), n, k, 1);
        return res;
    }

    public void dfs(Deque<Integer> queue, int n, int k, int i) {
        if (queue.size() == k) {
            res.add(new ArrayList<>(queue));
            return;
        }
        for (int j = i; j <= n - (k - queue.size())+1; j++) {
            queue.offer(j);
            dfs(queue, n, k, j+1);
            queue.removeLast();
        }
    }
}
