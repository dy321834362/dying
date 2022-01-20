package sword_to_offer;

import java.sql.Array;
import java.util.*;
//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。

public class 最小时间差 {

    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");
        int minDifference = findMinDifference(timePoints);
    }
    public static int findMinDifference(List<String> timePoints) {
        List<Integer> transferTime = new ArrayList<>();
        for (String timePoint : timePoints) {
            transferTime.add(changeTimeToMin(timePoint));
        }
        transferTime.sort(new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }

        });
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < transferTime.size(); i++) {
            min = Math.min(min, Math.abs(transferTime.get(i)-transferTime.get(i-1)));
        }
        return Math.min(min, Math.abs(transferTime.get(0)+60*24-transferTime.get(transferTime.size()-1)));
    }

    public static int changeTimeToMin(String timePoint){
        String[] tmp = timePoint.split(":");
        return Integer.parseInt(tmp[0])*60+Integer.parseInt(tmp[1]);
    }
}
