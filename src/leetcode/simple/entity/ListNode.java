package leetcode.simple.entity;

/**
 * 单向有序链表
 *
 * @author yonghua.li01@hand-china.com 2019/10/11 9:43
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(){

    }

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
