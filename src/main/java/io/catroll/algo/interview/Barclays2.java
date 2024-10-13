package io.catroll.algo.interview;

import java.lang.*;

/*
 *
 */
public class Barclays2
{
    /*
     *   strInput, representing a string of length N consisting of 0s and 1s only.
     */
    public static int  maxSignal(char[] strInput)
    {
        // Write your code here
        strInput = removeLeadingSameChars(strInput);
        int max = 0;
        int count = 1;
        for (int i=1; i < strInput.length; i++) {
            System.out.println((int) strInput[i] + " " + (int) strInput[i - 1]);
            if (strInput[i] == strInput[i - 1]) {
                count++;
                System.out.println("count:" + count);
            } else {
                if (count > max) {
                    max = count;
                }
                count = 1;
            }
        }
        return max;
    }

    public static char[] removeLeadingSameChars(char[] strInput) {
        if (strInput == null || strInput.length == 0) {
            return strInput;  // 如果输入为空，直接返回
        }

        // 找到第一个不同的字符的位置
        char firstChar = strInput[0];
        int index = 0;
        while (index < strInput.length && strInput[index] == firstChar) {
            index++;
        }

        // 如果所有字符都相同，则返回空数组
        if (index == strInput.length) {
            return new char[0];
        }

        // 创建一个新的数组，去掉最前面的相同字符
        char[] result = new char[strInput.length - index];
        System.arraycopy(strInput, index, result, 0, result.length);

        return result;
    }

    public static void main(String[] args){
        char[] strInput = new char[]{1, 0, 1, 0, 0, 0};
        int result = maxSignal(strInput);
        System.out.print(result);

    }
}