package io.catroll.algo;

import java.util.Date;

public class LeetCode278 {

    public int firstBadVersion(int n) {
        int low = 0;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2; // exceed max int
            if (isBadVersion(mid) && !isBadVersion(mid - 1)) return mid;
            else if (!isBadVersion(mid)) low = mid + 1; // why
            else high = mid;
        }
        return -1;
    }

    // placeholder code
    private boolean isBadVersion(int n) {
        return n > new Date().getTime();
    }
}
