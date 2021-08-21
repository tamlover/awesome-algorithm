package slidingwindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution567Test {
    Solution567 solution567 = new Solution567();

    @Test
    public void test1() {
        String s1 = "ab", s2 = "eidbaooo";
        assertTrue(solution567.checkInclusion(s1, s2));
    }

    @Test
    public void test2() {
        String s1 = "ab", s2 = "a";
        assertFalse(solution567.checkInclusion(s1, s2));
    }

}