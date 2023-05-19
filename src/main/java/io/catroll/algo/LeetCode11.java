package io.catroll.algo;

public class LeetCode11 {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int currH2 = Integer.MIN_VALUE;
        // i goes front
        int len = height.length;
        for (int i = 0; i <= len - 2; i++) {
            // 相似，如果i比之前高才用算，不然不用算了
            if (height[i] > currH2) {
                int currH = Integer.MIN_VALUE;
                // j goes back
                for (int j = len - 1; j >= i + 1 ; j--) {
                    // 如果j比之前还低，还更靠近i，就不用算了
                    if (height[j] > currH) {
                        int curr = Math.min(height[i], height[j]) * (j - i);
                        if (curr > max) {
                            max = curr;
                        }
                        currH = height[j];
                    }
                    // 如果它比i大了，那就直接可以break，因为再怎么往回走都是以i为基准或者更低
                    if (currH > height[i]) {
                        break;
                    }
                    // 精彩操作！如果i比j大，那就不管这个j了
                    if (height[i] > height[j]) {
                        len -= 1;
                    }
                }
                currH2 = height[i];
            }
        }
        return max;
    }
}
