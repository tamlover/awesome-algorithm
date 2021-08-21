package slidingwindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution73Test {
    Solution73 solution73 = new Solution73();

    @Test
    public void test1() {
        String s = "ADOBECODEBANC", t = "ABC";
        assertEquals("BANC", solution73.minWindow(s, t));
    }

    @Test
    public void test2() {
        String s = "a", t = "a";
        assertEquals("a", solution73.minWindow(s, t));
    }

    @Test
    public void test3() {
        String s = "a", t = "aa";
        assertEquals("", solution73.minWindow(s, t));
    }

    @Test
    public void test4() {
        String s = "aa", t = "aa";
        assertEquals("aa", solution73.minWindow(s, t));
    }

    @Test
    public void test5() {
        String s = "a", t = "b";
        assertEquals("", solution73.minWindow(s, t));
    }

    @Test
    public void test6() {
        String s = "cgklivwehljxrdzpfdqsapogwvjtvbzahjnsejwnuhmomlfsrvmrnczjzjevkdvroiluthhpqtffhlzyglrvorgnalk", t = "mqfff";
        assertEquals("fsrvmrnczjzjevkdvroiluthhpqtff", solution73.minWindow(s, t));
    }
}