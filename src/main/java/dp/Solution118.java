package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author luli
 * @date 2021/9/7
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> pre = Collections.singletonList(1);
        res.add(pre);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> ans = new ArrayList<>(i);
            ans.add(1);
            for (int j = 1; j < i - 1; j++) {
                ans.add(pre.get(j - 1) + pre.get(j));
            }
            ans.add(1);
            res.add(ans);
            pre = ans;
        }
        return res;
    }
}
