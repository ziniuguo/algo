package io.catroll.algo;

import java.util.HashMap;
import java.util.Map;

class LeetCode205 {
    public static boolean checkIsIsomorphic(String s, String t) {
        Map<Character, Character> replacementMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++)  {
            char currCharInS = s.charAt(i);
            char currCharInT = t.charAt(i);
            if (replacementMap.get(currCharInS) == null) {
                replacementMap.put(currCharInS, currCharInT);
            } else {
                char charTInMap = replacementMap.get(currCharInS);
                if (charTInMap != currCharInT) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isIsomorphic(String s, String t) {
        if (checkIsIsomorphic(s, t) && checkIsIsomorphic(t, s)) {
            return true;
        } else {
            return false;
        }
    }
// badc bada
    public static void main(String[] args) {
        System.out.println(isIsomorphic("abb", "baa"));
    }
}