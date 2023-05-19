package io.catroll.algo;

import java.util.*;

public class LeetCode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        // result list
        HashMap<Integer, Integer> counter = new HashMap<>();
        // to count the occurrence of a certain integer
        for (int num : nums) {
            if (!counter.containsKey(num)) {
                counter.put(num, 1);
            } else {
                counter.put(num, counter.get(num) + 1);
            }
        }

        LinkedList<Integer> comb = new LinkedList<>();
        backtrack(comb, nums.length, counter, results);
        return results;
    }

    private void backtrack(LinkedList<Integer> comb, Integer n,
                           HashMap<Integer, Integer> counter,
                           List<List<Integer>> results) {
        if (comb.size() == n) {
            // add copy of comb to results
            results.add(new ArrayList<>(comb));
            return;
        }
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0) continue;
            comb.addLast(num);
            counter.put(num, count - 1);
            backtrack(comb, n, counter, results);
            comb.removeLast();
            counter.put(num, count);
        }
    }
}
