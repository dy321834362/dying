package sword_to_offer;

public class 二叉树的镜像 {
    public static void main(String[] args) {

    }
    public TreeNode mirrorTree(TreeNode root) {
        change(root);
        return root;
    }

    private void change(TreeNode root) {
        if (root == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        change(root.left);
        change(root.right);
    }
}
