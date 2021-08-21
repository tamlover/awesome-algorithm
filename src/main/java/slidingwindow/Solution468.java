package slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class Solution468 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int len = s.length();
        int targetLen = p.length();
        if (len < targetLen) {
            return res;
        }
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int[] window = new int[26];
        int[] need = new int[26];
        int valid = 0;
        for (Character c : pArr) {
            if (need[c - 'a'] == 0) {
                valid++;
            }
            need[c - 'a']++;
        }

        int left = 0, right = 0, count = 0;
        while (right < len) {
            char c = sArr[right];
            if (need[c - 'a'] > 0) {
                window[c - 'a']++;
                if (window[c - 'a'] == need[c - 'a']) {
                    count++;
                }
            }
            while (count == valid) {
                if (right - left + 1 == targetLen) {
                    res.add(left);
                }
                char leftChar = sArr[left];
                if (window[leftChar - 'a'] > 0) {
                    if (window[leftChar - 'a'] == need[leftChar - 'a']) {
                        count--;
                    }
                    window[leftChar - 'a']--;
                }
                left++;
            }
            right++;
        }
        return res;
    }
}
