package leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liyh
 * @version 1.0.0
 * @title
 * @description 297.二叉树的序列化和反序列化
 * @date 2020/6/16 16:10
 */
public class Codec {

    /**
     * 你可以将以下二叉树：
     * <p>
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     * <p>
     * 序列化为 "[1,2,3,null,null,4,5]"
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[" + root.val);
        listTreeNodeChildren(Collections.singletonList(root), sb);
        while (sb.lastIndexOf("null") == sb.length() - "null".length()) {
            sb.delete(sb.length() - "null".length() - 1, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    private StringBuilder listTreeNodeChildren(List<TreeNode> children, StringBuilder sb) {
        List<TreeNode> childrenList = new ArrayList<>();
        children.forEach(item -> {
            if (item != null) {
                childrenList.add(item.left);
                sb.append(",").append(item.left == null ? "null" : item.left.val);
                childrenList.add(item.right);
                sb.append(",").append(item.right == null ? "null" : item.right.val);
            }
        });
        Set<TreeNode> childrenSet = new HashSet<>(childrenList);
        if (childrenSet.size() < 2 && childrenSet.contains(null)) {
            return sb;
        }
        listTreeNodeChildren(childrenList, sb);
        return sb;
    }

    public TreeNode deserialize(String data) {
        TreeNode root = null;
        String substring = data.substring(1, data.length() - 1);
        String[] split = substring.split(",");
        if (split.length < 2 && "".equals(split[0])) {
            return null;
        }
        root = new TreeNode(Integer.parseInt(split[0]));
        // 层数
        int count = 1;
        int num = split.length;
        int tempNum = num;
        while (tempNum != 1) {
            tempNum /= 2;
            count++;
        }
        TreeNode temp = root;
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        // 获得除最后一层的TreeNode
        for (int i = 0; i < count - 1; i++) {
            // 每层个数
            int lengthJ = (int) Math.pow(2, i);
            for (int j = 0; j < lengthJ * 2; j = j + 2) {
                int index = lengthJ * 2 + j - 1;
                if (num - 1 < index) {
                    continue;
                }
                if (!split[index].equals("null")) {
                    int left = Integer.parseInt(split[index]);
                    temp.left = new TreeNode(left);
                    treeNodes.add(temp.left);
                }
                if (num - 1 < index + 1) {
                    continue;
                }
                if (!split[index + 1].equals("null")) {
                    int right = Integer.parseInt(split[index + 1]);
                    temp.right = new TreeNode(right);
                    treeNodes.add(temp.right);
                }
                temp = treeNodes.get(lengthJ + j/2);
            }
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        Codec codec = new Codec();
        //System.out.println(codec.serialize(root));
        TreeNode root1 = new TreeNode(1).init();
        //System.out.println(codec.serialize(root1));
        //System.out.println(codec.serialize(codec.deserialize(serialize)));
        //codec.deserialize("[]");
        //System.out.println(codec.deserialize("[1,2]"));
        //System.out.println(codec.deserialize("[3,2,4,1]"));

        //1 3 null null 4
//        TreeNode tn = new TreeNode(1);
//        tn.left = new TreeNode(3);
//        tn.left.right = new TreeNode(4);
//        System.out.println(codec.serialize(tn));

        //[5,2,3,null,null,2,4,3,1]
        TreeNode tn = new TreeNode(5);
        tn.left = new TreeNode(2);
        tn.right = new TreeNode(3);
        tn.right.left = new TreeNode(2);
        tn.right.right = new TreeNode(4);
        tn.right.left.left = new TreeNode(3);
        tn.right.left.right = new TreeNode(1);
        System.out.println(codec.serialize(tn));
        TreeNode deserialize = codec.deserialize(codec.serialize(tn));
        System.out.println(codec.serialize(deserialize));
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode init() {
        this.left = new TreeNode(2);
        this.right = new TreeNode(3);
        this.right.left = new TreeNode(4);
        this.right.right = new TreeNode(5);
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
