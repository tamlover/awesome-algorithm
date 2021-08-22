package bfs;

import common.TreeHelper;
import common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author luli
 * @date 2021/8/22
 */
class Solution101Test {
    Solution101 solution101 = new Solution101();

    @Test
    public void test1() {
        Integer[] array = new Integer[]{1,2,2,3,null,-1,3};
        TreeNode root = TreeHelper.constructTree(array);
        assertFalse(solution101.isSymmetric(root));
    }
}