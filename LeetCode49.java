package leetcode;


import java.util.*;

public class LeetCode49 {
    public static void main(String[] args) {
        String[] inStr = new String[]{
                "eat","tea","tan","ate","nat","bat"
        };
        System.out.println(slowerGroupAnagrams(inStr));
        System.out.println(groupAnagrams(inStr));
    }
    public static List<List<String>> groupAnagrams(String[] strings) {
        /*
         * time complexity:
         * O(nm)
         * where n is the total number of words
         * and m is the length of each word
         * m when calculating the key
         * n when iterating the entire list
         * */
        HashMap<String, List<String>> ansMap = new HashMap<>();
        for (String string : strings) {
            char[] frequencyCharArr = new char[26];
            for (int i = 0; i < string.length(); i++) {
                frequencyCharArr[string.charAt(i) - 'a']++;
            }
            String key = new String(frequencyCharArr);
            if (ansMap.get(key) == null) {
                List<String> currAnsList = new LinkedList<>();
                currAnsList.add(string);
                ansMap.put(key, currAnsList);
            } else {
                ansMap.get(key).add(string);
            }
        }
        return new LinkedList<>(ansMap.values());
    }
    public static List<List<String>> slowerGroupAnagrams(String[] strings) {
        /*
        * time complexity:
        * O(nmlogm)
        * where n is the total number of words
        * and m is the length of each word
        * mlogm when calculating the key
        * n when iterating the entire list
        * */
        HashMap<String, List<String>> ansMap = new HashMap<>();
        for (String string : strings) {
            String sorted = sortString(string);
            if (ansMap.get(sorted) == null) {
                LinkedList<String> currAnsList = new LinkedList<>();
                currAnsList.add(string);
                ansMap.put(sorted, currAnsList);
            } else {
                ansMap.get(sorted).add(string);
            }
        }
        return new LinkedList<>(ansMap.values());
    }
    public static String sortString(String str) {
        char[] res = str.toCharArray();
        Arrays.sort(res);
        return new String(res);
//        return String.valueOf(res); valueOf is new String()
    }
}
