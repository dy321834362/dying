package sword_to_offer;

public class 逆序对 {
    public static void main(String[] args) {
        int[] arr = new int[]{8,7,6,5,4,1};
        reversePairs(arr);
    }
    public static int reversePairs(int[] nums) {
        return reversePairs(nums, 0, nums.length-1);
    }

    private static int reversePairs(int[] nums, int start, int end) {
        if (start >= end)return 0;
        int mid = (start+end)/2;
        int count1 = reversePairs(nums, start, mid);
        int count2 = reversePairs(nums, mid+1, end);
        return merge(nums, start, mid, end) + count1 + count2;
    }

    private static int merge(int[] nums, int start, int mid, int end) {
        int[] tmp = new int[end-start+1];
        int count = 0;
        int left = start;
        int right = mid+1;
        int i = 0;
        while (left <= mid && right <= end) {
            if (nums[left] <= nums[right]) {
                tmp[i++] = nums[left++];
            } else {
                tmp[i++] = nums[right++];
                count += mid - left +1;
            }
        }
        while (left <= mid) {
            tmp[i++] = nums[left++];
        }
        while (right <= end) {
            tmp[i++] = nums[right++];
        }
        for (int j = 0; j < tmp.length; j++) {
            nums[start+j] = tmp[j];
        }
        return count;
    }
}
