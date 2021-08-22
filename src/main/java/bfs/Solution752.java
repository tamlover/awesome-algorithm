package bfs;

import java.util.*;

/**
 * @author luli
 * @date 2021/8/22
 */
public class Solution752 {
    public int openLock(String[] deadends, String target) {
        // 遇到就停止的set，包括禁止的和已经访问的
        Set<String> stop = new HashSet<>(Arrays.asList(deadends));
        if (stop.contains(target) || stop.contains("0000")) {
            return -1;
        }
        Deque<String> deque = new LinkedList<>();
        deque.offer("0000");
        int res = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String str = deque.poll();
                if (str.equals(target)) {
                    return res;
                }
                for (int j = 0; j < 4; j++) {
                    String up = up(str, j);
                    String down = down(str, j);
                    if (!stop.contains(up)) {
                        stop.add(up);
                        deque.offer(up);
                    }
                    if (!stop.contains(down)) {
                        stop.add(down);
                        deque.offer(down);
                    }
                }
            }
            res++;
        }
        return -1;
    }

    /**
     * 向上拨
     *
     * @param str   当前字符串
     * @param index 拨动位置
     * @return 拨动结果
     */
    private String up(String str, int index) {
        char[] arr = str.toCharArray();
        char c = arr[index];
        if (c == '9') {
            arr[index] = '0';
        } else {
            arr[index] = (char) (c + 1);
        }
        return new String(arr);
    }

    /**
     * 向下拨
     *
     * @param str   当前字符串
     * @param index 拨动位置
     * @return 拨动结果
     */
    private String down(String str, int index) {
        char[] arr = str.toCharArray();
        char c = arr[index];
        if (c == '0') {
            arr[index] = '9';
        } else {
            arr[index] = (char) (c - 1);
        }
        return new String(arr);
    }
}
