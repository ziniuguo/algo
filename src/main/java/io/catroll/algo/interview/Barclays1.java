package io.catroll.algo.interview;

import java.util.*;

public class Barclays1 {
    public static int[] interchange(int[] arr) {
        int[] answer = new int[100];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(0);
        }
        for (int i = 0; i < arr.length; i++) {
            list.set(arr[i], i);
        }
        System.out.println(list);
        Integer[] tempArray = list.toArray(new Integer[0]);

        // 创建一个 int[] 数组
        int[] intArray = new int[tempArray.length];

        // 遍历并将 Integer[] 数组中的元素转换为 int 类型
        for (int i = 0; i < tempArray.length; i++) {
            intArray[i] = tempArray[i];  // 自动拆箱
        }

        // 输出结果
        for (int i : intArray) {
            System.out.println(i);
        }

        return  answer;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 2, 0, 1};
        System.out.println(interchange(input));
    }
}
