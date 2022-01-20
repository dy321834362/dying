package sword_to_offer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 二叉树中和为某一值的路径 {
    public static List<List<Integer>> pathSum1(TreeNode root, int target) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Deque<Integer> tmpList = new LinkedList<>();
        pathSum(root, target, tmpList, list);
        return list;

    }

    private static void pathSum(TreeNode root, int target, Deque<Integer> tmpList,
                                               List<List<Integer>> list) {
        if (root == null) return;
        tmpList.offerLast(root.val);
        if (root.left != null) {
            pathSum(root.left, target - root.val, tmpList, list);
        }
        if (root.right != null) {
            pathSum(root.right, target - root.val, tmpList, list);
        }
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                list.add(new LinkedList<>(tmpList));
            }
        }
        tmpList.removeLast();
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(11);
        TreeNode t5 = new TreeNode(13);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(2);
        TreeNode t9 = new TreeNode(5);
        TreeNode t10 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        t3.right = t6;
        t4.left = t7;
        t4.right = t8;
        t6.left = t9;
        t6.right = t10;
        System.out.println(pathSum1(t1, 22));
    }
}

