package leetcode;

public class leetcode26 {
    public int removeDuplicates(int[] nums) {
        int count = 0;

        count += 1;
        for (int i : nums) {
            if (i != nums[count - 1]) {
                nums[count] = i;
                count += 1;
            }
        }
        return count;
    }
}
