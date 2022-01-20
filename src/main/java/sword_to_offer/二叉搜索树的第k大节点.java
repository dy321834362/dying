package sword_to_offer;

public class 二叉搜索树的第k大节点 {
    int count = 0;
    TreeNode result = null;
    public int kthLargest(TreeNode root, int k) {
        if (root == null) return 0;
        count = k;
        kthLargest(root);
        return result.val;
    }

    private void kthLargest(TreeNode root) {
        if (root == null) return;
        kthLargest(root.right);
        if (--count == 0) {
            result = root;
            return;
        }
        kthLargest(root.left);
    }
}
