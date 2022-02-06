/* 1748. Sum of Unique Elements */
public class Solution {
    public int sumOfUnique(int[] nums) {
        int[] arr = new int[101];
        for (int num : nums) {
            arr[num]++;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                sum += i;
        }
        return sum;
    }
}