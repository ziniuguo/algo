package io.catroll.algo.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tiktok {
    public static String getStoredWord(String word, int maxOp) {
        LinkedList<Character> charList = new LinkedList<>();
        for (char c = 'z'; c >= 'a'; c--) {charList.add(c);}
        List<Character> wordList = new ArrayList<>();
        for (char c : word.toCharArray()) {wordList.add(c);}

        int startingIndex = 0;
        int remaining = maxOp;
        char givenChar = wordList.get(startingIndex);
        while (remaining > 0) {
            int index = charList.indexOf(givenChar);
            List<Character> nextElements = charList.subList(index, Math.min(index + remaining + 1, charList.size())); // y x w
            char dest = nextElements.get(nextElements.size() - 1);
            for (int i = 0; i < wordList.size(); i++) {
                char curr = wordList.get(i);
                if (nextElements.contains(curr)) {
                    wordList.set(i, dest);
                }
            }
            remaining = remaining - nextElements.size() + 1;
            if (check(wordList)) {break;} else {
                char oldGivenChar = wordList.get(0);
                givenChar = wordList.get(0);
                while (givenChar == oldGivenChar) {
                    givenChar = wordList.get(startingIndex);
                    startingIndex ++;}
            }
        }

        StringBuilder stringBuilder = new StringBuilder(wordList.size());
        for (char c : wordList) {stringBuilder.append(c);}
        return stringBuilder.toString();
    }

    private static boolean check(List<Character> list) {
        for (char c : list) {if (c != 'a') {return false;}}
        return true;
    }


    public static void main(String[] args) {
        System.out.println(getStoredWord("cbbfabfd", 4));
    }


}
//abcdefghijklmnopqrstuvwxyz