package leetcode;

import java.util.Collections;

public class leetcode344 {
    public static void reverseString(char[] s) {

//        char[] ans = new char[s.length];
        for (int i = 0; i <= (s.length - 1) / 2; i++) {
            char mem = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = mem;
        }
//        s = ans;

    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(s);
    }
}
