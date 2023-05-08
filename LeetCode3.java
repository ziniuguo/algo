package leetcode;

public class LeetCode3 {
    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        for (int i=0; i<s.length(); i++){
            System.out.println("i: "+i);
            String st = "";
            int subans = 0;
            for (int j=i, jd=0; j<s.length() && jd == 0; j++) {
                System.out.println("j: " + j);
                char c = s.charAt(j);
                System.out.println("char c: " + c);
                if (st.indexOf(c) == -1) {

                    st += c;
                    System.out.println("inner " + st);
                    subans += 1;
                } else {
                    jd = 1;
                }
            }
            System.out.println(st);
            if (subans > ans) {
                ans = subans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("wkj"));
    }
}
