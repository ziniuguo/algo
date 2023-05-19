package io.catroll.algo;

public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i : nums) {
            if (i != val) {
                nums[count++] = i;
            }
        }
        return count;
    }
}
