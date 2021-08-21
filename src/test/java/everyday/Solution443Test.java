package everyday;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution443Test {
    Solution443 solution443 = new Solution443();

    @Test
    public void test1() {
        char[] cs = new char[]{'a','a','b','b','c','c','c'};
        assertEquals(6, solution443.compress(cs));
    }

    @Test
    public void test2() {
        String[] str = new String[]{"a","b","b","b","b","b","b","b","b","b","b","b","b"};
        char[] cs = new char[str.length];
        for (int i = 0; i < str.length; i++) {
            cs[i] = str[i].toCharArray()[0];
        }
        assertEquals(4, solution443.compress(cs));
    }

    @Test
    public void test3() {
        String[] str = new String[]{"a"};
        char[] cs = new char[str.length];
        for (int i = 0; i < str.length; i++) {
            cs[i] = str[i].toCharArray()[0];
        }
        assertEquals(1, solution443.compress(cs));
    }

    @Test
    public void test4() {
        String[] str = new String[]{"a","a","a","a","a","b"};
        char[] cs = new char[str.length];
        for (int i = 0; i < str.length; i++) {
            cs[i] = str[i].toCharArray()[0];
        }
        assertEquals(3, solution443.compress(cs));
    }
}