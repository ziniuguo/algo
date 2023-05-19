package io.catroll.algo;

public class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i : nums) {
            if (i != nums[count - 1]) {
                nums[count++] = i;
            }
        }
        return count;
    }
}
