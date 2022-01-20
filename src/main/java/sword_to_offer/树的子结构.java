package sword_to_offer;

public class 树的子结构 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(0);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(-4);
        TreeNode t5 = new TreeNode(3);
        TreeNode s1 = new TreeNode(1);
        TreeNode s2 = new TreeNode(-4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        s1.left = s2;
        System.out.println(isSubStructure(t1, s1));
    }
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)return false;
        if (A.val == B.val ) {
            if (isSubTree(A, B)) {
                return true;
            }
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private static boolean isSubTree(TreeNode a, TreeNode b) {
        if (b == null)return true;
        if (a == null || a.val != b.val)return false;
        return isSubTree(a.left, b.left) && isSubTree(a.right, b.right);
    }

}
