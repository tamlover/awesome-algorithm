package dfs;

import java.util.*;

/**
 * @author luli
 * @date 2021/8/23
 */
public class Solution51 {
    List<List<String>> res = new ArrayList<>();
    int n;
    char[][] tmp;
    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        tmp = new char[n][n];

        // 这里每一行都过
        for (int i = 0; i < n; i++) {
            Arrays.fill(tmp[i], '.');
        }
        this.n = n;
        dfs(0);
        return res;
    }

    private void dfs(int row) {
        if (row == n) {
            List<String> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                list.add(new String(tmp[i]));
            }
            res.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!valid(row, i)) {
                continue;
            }
            tmp[row][i] = 'Q';
            dfs(row+1);
            tmp[row][i] = '.';
        }
    }

    private boolean valid(int i, int j) {
        // 检查列
        for (int k = 0; k < n; k++) {
            if (tmp[k][j] == 'Q') {
                return false;
            }
        }

        // 检查左上
        int row = i, column = j;
        while (row >= 0 && column >= 0) {
            if (tmp[row][column] == 'Q') {
                return false;
            }
            row--;
            column--;
        }

        row = i;
        column = j;

        // 检查右上
        while (row >= 0 && column < n) {
            if (tmp[row][column] == 'Q') {
                return false;
            }
            row--;
            column++;
        }
        return true;
    }
}
