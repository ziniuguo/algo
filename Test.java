package leetcode;

import java.util.*;

public class Test {
    // -1000, -3, 1, 3, 10    0
    // -3000, -2000, -3, 1, 2   -2
    // 1, 2, 3, 1000, 2000, 3000, 40000    5
    public static void main(String[] args) {
        int[] numsIn = new int[]{4, 9, 111, 12, 2};
        swap(numsIn);
        System.out.println(Arrays.toString(numsIn));

        System.out.println(1/2);
    }
    public static void swap(int[] nums) {
        int temp = nums[1];
        nums[1] = nums[0];
        nums[0] = temp;
    }
}


// 41 firstMissingPositive
// 49 groupAnagrams