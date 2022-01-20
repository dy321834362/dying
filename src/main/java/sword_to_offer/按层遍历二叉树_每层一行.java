package sword_to_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 按层遍历二叉树_每层一行 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(new TreeNode(Integer.MAX_VALUE));
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        list.add(tmp);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
            if (cur.val != Integer.MAX_VALUE) {
                tmp.add(cur.val);
                continue;
            }
            if (!queue.isEmpty()) {
                queue.add(new TreeNode(Integer.MAX_VALUE));
                tmp = new ArrayList<>();
                list.add(tmp);
            }

        }
        return list;
    }
}
