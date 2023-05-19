package io.catroll.algo;

public class leetcode389 {
    public char findTheDifference(String s, String t) {
        for (int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            int tind = t.lastIndexOf(curr);
            t = t.substring(0, tind) + t.substring(tind + 1);
        }
        return t.charAt(0);
    }

    public static void main(String[] args) {
        String test = "";
        for (int i=0; i<test.length(); i++) {
            System.out.println("".charAt(i));
        }

    }
}
