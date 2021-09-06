package String;

/**
 * @author luli
 * @date 2021/9/5
 */
public class Solution541 {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i += 2 * k) {
            int r = i + k - 1;
            reserve(arr, i, Math.min(r, arr.length - 1));
        }
        return new String(arr);
    }

    private void reserve(char[] arr, int left, int right) {
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
