package sword_to_offer;

public class 二叉搜索树的后序遍历序列 {
    public static boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length-1);
    }
    private static boolean verifyPostorder(int[] postorder, int start, int end) {
        if (start >= end) return true;
        int firstBigger = end;
        for (int i = start; i < end; i++) {
            if (postorder[i] > postorder[end] && firstBigger == end) {
                firstBigger = i;
            }
            if (i > firstBigger && postorder[i] < postorder[end]) {
                return false;
            }
        }
        boolean left = verifyPostorder(postorder, start, firstBigger - 1);
        boolean right = verifyPostorder(postorder, firstBigger, end - 1);
        return left && right;

    }
    public static void main(String[] args) {
        int[] po = new int[]{1,2,5,10,6,9,4,3};
        System.out.println(verifyPostorder(po));;
    }
}
