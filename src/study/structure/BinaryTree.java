package study.structure;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author liyh
 * @version 1.0.0
 * @title
 * @description 二叉树
 * @date 2020/8/17 17:39
 */
public class BinaryTree {

    /**
     * 前序遍历（根节点-》左子树-》右子树）
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversalRecursion(root, result);
        return result;
    }

    /**
     * 前序遍历递归
     *
     * @param root
     */
    public static void preorderTraversalRecursion(TreeNode root, List<Integer> result) {
        if (Objects.isNull(root)) {
            return;
        }
        result.add(root.val);
        preorderTraversalRecursion(root.left, result);
        preorderTraversalRecursion(root.right, result);
    }

    /**
     * 中序遍历(左子树 -》根节点 -》右子树)
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalRecursion(root, result);
        return result;
    }

    /**
     * 中序遍历递归
     *
     * @param root
     * @param result
     */
    public static void inorderTraversalRecursion(TreeNode root, List<Integer> result) {
        if (Objects.isNull(root)) {
            return;
        }
        inorderTraversalRecursion(root.left, result);
        result.add(root.val);
        inorderTraversalRecursion(root.right, result);
    }

    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversalRecursion(root, result);
        return result;
    }

    /**
     * 后序遍历递归
     *
     * @param root
     * @param result
     */
    public static void postorderTraversalRecursion(TreeNode root, List<Integer> result) {
        if (Objects.isNull(root)) {
            return;
        }
        postorderTraversalRecursion(root.left, result);
        postorderTraversalRecursion(root.right, result);
        result.add(root.val);
    }

    public static void print(List<Integer> list) {
        list.forEach(item -> {
            System.out.print(item + " ");
        });
        System.out.println();
    }

    public static void main(String[] args) {
        // [1,2,2,3,3,null,null,4,4]
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(3);
        node.left.left.left = new TreeNode(4);
        node.left.left.right = new TreeNode(4);
        System.out.println("===========前序遍历===========");
        print(preorderTraversal(node));
        System.out.println("===========中序遍历===========");
        print(inorderTraversal(node));
        System.out.println("===========后序遍历===========");
        print(postorderTraversal(node));
    }

}


class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
