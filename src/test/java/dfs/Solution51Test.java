package dfs;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author luli
 * @date 2021/8/23
 */
class Solution51Test {
    Solution51 solution51 = new Solution51();

    @Test
    public void test1() {
        List<List<String>> res = solution51.solveNQueens(4);
        for (List<String> list : res) {
            System.out.println(list);
        }
    }
}