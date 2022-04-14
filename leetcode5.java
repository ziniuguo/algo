package leetcode;

import java.util.ArrayList;

public class leetcode5 {
    public static String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    String sub = s.substring(i, j + 1);
                    if (isPalindrome(sub) && sub.length() > ans.length() ){
                        ans = sub;
                    }
                }
            }
        }
        return ans;
    }

    public static boolean isPalindrome(String p) {
        for (int i = 0, j = p.length() - 1; i < p.length() && j >= 0; i++, j--) {
            if (p.charAt(i) != p.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
