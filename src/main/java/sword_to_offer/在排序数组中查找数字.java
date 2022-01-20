package sword_to_offer;

public class 在排序数组中查找数字 {
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = (start+end)>>1;
        while (start <= end && target != nums[mid]) {
            if (target < nums[mid]) {
                end = mid - 1;
            }
            if (target > nums[mid]) {
                start = mid + 1;
            }
            mid = (start+end)/2;
        }
        if (start > end) {
            return 0;
        }
        int count = 0;
        int left = mid;
        int right = mid;
        while (left >= start && nums[left] == target ) {
            count++;
            left--;
        }
        while (right <= end && nums[right] == target) {
            count++;
            right++;
        }
        return count-1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,7,7,8,8,10};
        System.out.println(search(arr, 8));
    }
}
