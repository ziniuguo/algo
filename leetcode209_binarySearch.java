package leetcode;

/* let me do a further explanation.
suppose we have input target = 7, nums = [2, 3, 1, 2, 4, 3]
then
nums = [2, 3, 1, 2, 4, 3]
sums = [0, 2, 5, 6, 8, 12, 15]
in sums, the difference should be the target
so, we iterate through the sums, and define a to_find to be
the value we want to find in the sums array
obviously, the to_find should be +7
how do we find the to_find in the sums? Binary search.
(we are not finding exactly to_find value in sums,
but rather the bound. once we find it, it is a situation that
satisfies the condition)
so, iteration takes O(n), and search to_find takes O(log n)
it is already sorted, we do not need to sort it.
so, totally, O(n log n)
well, this solution is pure dog water */


import java.util.Arrays;
class leetcode209_binarySearch{
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int j = 0; j <= sums.length - 1; j++) {
            int to_find = sums[j] + target;
            int result = lower_bound(sums, to_find);
            if (result != sums.length) {
                result = result - j;
                if (result < ans) {
                    ans = result;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    private static int lower_bound(int[] array, int key) {

        int index = Arrays.binarySearch(array, key);
        // If key is not present in the array
        if (index < 0) {
            // Index specify the position of the key
            // when inserted in the sorted array
            // so the element currently present at
            // this position will be the lower bound
            return Math.abs(index)- 1;
        }

        // If key is present in the array
        // we move leftwards to find its first occurrence
        else {
            // Decrement the index to find the first
            // occurrence of the key
            while (index > 0) {
                // If previous value is same
                if (array[index - 1] == key)
                    index--;
                    // Previous value is different which means
                    // current index is the first occurrence of
                    // the key
                else
                    return index;
            }
            return index;
        }
    }
}