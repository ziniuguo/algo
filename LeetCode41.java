package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class LeetCode41 {
    public static void main(String[] args) {
        int[] numsIn = new int[]{7,5,9,2,1};
//        System.out.println(memoryLimitExceededFirstMissingPositive(numsIn));
//        testContinuousSwap();
        System.out.println("======= solution =======");
//        System.out.println(firstMissingPositive(numsIn));
    }
    // first missing positive

    public static int maxPossible;
    private static int checkSwapped(int[] nums) {
        if (nums.length == 0|| nums[0] != 1) {return 1;}
        int pointer = 1;
        for (int num : nums) {
            if (num == pointer) {
                pointer++;
            } else {
                return pointer;
            }
        }
        return pointer;
    }
    public static LinkedList<Integer> startIdxStack = new LinkedList<>();
    public static int[] pair = new int[] {
            Integer.MIN_VALUE, Integer.MIN_VALUE
    };
    public static int notGoodFirstMissingPositive(int[] nums) {
        // at move nums.length positive integers!
        // if constant space, then cannot use extra HashMap
        // need in-place modify
        startIdxStack.clear();
        pair = new int[] {
                Integer.MIN_VALUE, Integer.MIN_VALUE
        };
        maxPossible = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            if (currNum > maxPossible || currNum <= 0) {
                continue;
            }
            int pos2Swap = currNum - 1;
            if (pos2Swap == i) {
                continue; // not necessary, for performance consideration
            }
            continuousSwap(nums, i, pos2Swap);
        }
        System.out.println("After swap: " + Arrays.toString(nums));
        return checkSwapped(nums);
    }
    public static void continuousSwap(int[] nums, int i, int j)  {
        continuousSwapHelper(nums, i, j);
        if (!(pair[0] == Integer.MIN_VALUE && pair[1] == Integer.MIN_VALUE)) {
            // which means cycle detected, restore here
            nums[pair[0]] = pair[1];
            // reset pair
            pair[0] = Integer.MIN_VALUE;
            pair[1] = Integer.MIN_VALUE;
            startIdxStack.clear();
        }
    }
    public static void continuousSwapHelper(int[] nums, int i, int j) {
        if (startIdxStack.contains(j)) {
            // cycle detected
            pair = new int[]{i, nums[i]};
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        startIdxStack.add(i);
        // base case:
        if (nums[j] > maxPossible || nums[j] <= 0) {
            nums[j] = nums[i];
        } else if (nums[j] - 1 == i) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        } else {
            continuousSwapHelper(nums, j, nums[j] - 1);
            nums[j] = nums[i];
        }
    }
    public static void testContinuousSwap() {
        int[] numsIn = new int[] {5, 4, 3, 1, 2};
        maxPossible = 5;
        // swap
        continuousSwap(numsIn, 0, 4);
        System.out.println(Arrays.toString(numsIn));
    }
    public static int canPassButNotOnFirstMissingPositive(int[] nums) {
        // instead of using an ArrayList, use a HashMap here.
        int pointer = 1;
        HashMap<Integer, Boolean> recordMap = new HashMap<>();
        for (int num : nums) {
            if (num >= 0) {
                recordMap.put(num, Boolean.TRUE);
            }
        }
        while (true) {
            Boolean exist = recordMap.get(pointer);
            if (exist != null) {
                pointer ++;
            } else {
                return pointer;
            }
        }
    }

    public static int memoryLimitExceededFirstMissingPositive(int[] nums) {
        // indicating we are looking for 1
        // (1 is currently missing)
        int pointer = 0;
        // find max no.
        int maxNumber = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNumber) {
                maxNumber = nums[i];
            }
        }
        if (maxNumber <= 0) {
            // this got 2 edge cases
            // 1. empty array
            // 2. all negative, no maxNumber
            return 1;
        }
        ArrayList<Boolean> recordList = new ArrayList<>(
                maxNumber
        );
        // initiate it
        for (int i = 0; i < maxNumber; i++) {
            // add from 0
            recordList.add(Boolean.FALSE);
        }
        // loop through given nums
        for (int num : nums) {
            if (num <= 0) {continue;}
            recordList.set(num - 1, Boolean.TRUE);
            if (num - 1 == pointer) {
                // move pointer
                do {
                    pointer++;
                } while (pointer < maxNumber && recordList.get(pointer) == Boolean.TRUE);
            }
        }
        return pointer + 1;
    }
}
