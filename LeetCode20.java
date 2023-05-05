package leetcode;

import java.util.Stack;

public class leetcode20 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <= s.length() - 1; i++) {
            char curr = s.charAt(i);
            if (curr == '(' || curr == '[' || curr == '{') {
                stack.push(curr);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char peek = stack.peek();
                if (peek == '(' && curr != ')') {
                    return false;
                }
                if (peek == '[' && curr != ']') {
                    return false;
                }
                if (peek == '{' && curr != '}') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[(])()"));
    }
}
