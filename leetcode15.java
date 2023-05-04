package leetcode;

import java.util.*;

public class leetcode15 {
    // 3 sum
    public static void main(String[] args) {
        // brute force, cannot pass
        int[] numsIn = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(numsIn));
        // better three sum
    }
    public static List<List<Integer>> betterThreeSum(int[] nums) {
//        HashSet<Integer> invalidSet = new HashSet<>();
//        HashSet<Integer> validSet = new HashSet<>();
        List<List<Integer>> ansList = new ArrayList<>();
        ArrayList<Integer> inList = new ArrayList<>(nums.length);
        for (int i : nums) {
            inList.add(new Integer(i));
        }

        for (Integer integer1 : inList) {
            for (Integer integer2 : inList) {
                if (integer1 == integer2) {
                    continue;
                }
                int compliment = - (integer1 + integer2);
                for (Integer integer3 : inList) {
                    if (Objects.equals(integer3, compliment)) {
                        if (integer3 != integer1 && integer3 != integer2) {
                            List<Integer> currAns = Arrays.asList(integer1, integer2, integer3);
                            Collections.sort(currAns);
                            if (!ansList.contains(currAns)) {
                                ansList.add(currAns);
                            }
                        }
                    }
                }
            }
        }
        return ansList;
    }
    public static List<List<Integer>> threeSum(int[] nums) {
//        HashSet<Integer> invalidSet = new HashSet<>();
//        HashSet<Integer> validSet = new HashSet<>();
        List<List<Integer>> ansList = new ArrayList<>();
        ArrayList<Integer> inList = new ArrayList<>(nums.length);
        for (int i : nums) {
            inList.add(new Integer(i));
        }

        for (Integer integer1 : inList) {
            for (Integer integer2 : inList) {
                if (integer1 == integer2) {
                    continue;
                }
                int compliment = - (integer1 + integer2);
                for (Integer integer3 : inList) {
                    if (Objects.equals(integer3, compliment)) {
                        if (integer3 != integer1 && integer3 != integer2) {
                            List<Integer> currAns = Arrays.asList(integer1, integer2, integer3);
                            Collections.sort(currAns);
                            if (!ansList.contains(currAns)) {
                                ansList.add(currAns);
                            }
                        }
                    }
                }
            }
        }
        return ansList;
    }
}
