package Binary_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 先序遍历 {
    //递归版
    public void xianxu(TreeNode root) {
        System.out.println(root.val);
        if (root.left != null) xianxu(root.left);
        if (root.right != null) xianxu(root.right);
    }
    //非递归
    public static List<Integer> xianxu1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            list.add(tmp.val);
            if (tmp.right != null) stack.push(tmp.right);
            if (tmp.left != null) stack.push(tmp.left);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        System.out.println(xianxu1(t1));
    }
}
