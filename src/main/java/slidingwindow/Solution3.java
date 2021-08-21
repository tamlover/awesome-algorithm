package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口模板代码
 * int left = 0, right = 0;
 *
 * while (right < s.size()) {
 *     // 增大窗口
 *     window.add(s[right]);
 *     right++;
 *
 *     while (window needs shrink) {
 *         // 缩小窗口
 *         window.remove(s[left]);
 *         left++;
 *     }
 * }
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        Map<Character, Integer> window = new HashMap<>();
        char[] arr = s.toCharArray();
        int left = 0, right = 0, res = 0;
        while (right < len) {
            char c = arr[right];
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                // 这里right - left不加1的原因是，right已经超出子串，不算在里面
                res = Math.max(res, right - left);
                char leftChar = arr[left];
                if (window.get(leftChar) != null) {
                    window.put(leftChar, window.get(leftChar) - 1);
                }
                left++;
            }
            right++;
        }
        return Math.max(res, right - left);
    }
}
