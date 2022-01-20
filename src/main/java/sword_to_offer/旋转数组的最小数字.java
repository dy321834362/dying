package sword_to_offer;

public class 旋转数组的最小数字 {
    public static int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0)return -1;
        int start = 0;
        int end = numbers.length-1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (numbers[mid] > numbers[end]) {
                start = mid + 1;
            } else if(numbers[mid] < numbers[end]){
                end = mid;
            }else {
                end--;
            }
        }
        return numbers[start];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,1,3};
        int i = minArray(arr);
        System.out.println(i);
    }
}
