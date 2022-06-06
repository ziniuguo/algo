package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        ansList.add(new ArrayList<>());
        for (int i : nums) {
            List<List<Integer>> ansCopy = new ArrayList<>(ansList);
            for (List<Integer> j : ansCopy) {
                List<Integer> copy = new ArrayList<>(j);
                copy.add(i);
                ansList.add(copy);
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        System.out.println(subsets(input));
    }
}
