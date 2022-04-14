package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class leetcode268 {
    public static int missingNumber(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i : nums) {
            count += 1;
            sum += i;
            if (i > max) {
                max = i;
            }
        }
        int target = (1 + max) * max / 2;
        System.out.println("target " + target);
        System.out.println("sum " + sum);
        System.out.println("count " + count);
        System.out.println("max " + max);
        if (sum == target) { // 缺少0 或者最大
            if (count == max) {
                return 0;
            } else {
                return max + 1;
            }
        } else {
            return target - sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 1, 2, 3}));
    }
}
