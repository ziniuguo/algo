package leetcode;

public class leetcode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int out = Integer.MAX_VALUE;
        if (sumIJ(0, nums.length - 1, nums) < target) {
            return 0;
        }
        while (true) {
            int curr = sumIJ(i, j, nums);
            if (curr < target) {
                j += 1;
                // later judge out of range or not
            } else {
                if (j - i + 1 < out) {
                    out = j - i + 1;

                }
                i += 1;
            }

            if (out == 1) {
                return 1;
            }
            if (j == nums.length - 1 && sumIJ(i, j, nums) < target) {
                System.out.println("finalI" + i);
                System.out.println("finalJ" + j);
                return out;
            }
        }
    }

    private int sumIJ(int i, int j, int[] nums) {
        if (i == j) {
            return nums[i];
        } else {
            int sum = 0;
            for (int k = i; k <= j; k++) {
                sum += nums[k];
            }
            return sum;
        }
    }
}
