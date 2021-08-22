package bfs;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author luli
 * @date 2021/8/22
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        // 这里将root添加俩次是为了适配后面的获取俩个节点比较
        deque.offer(root);
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode first = deque.poll();
            TreeNode second = deque.poll();
            if ((first == null && second == null)) {
                continue;
            }
            if (first == null || second == null || first.val != second.val) {
                return false;
            }
            deque.offer(first.left);
            deque.offer(second.right);
            deque.offer(first.right);
            deque.offer(second.left);
        }
        return true;
    }

    List<Integer> checkList = new ArrayList<>();

    /**
     * 初始版本，效果差，待优化
     *
     * @param root
     * @return
     */
    public boolean isSymmetricOrigin(TreeNode root) {
        if (root == null) {
            return true;
        }
        Integer nullValue = Integer.MAX_VALUE;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node == null) {
                    checkList.add(nullValue);
                    checkList.add(nullValue);
                    continue;
                }
                TreeNode left = node.left;
                if (left == null) {
                    checkList.add(nullValue);
                } else {
                    checkList.add(left.val);
                }
                deque.offer(node.left);
                TreeNode right = node.right;
                if (right == null) {
                    checkList.add(nullValue);
                } else {
                    checkList.add(right.val);
                }
                deque.offer(node.right);
            }
            boolean checkResult = check();
            if (!checkResult) {
                return false;
            }
        }
        return true;
    }

    private boolean check() {
        int left = 0, right = checkList.size() - 1;
        while (left <= right) {
            if (!checkList.get(left).equals(checkList.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        checkList.clear();
        return true;
    }
}
