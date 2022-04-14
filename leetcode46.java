package leetcode;

import org.graalvm.compiler.core.common.util.ReversedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class leetcode46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> nums2 = new ArrayList<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            nums2.add(nums[i]);
        }
        return permuteRec(nums2);
    }

    public static List<List<Integer>> permuteRec(List<Integer> nums) {
        List<Integer> inner = new ArrayList<>();
        if (nums.size() == 1) {
            List<List<Integer>> retList = new ArrayList<>();
            inner.add(nums.get(0));
            retList.add(inner);
            return retList;
        } else {
            List<List<Integer>> retList = new ArrayList<>();
            List<List<Integer>> oldList = permuteRec(nums.subList(0, nums.size() - 1)); // [[1]]
            int newInt = nums.get(nums.size() - 1); // 2 现在要把2加到[1]
            for (List<Integer> i : oldList) {
                for (int j = 0; j <= i.size(); j++) {
                    List<Integer> tempList = new ArrayList<>(i); // deep copy [1]
                    tempList.add(j, newInt);
                    retList.add(tempList);
                }
            }
            return retList;
        }
    }

    public static void main(String[] args) {
        int[] in = {1, 2, 3, 4};
        System.out.println(permute(in));
    }
}

// consider using linkedList?