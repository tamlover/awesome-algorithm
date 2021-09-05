package String;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author luli
 * @date 2021/9/5
 */
class Solution5Test {
    Solution5 solution5 = new Solution5();

    @Test
    public void test1() {
        String str = "babad";
        assertEquals("bab", solution5.longestPalindrome(str));
    }

    @Test
    public void test2() {
        String str = "bb";
        assertEquals("bb", solution5.longestPalindrome(str));
    }
}