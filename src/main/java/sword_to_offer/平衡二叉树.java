package sword_to_offer;

public class 平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        if (root == null)return true;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        if (!isBalanced(root.left) || !isBalanced(root.right)) return false;
        return true;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }


}
