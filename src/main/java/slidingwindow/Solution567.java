package slidingwindow;

import java.util.Arrays;

public class Solution567 {
    /**
     * 固定窗口大小
     *
     * @param s1 目的
     * @param s2 源字符串
     * @return 是否匹配
     */
    public boolean checkInclusion(String s1, String s2) {
        int targetLen = s1.length();
        int len = s2.length();
        if (len < targetLen) {
            return false;
        }
        int[] targetArr = new int[26];
        int[] arr = new int[26];
        for (int i = 0; i < targetLen; i++) {
            targetArr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(targetArr, arr)) {
            return true;
        }
        for (int i = targetLen; i < len; i++) {
            arr[s2.charAt(i) - 'a']++;
            arr[s2.charAt(i - targetLen) - 'a']--;
            if (Arrays.equals(targetArr, arr)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 窗口大小可变
     *
     * @param s1 目的
     * @param s2 源字符串
     * @return 是否匹配
     */
    public boolean checkInclusion2(String s1, String s2) {
        int len = s2.length();
        int tLen = s1.length();
        if (len < tLen) {
            return false;
        }
        int left = 0, right = 0;
        int[] window = new int[128];
        int[] need = new int[128];
        int valid = 0, count = 0;
        for (Character c : s1.toCharArray()) {
            if (need[c] == 0) {
                valid++;
            }
            need[c]++;
        }
        char[] array = s2.toCharArray();
        while (right < len) {
            char c = array[right];
            if (need[c] > 0) {
                window[c]++;
                if (window[c] == need[c]) {
                    count++;
                }
            }
            while (count == valid) {
                if ((right - left + 1) == s1.length()) {
                    return true;
                }
                char leftC = array[left];
                if (window[leftC] > 0) {
                    if (window[leftC] == need[leftC]) {
                        count--;
                    }
                    window[leftC]--;
                }
                left++;
            }
            right++;
        }
        return false;
    }
}
