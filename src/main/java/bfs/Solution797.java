package bfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author luli
 * @date 2021/8/25
 */
class Solution797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<List<Integer>> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        deque.add(list);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                List<Integer> poll = deque.poll();
                int num = poll.get(poll.size() - 1);
                if (num == graph.length - 1) {
                    res.add(poll);
                    continue;
                }
                int[] next = graph[num];
                for (int n : next) {
                    List<Integer> newList = new ArrayList<>(poll);
                    newList.add(n);
                    deque.offer(newList);
                }
            }
        }
        return res;
    }
}
