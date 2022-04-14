package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class leetcode136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result ^= i;
        }
        return result;
    }
}

// today's leetcode ends here!