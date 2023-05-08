package leetcode;

import java.util.*;

public class LeetCode1 {

    public static void main(String[] args) {
        int[] numsIn = {3,3,4};
        int targetIn = 6;
        int[] result = twoSum(numsIn, targetIn);
        System.out.println(Arrays.toString(result));
        int[] result2 = betterTwoSum(numsIn, targetIn);
        System.out.println(Arrays.toString(result2));
    }

    public static int[] betterTwoSum(int[] nums, int target) {
        Map<Integer, Integer> onePassMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int theOther = target - nums[i];
            if (onePassMap.containsKey(theOther)) {
                return new int[] {onePassMap.get(theOther), i};
            }
            onePassMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("no solution found");
    }


    public static int[] twoSum(int[] nums, int target) {
        // if length is 2
        if (nums.length == 2) {
            return new int[]{0, 1};
        }
        // sort the nums array, rmb the old index
        TreeMap<Object, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (treeMap.containsKey(nums[i])) {
                int res1 = treeMap.get(nums[i]);
                if (nums[i] + nums[res1] == target) {
                    return new int[]{res1, i};
                }
            }
            treeMap.put(nums[i], i);
        }
        // have the treeMap already -19, -18, -10, -1
        Iterator<Map.Entry<Object, Integer>> it1 = treeMap.entrySet().iterator();
        Iterator<Map.Entry<Object, Integer>> it2 = treeMap.descendingMap().entrySet().iterator();
        Map.Entry<Object, Integer> cur1 = it1.next();
        Map.Entry<Object, Integer> cur2 = it2.next();
        while (true) {
            // -3000, -2000, -3, 1, 2   || -2
            // 1, 2, 3, 1000, 2000, 3000, 40000    || 5
            int sum = (int)cur1.getKey() + (int)cur2.getKey();
            if (sum == target) {
                return new int[] {cur1.getValue(), cur2.getValue()};
            }
            if (sum > target) {
                cur2 = it2.next();
            }
            if (sum < target) {
                cur1 = it1.next();
            }
        }
    }
}


// 1, 2, 3, 4, 7;    7

// O(n^2)
// O(n)
// o)