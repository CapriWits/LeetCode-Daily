import java.util.*;

/* 1480. Running Sum of 1d Array */
public class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length, res = 0;
        for (int i = 0; i < n; i++) {
            int left = i + 1, right = n - i; // 左侧和右侧的选择情况，包括 i 本身
            int leftOdd = left / 2, leftEven = (left + 1) / 2;
            int rightOdd = right / 2, rightEven = (right + 1) / 2;
            res += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }
        return res;
    }
}