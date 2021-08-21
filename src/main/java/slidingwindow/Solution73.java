package slidingwindow;

public class Solution73 {
    public String minWindow(String s, String t) {
        int len = s.length();
        int tLen = t.length();
        if (len < tLen) {
            return "";
        }

        // 记录需要匹配个数
        int needCount = 0;
        int[] need = new int[128];
        int[] window = new int[128];
        for (Character c : t.toCharArray()) {
            if (need[c] == 0) {
                needCount++;
            }
            need[c]++;
        }
        char[] arr = s.toCharArray();
        int left = 0, right = 0, valid = 0;
        int start = 0, end = -1;
        String res = "";
        int resSize = Integer.MAX_VALUE;
        while (left <= right && right < len) {
            char c = arr[right];
            if (need[c] > 0) {
                window[c]++;
                if (window[c] == need[c]) {
                    valid++;
                }
            }
            while (valid == needCount) {
                char leftC = arr[left];
                if (window[leftC] > 0) {
                    if (window[leftC] == need[leftC]) {
                        valid--;
                    }
                    window[leftC]--;
                }

                // 记录结果
                int size = (right - left) + 1;
                if (size < resSize) {
                    start = left;
                    end = right;
                    resSize = size;
                }
                left++;
            }
            right++;
        }
        return end >= 0 ? s.substring(start, end + 1) : res;
    }
}