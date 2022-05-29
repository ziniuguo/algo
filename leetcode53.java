package leetcode;

import java.util.ArrayList;

public class leetcode53 {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            currentSum = Math.max(currentSum + num, num);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

}
