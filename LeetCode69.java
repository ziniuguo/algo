package leetcode;

public class LeetCode69 {
    public static int mySqrt(int x) {
        if (x==1) {
            return 1;
        }

        return (int) recur(x, x / 2, 1, x);
    }

    public static long recur(long x, long ans, long low, long high) {
        if (ans * ans == x) {
            return ans;
        }
        if (ans * ans < x && (ans + 1) * (ans + 1) > x) {
            return ans;
        }
        if (ans * ans < x) {
            ans = recur(x, (ans + high) / 2, ans, high);
        } else {
            ans = recur(x, (ans + low) / 2, low, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(565111));
    }
}
// 6
// 3
// 1
//