package io.catroll.algo;

public class leetcode209_2 {
    public int minSubArrayLen(int target, int[] nums) {
        int out = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i=0; i<=nums.length-1;i++) {
            sum += nums[i];
            while (sum >= target) {
                out = Math.min(out, i +1 - left);
                sum -= nums[left++];
            }
        }
        return (out != Integer.MAX_VALUE) ? out : 0;
    }
}
