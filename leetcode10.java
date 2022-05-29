package leetcode;

public class leetcode10 {
    public static boolean isMatch(String text, String pattern) {
        System.out.println(text);
        System.out.println(pattern);
        System.out.println();
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return ((isMatch(text, pattern.substring(2))) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("ip", "s*p"));
    }
}
