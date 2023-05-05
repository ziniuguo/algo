package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode22 {
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> ansList = new ArrayList<>();
        if (n == 1) {
            ansList.add("()");
            return ansList;
        } else {
            // first sublist, only n-1
            ArrayList<String> subList1 = (ArrayList<String>) generateParenthesis(n - 1);

            for (String s : subList1) {
                ansList.add("(" + s + ")");
            }

            // second sublist, f(i) + f(i - 1)
            for (int i = 1; i <= (n+1) / 2; i++) {
                ArrayList<String> subList2 = (ArrayList<String>) generateParenthesis(i);
                ArrayList<String> subList3 = (ArrayList<String>) generateParenthesis(n - i);
                for (String j : subList2) {
                    for (String k : subList3) {
                        String temp = j + k;
                        if (!ansList.contains(temp)) {
                            ansList.add(temp);
                        }
                        String temp2 = k + j;
                        if (!ansList.contains(temp2)) {
                            ansList.add(temp2);
                        }
                    }
                }
            }

            return ansList;
        }

    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
}
