package study.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    public static List<List<TreeNode>> levelOrder(TreeNode root) {
        List<List<TreeNode>> retObjList = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        retObjList.add(nodes);
        boolean flag = true;
        while (flag) {
            List<TreeNode> treeNodes = levelOrderRecursion(nodes);
            List<TreeNode> collect = treeNodes.stream().filter(Objects::nonNull).collect(Collectors.toList());
            if (collect.size() == 0) {
                flag = false;
            } else {
                retObjList.add(treeNodes);
                nodes = treeNodes;
            }
        }
        return retObjList;
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<TreeNode>> retObjList = levelOrder(root);
        List<List<Integer>> retList = new ArrayList<>();
        for (List<TreeNode> objs : retObjList) {
            List<Integer> vals = new ArrayList<>();
            for (TreeNode obj : objs) {
                if (Objects.nonNull(obj)) {
                    vals.add(obj.val);
                }
            }
            if (vals.size() > 0) {
                retList.add(vals);
            }
        }
        System.out.println(retList);
        return retList;
    }

    public static List<TreeNode> levelOrderRecursion(List<TreeNode> nodes) {
        List<TreeNode> retNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (Objects.nonNull(node)) {
                retNodes.add(node.left);
                retNodes.add(node.right);
            } else {
                retNodes.add(null);
                retNodes.add(null);
            }
        }
        return retNodes;
    }


    private static int answer;

    /**
     * 自顶向下
     *
     * @param root
     * @param depth
     */
    public static void preorderMaximumDepth(TreeNode root, int depth) {
        if (Objects.isNull(root)) {
            return;
        }
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            answer = Math.max(answer, depth);
        }
        preorderMaximumDepth(root.left, ++depth);
        preorderMaximumDepth(root.right, ++depth);
    }

    /**
     * 自底向上
     *
     * @param root
     */
    public static int postorderMaximumDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int left = postorderMaximumDepth(root.left);
        int right = postorderMaximumDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        // 最大深度
        int depth = postorderMaximumDepth(root);
        List<List<TreeNode>> nodeLists = levelOrder(root);
        for (int i = 0; i < depth; i++) {
            List<TreeNode> treeNodes = nodeLists.get(i);
            int size = treeNodes.size();
            int length = (int) Math.pow(2, i);
            for (int j = 0; j < length / 2; j++) {
                Integer first = treeNodes.get(j) == null ? null : treeNodes.get(j).val;
                int lastLength = length - j - 1;
                Integer last = size < lastLength ? null : (treeNodes.get(lastLength) == null ? null : treeNodes.get(lastLength).val);
                if (!Objects.equals(first, last)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * 叶子节点是指没有子节点的节点。
     *
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum = sum - root.val;
        if (root.left == null && root.right == null && sum == 0) {
            return true;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public static void main(String[] args) {
        // [1,2,2,3,3,null,null,4,4]
        System.out.println("[1,2,2,3,3,null,null,4,4]");
        TreeNode node = new TreeNode(1).init1();
        System.out.println("===========前序遍历===========");
        print(preorderTraversal(node));
        System.out.println("===========中序遍历===========");
        print(inorderTraversal(node));
        System.out.println("===========后序遍历===========");
        print(postorderTraversal(node));
        System.out.println("===========层序遍历===========");
        levelOrder2(node);
        System.out.println("===========自上而下获取最大深度===========");
        preorderMaximumDepth(node, 0);
        System.out.println("最大深度: " + answer);
        System.out.println("===========自下而上后获取最大深度===========");
        postorderMaximumDepth(node);
        System.out.println("最大深度: " + answer);
        System.out.println("===========判断是否是镜像对称===========");
        // [1,2,2,3,3,null,null,4,4]
        System.out.println("[1,2,2,3,3,null,null,4,4]");
        TreeNode node2 = new TreeNode(3).init2();
        System.out.println(isSymmetric(node2));
        System.out.println("===========叶子节点到根节点目标和===========");
        System.out.println("[5,4,8,11,null,13,4,7,2,null,1]    sum:22");
        TreeNode node3 = new TreeNode(5).init3();
        System.out.println(hasPathSum(node3, 22));
        System.out.println("[1,-2,-3,1,3,-2,null,-1]    sum:-1");
        TreeNode node4 = new TreeNode(1).init4();
        System.out.println(hasPathSum(node4, -1));
    }

    public static void print(List<Integer> list) {
        list.forEach(item -> {
            System.out.print(item + " ");
        });
        System.out.println();
    }

}


class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode init1() {
        this.left = new TreeNode(2);
        this.right = new TreeNode(2);
        this.left.left = new TreeNode(3);
        this.left.right = new TreeNode(3);
        this.left.left.left = new TreeNode(4);
        this.left.left.right = new TreeNode(4);
        return this;
    }

    TreeNode init2() {
        this.left = new TreeNode(4);
        this.right = new TreeNode(4);
        this.left.left = new TreeNode(5);
        this.right.right = new TreeNode(5);
        this.left.left.left = new TreeNode(6);
        this.right.right.right = new TreeNode(6);
        return this;
    }

    TreeNode init3() {
        this.left = new TreeNode(4);
        this.right = new TreeNode(8);
        this.left.left = new TreeNode(11);
        this.right.left = new TreeNode(13);
        this.right.right = new TreeNode(4);
        this.left.left.left = new TreeNode(7);
        this.left.left.right = new TreeNode(2);
        this.right.right.right = new TreeNode(1);
        return this;
    }

    TreeNode init4() {
        this.left = new TreeNode(-2);
        this.right = new TreeNode(-3);
        this.left.left = new TreeNode(1);
        this.left.right = new TreeNode(3);
        this.right.left = new TreeNode(-2);
        this.left.left.left = new TreeNode(-1);
        return this;
    }

}
