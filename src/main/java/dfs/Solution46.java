package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author luli
 * @date 2021/8/23
 */
public class Solution46 {
    List<List<Integer>> res = new ArrayList<>();
    int len;

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> tmp = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        int depth = 0;
        len = nums.length;
        dfs(nums, tmp, used, depth);
        return res;
    }

    public void dfs(int[] nums, LinkedList<Integer> tmp,  boolean[] used, int depth) {
        if (depth == len) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        depth++;
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            int v = nums[i];
            tmp.addLast(v);
            dfs(nums, tmp, used, depth);
            used[i] = false;
            tmp.removeLast();
        }
    }
}
