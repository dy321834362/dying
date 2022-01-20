package sword_to_offer;

public class 对称的二叉树 {
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null)return true;
//        return isSymmetric(root.left) && isSymmetric(root.right) &&
//                ((root.left == null && root.right == null) || root.left.val == root.right.val);
//
//    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        TreeNode treeNode1 = root.left;
        TreeNode treeNode2 = root.right;
        return isSymmetric(treeNode1, treeNode2);
    }

    private boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)return true;
        if (t1 == null || t2 == null)return false;
        if (t1.val != t2.val)return false;
        return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }

}
