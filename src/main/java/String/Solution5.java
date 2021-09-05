package String;

/**
 * @author luli
 * @date 2021/9/5
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int max = -1;
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = palindromeLen(s, i, i);
            int len2 = palindromeLen(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > max) {
                max = len;
                l = i - (len - 1) / 2;
                r = i + (len) / 2;
            }
        }
        return s.substring(l, r + 1);
    }

    private int palindromeLen(String s, int left, int right) {
        while (right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        int max = -1;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (j - i + 1 > max && isPalindrome(s, i, j)) {
                    max = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        return left == right || left - right == 1;
    }
}
