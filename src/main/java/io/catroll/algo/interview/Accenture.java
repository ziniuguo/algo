package io.catroll.algo.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Accenture {
    public static long minTime1(List<Integer> batchSize, List<Integer> processingTime, List<Integer> numTasks) {
        java.lang.Object o;
//        int n = batchSize.size();
//        int min = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            int time =  processingTime.get(i) *( (int) Math.ceil((double) numTasks.get(i) / batchSize.get(i)) );
//            if (time > min) {
//                min = time;
//            }
//        }
//
//        return min;

        int n = batchSize.size();
        long minTime = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            long time = (long) processingTime.get(i) * (long) Math.ceil((double) numTasks.get(i) / batchSize.get(i));
            minTime = Math.max(minTime, time);
        }

        return minTime;
    }

    public static long minTime (List<Integer> processorTime, List<Integer> taskTime) {
        Collections.sort(taskTime);
        Collections.sort(processorTime);
        List<Integer> maxList = new ArrayList<>();

        return 0;

    }
}
