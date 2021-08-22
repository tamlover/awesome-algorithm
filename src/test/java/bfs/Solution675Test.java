package bfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author luli
 * @date 2021/8/22
 */
class Solution675Test {
    Solution675 solution675 = new Solution675();
    @Test
    public void test1() {
        Integer[][] integers = new Integer[][]{{1,2,3},{0,0,4},{7,6,5}};
        List<List<Integer>> listList = new ArrayList<>();
        for (Integer[] integers1: integers) {
            listList.add(Arrays.asList(integers1));
        }
        assertEquals(6, solution675.cutOffTree(listList));
    }

    @Test
    public void test2() {
        Integer[][] integers = new Integer[][]{{1,2,3},{0,0,0},{7,6,5}};
        List<List<Integer>> listList = new ArrayList<>();
        for (Integer[] integers1: integers) {
            listList.add(Arrays.asList(integers1));
        }
        assertEquals(-1, solution675.cutOffTree(listList));
    }

    @Test
    public void test3() {
        Integer[][] integers = new Integer[][]{{2,3,4},{0,0,5},{8,7,6}};
        List<List<Integer>> listList = new ArrayList<>();
        for (Integer[] integers1: integers) {
            listList.add(Arrays.asList(integers1));
        }
        assertEquals(6, solution675.cutOffTree(listList));
    }

    @Test
    public void test5() {
        Integer[][] integers = new Integer[][]{{4,2,3},{0,0,1},{7,6,5}};
        List<List<Integer>> listList = new ArrayList<>();
        for (Integer[] integers1: integers) {
            listList.add(Arrays.asList(integers1));
        }
        assertEquals(10, solution675.cutOffTree(listList));
    }

    @Test
    public void test4() {
        Integer[][] integers = new Integer[][]{{54581641,64080174,24346381,69107959},{86374198,61363882,68783324,79706116},{668150,92178815,89819108,94701471},{83920491,22724204,46281641,47531096},{89078499,18904913,25462145,60813308}};
        List<List<Integer>> listList = new ArrayList<>();
        for (Integer[] integers1: integers) {
            listList.add(Arrays.asList(integers1));
        }
        assertEquals(57, solution675.cutOffTree(listList));
    }
}