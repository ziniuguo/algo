package leetcode;

public class LeetCode9 {
    public static boolean isPalindrome(int x) {
        String x2 = String.valueOf(x);
        for (int i=0; i<x2.length()/2;i++){
            if (x2.charAt(x2.length()-1-i) != x2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(100021));  // mul = 100000, count = 5
    }
}
