package sword_to_offer;

import java.util.*;
import java.util.stream.Collectors;

public class 二叉树之字形打印 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);
        root.left = t1;
        root.right = t2;
        t2.left = t3;
        t2.right = t4;
        List<List<Integer>> lists = levelOrder(root);
        List<Integer> collect = lists.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
        System.out.println(lists);
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        queue.add(root);
        boolean b = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode cur = queue.poll();
                if(b) {
                    tmp.addLast(cur.val);
                } else {
                    tmp.addFirst(cur.val);
                }
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            b = !b;
            list.add(tmp);
        }
        return list;
    }


}
