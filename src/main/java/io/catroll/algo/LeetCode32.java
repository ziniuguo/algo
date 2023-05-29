package io.catroll.algo;

public class LeetCode32 {
    // dynamic programming
    /*DP rule
    *
    * s[i]= ')' and s[i-1] = '('
    * i.e. string looking like ......()
    * dp[i] = dp[i - 2] + 2
    *
    * s[i] = '(' and s[i - 1] ')'
    * i.e. string looking like ......))
    * if s[i - dp[i - 1] - 1] = '(' then
    * dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
    *
    * */
    public static int longestValidParentheses(String s) {
        int max = 0;
        int dp[] = new int [s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                // scan ')'
                if (s.charAt(i - 1) == '(') {
                    // if last one is '('
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
            }
        }
        return 0;

    }

}
