package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class test {
    // -1000, -3, 1, 3, 10    0
    // -3000, -2000, -3, 1, 2   -2
    // 1, 2, 3, 1000, 2000, 3000, 40000    5
    public static void main(String[] args) {
        ArrayList<Integer> testHashSet = new ArrayList<>();
        Integer intObj = new Integer(1);
        Integer intObj2 = new Integer(1);
        testHashSet.add((int) intObj);
        testHashSet.add((Integer)intObj2);
        testHashSet.add((Integer)intObj2);
        testHashSet.add(new Integer(2));
        System.out.println(testHashSet);
    }
}


// a b c d e f g
// a b c d e f g
// a b c d e f g
