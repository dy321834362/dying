package sword_to_offer;

public class 二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        lowestCommonAncestor(root.right, p, q);
        if (leftNode != null && lowestCommonAncestor(root.right, p, q) != null) {
            return root;
        }
        if (leftNode != null) return leftNode;
        if (lowestCommonAncestor(root.right, p, q) != null) return lowestCommonAncestor(root.right, p, q);
        return null;
    }
}
