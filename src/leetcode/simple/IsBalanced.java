package leetcode.simple;

import leetcode.simple.IsBalanced.TreeNode;

import java.util.Objects;

/**
 * @author liyh
 * @version 1.0.0
 * @title
 * @description
 * @date 2020/8/17 15:11
 */
public class IsBalanced {

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1
     */


    public static boolean isBalanced(TreeNode root) {

        return false;
    }

    public static void count(TreeNode root, int count) {
        if (Objects.isNull(root)) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

    }

    public static void main(String[] args) {

    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

}
