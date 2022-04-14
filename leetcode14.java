package leetcode;

public class leetcode14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length==0) {
            return "";
        }
        int count = 0;

        int maxL = Integer.MAX_VALUE;
        for (String s : strs) {
            if (s.length() < maxL) {
                maxL = s.length();
            }
        }

        for (int j=0; j < maxL; j++) {
            char curr = strs[0].charAt(j);
            System.out.println(curr);
            boolean c = true;
            for (String s : strs) {
                if (s.charAt(j) != curr) {
                    c = false;
                    break;
                }
            }
            System.out.println(c);
            if (c) {
                count += 1;
            } else {
                break;
            }
        }
        return strs[0].substring(0, count);
    }

    public static void main(String[] args) {
        String[] in = {"cir", "car"};
        System.out.println(longestCommonPrefix(in));
    }
}
