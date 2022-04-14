package leetcode;

import java.util.HashMap;

public class leetcode287 {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Boolean> seen = new HashMap<>();

        for (int i : nums) {
            if (seen.get(i) == null) {
                return i;
            } else {
                seen.put(i, true);
            }
        }

        return -1;
    }

}
