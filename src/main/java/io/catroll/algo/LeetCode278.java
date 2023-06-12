package io.catroll.algo;

import java.util.Date;

public class LeetCode278 {
    // 1,2,3,444,5
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int mid = -1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                if (high == mid) {
                    return mid;
                }
                high = mid;
            } else {
                if (low == mid) {
                    return mid + 1;
                }
                low = mid;
            }
        }

        return mid;
    }

    // placeholder code
    private boolean isBadVersion(int n) {
        return n > new Date().getTime();
    }
}
