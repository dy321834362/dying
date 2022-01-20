package Test1;

public class 第几栋高楼 {
    public int[] findBuilding (int[] heights) {
        // write code here
        int[] counts = new int[heights.length];
        int count = 1;
        int left = 0;
        int right = 0;
        for (int i = 0; i < heights.length; i++) {
            left = i-1;
            right = i+1;
            int max = 0;
            if (left>=0)max = heights[left];
            while (left >= 0) {
                if (left == i - 1) {
                    count++;
                } else {
                    if (heights[left] > max){
                        count++;
                        max = heights[left];
                    }
                }
                left--;
            }
            if (right <= heights.length-1)max = heights[right];
            while (right <= heights.length-1) {
                if (right == i + 1) {
                    count++;
                } else {
                    if (heights[right] > max){
                        count++;
                        max = heights[right];
                    }
                }
                right++;
            }
            counts[i] = count;
            count = 1;
        }
        return counts;
    }

    public static int[] findBuilding2 (int[] heights) {
        if (heights.length == 1)return new int[]{1};
        int[] counts = new int[heights.length];
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        left[0] = 0;
        for (int i = 1; i < left.length; i++) {
            int tmp = i-1;
            while (tmp>=0) {
                if (heights[tmp] > heights[i]) {
                    left[i] = left[tmp]+1;
                    break;
                } else if (heights[i] == heights[tmp]) {
                    left[i] = left[tmp];
                    break;
                }else {
                    tmp--;
                }
            }
        }
        right[right.length-1] = 0;
        for (int i = right.length-2; i >= 0; i--) {
            int tmp = i+1;
            while (tmp <= right.length-1) {
                if (heights[tmp] > heights[i]) {
                    right[i] = right[tmp]+1;
                    break;
                } else if (heights[i] == heights[tmp]) {
                    right[i] = right[tmp];
                    break;
                }else {
                    tmp++;
                }
            }
        }
        for (int i = 0; i < counts.length; i++) {
            if (i == 0) counts[i] = right[1]+2;
            else if (i == counts.length - 1) counts[i] = left[counts.length-2]+2;
            else counts[i] = 3 + left[i-1] + right[i+1];
        }
        return counts;
    }

    public static void main(String[] args) {
        int[] building2 = findBuilding2(new int[]{5, 3, 8, 3, 2, 5});
        for (int i = 0; i < building2.length; i++) {
            System.out.print(building2[i]+"---");
        }
    }



}
