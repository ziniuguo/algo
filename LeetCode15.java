package leetcode;

import java.util.*;

public class LeetCode15 {
    // 3 sum
    public static void main(String[] args) {
        int[] numsIn = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(numsIn));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
//                    List<Integer> currAns = Arrays.asList(nums[i], nums[left], nums[right]);
                    List<Integer> currAns = new ArrayList<>();
                    currAns.add(nums[i]);
                    currAns.add(nums[left]);
                    currAns.add(nums[right]);
                    if (set.add(currAns)) {
                        ansList.add(currAns);
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ansList;
    }

    public static List<List<Integer>> noPassThreeSum(int[] nums) {
        // actually have i, j no need obj ref compare
        // no sort, no pass
        List<List<Integer>> ansList = new ArrayList<>();
        ArrayList<Integer> inList = new ArrayList<>(nums.length);
        HashMap<Integer, ArrayList<Integer>> inHashMap = new HashMap<>();
        for (int i : nums) {
            Integer intObj = new Integer(i);
            inList.add(intObj);
            ArrayList<Integer> innerArrayList = inHashMap.get(i);
            if (innerArrayList != null) {
                innerArrayList.add(intObj);
            } else {
                innerArrayList = new ArrayList<>();
                innerArrayList.add(intObj);
                inHashMap.put(i, innerArrayList);
            }
        }

        for (int i = 0; i < inList.size(); i++) {
            Integer intObj1 = inList.get(i);
            for (int j = i + 1; j < inList.size(); j++) {
                Integer intObj2 = inList.get(j);
                if (intObj1 == intObj2) {
                    continue;
                }
                int compliment = - (intObj1 + intObj2);
                ArrayList<Integer> complimentList = inHashMap.get(compliment);
                if (complimentList == null) {
                    continue;
                }
                for (Integer intObj3 : complimentList) {
                    if (intObj3 != intObj1 && intObj3 != intObj2) {
                        List<Integer> currAns = Arrays.asList(
                                intObj1,
                                intObj2,
                                intObj3);
                        Collections.sort(currAns);
                        if (!ansList.contains(currAns)) {
                            ansList.add(currAns);
                        }
                        break;
                    }
                }
            }
        }
        return ansList;
    }
}
