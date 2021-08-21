package doublepointer;

public class Solution443 {
    public int compress(char[] cs) {
        int n = cs.length;
        if(n == 1) {
            return 1;
        }
        // left元素开始位置，right输出位置
        int left = 0, right = 0;
        while (left < n) {
            int index = left;
            while (index < n && cs[index] == cs[left]){
                index++;
            }
            int count = index - left;
            // 跟上输出位置
            cs[right++] = cs[left];
            if (count <= 1) {
                left = index;
                continue;
            }
            char[] cntChars = Integer.toString(count).toCharArray();
            int cntIndex = 0;
            while (cntIndex < cntChars.length) {
                cs[right++] = cntChars[cntIndex];
                cntIndex++;
            }
            left = index;
        }
        return right;
    }
}
