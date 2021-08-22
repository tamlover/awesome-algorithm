package bfs;

import java.util.*;

/**
 * @author luli
 * @date 2021/8/22
 */
public class Solution675 {
    int m;
    int n;
    List<List<Integer>> forest;

    public int cutOffTree(List<List<Integer>> forest) {
        Map<Integer, Integer[]> map = new HashMap<>();
        List<Integer> treeList = new ArrayList<>();
        m = forest.size();
        n = forest.get(0).size();
        this.forest = forest;

        // 先标记位置并排序
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tall = forest.get(i).get(j);
                if (tall == 0) {
                    continue;
                }
                map.put(tall, new Integer[]{i, j});
                treeList.add(tall);
            }
        }
        Collections.sort(treeList);

        // 从0，0开始根据排序好的下标计算路径
        Integer[] curr = new Integer[]{0, 0};
        Integer[] next;
        int path = 0;
        for (Integer integer : treeList) {
            // 1是地面，没有树不需要计算路径
            if (integer == 1) {
                continue;
            }
            next = map.get(integer);
            int res = calPath(curr, next);
            if (res == -1) {
                return -1;
            }
            path += res;
            curr = next;
        }
        return path;
    }

    private int calPath(Integer[] curr, Integer[] next) {
        Deque<Integer[]> deque = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        deque.add(curr);
        visited.add(forest.get(curr[0]).get(curr[1]));
        int path = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Integer[] index = deque.poll();
                int x = index[0];
                int y = index[1];
                if (x == next[0] && y == next[1]) {
                    return path;
                }

                if (x - 1 >= 0) {
                    int up = forest.get(x - 1).get(y);
                    if (up > 0 && !visited.contains(up)) {
                        deque.add(new Integer[]{x - 1, y});
                        visited.add(up);
                    }
                }

                if (x + 1 < m) {
                    int down = forest.get(x + 1).get(y);
                    if (down > 0 && !visited.contains(down)) {
                        deque.add(new Integer[]{x + 1, y});
                        visited.add(down);
                    }
                }

                if (y - 1 >= 0) {
                    int left = forest.get(x).get(y - 1);
                    if (left > 0 && !visited.contains(left)) {
                        deque.add(new Integer[]{x, y - 1});
                        visited.add(left);
                    }
                }

                if (y + 1 < n) {
                    int right = forest.get(x).get(y + 1);
                    if (right > 0 && !visited.contains(right)) {
                        deque.add(new Integer[]{x, y + 1});
                        visited.add(right);
                    }
                }
            }
            path++;
        }
        return -1;
    }
}
