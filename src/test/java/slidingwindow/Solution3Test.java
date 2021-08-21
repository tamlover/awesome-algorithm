package slidingwindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution3Test {
    Solution3 solution3 = new Solution3();
    @Test
    public void test1() {
        String s = "abcabcbb";
        assertEquals(3, solution3.lengthOfLongestSubstring(s));
    }

    @Test
    public void test2() {
        String s = "bbbbb";
        assertEquals(1, solution3.lengthOfLongestSubstring(s));
    }

    @Test
    public void test3() {
        String s = "pwwkew";
        assertEquals(3, solution3.lengthOfLongestSubstring(s));
    }

    @Test
    public void test4() {
        String s = "au";
        assertEquals(2, solution3.lengthOfLongestSubstring(s));
    }

    @Test
    public void test5() {
        String s = "tmmzuxt";
        assertEquals(5, solution3.lengthOfLongestSubstring(s));
    }
}