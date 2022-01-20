package sword_to_offer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 把数组排成最小的数 {
    public static String minNumber(int[] nums) {
        List<String> collect = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.toList());
        Collections.sort(collect, (o1, o2) -> (o1+o2).compareTo(o2+o1)<0 ? -1 : 1);
        return collect.stream().reduce((a, b) -> a + b).get();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,30,34,5,9};
        System.out.println(minNumber(nums));

    }
}
