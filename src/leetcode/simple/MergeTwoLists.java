package leetcode.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import leetcode.simple.entity.ListNode;

/**
 * leetcode-21 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author yonghua.li01@hand-china.com 2019/10/11 9:42
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        //输入：1->2->4, 1->3->4
        //输出：1->1->2->3->4->4
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(1, new ListNode(3));
        ListNode l4 = new ListNode(5);
        ListNode l5 = null;
        ListNode listNode = mergeTwoLists1(l4, l1);
        while (listNode != null) {
            System.out.println(listNode.getVal());
            listNode = listNode.getNext();
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        List<Integer> list = new ArrayList<>();
        while (l1 != null) {
            list.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            int index = 0;
            for (int i = 0; i < list.size(); i++) {
                if (l2.val > list.get(i)) {
                    index = i + 1;
                    continue;
                }
                break;
            }
            list.add(index, l2.val);
            l2 = l2.next;
        }
        ListNode listNode = new ListNode(list.get(0));
        if (list.size() == 1) {
            return listNode;
        }
        listNode.next = new ListNode(list.get(1));
        ListNode next = listNode.next;
        for (int i = 2; i < list.size(); i++) {
            next.next = new ListNode(list.get(i));
            next = next.next;
        }
        return listNode;
    }

    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

}
