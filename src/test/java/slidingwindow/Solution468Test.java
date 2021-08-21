package slidingwindow;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution468Test {
    Solution468 solution468 = new Solution468();
    @Test
    public void test1() {
        String s = "cbaebabacd", p = "abc";
        List<Integer> expect = Arrays.asList(0, 6);
        assertEquals(expect, solution468.findAnagrams(s, p));
    }
}