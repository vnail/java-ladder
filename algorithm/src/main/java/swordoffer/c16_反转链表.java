package swordoffer;

import swordoffer.Standard.ListNode;
import swordoffer.Standard.stdOut;

/**
 * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 *
 * 【思路】
 *  在单链表的表头临时接入一个节点，然后进行尾插法操作。反转单链表。
 *
 */
public class c16_反转链表 {

    //迭代
    public ListNode reverseList4(ListNode head) {
        ListNode newList = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;
    }

    //递归
    public static  ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverseList3(next);
        next.next = head;
        return newHead;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode root = new ListNode(); //逻辑头节点
        root.next = null;
        ListNode next;
        while (head != null){
            next = head.next;
            head.next = root.next;
            root.next = head;
            head = next;
        }
        return root.next;
    }

    /**
     * 书上的方法
     * @param head
     * @return
     */
    private static ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode reverseHead = null;
        ListNode cur = head;    //当前结点
        ListNode pre = null;    //当前结点的前一个节点
            // pre = null, 因为反转后，head.next = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            if (next == null) {
                reverseHead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return reverseHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        stdOut.printList(head);
        head = reverseList(head);
        stdOut.printList(head);
        head = reverseList2(head);
        stdOut.printList(head);

        head = reverseList3(head);
        stdOut.printList(head);

        //当只有一个结点时
        ListNode head2 = new ListNode(1);
        stdOut.printList(head2);
        head = reverseList(head2);
        stdOut.printList(head2);
        head = reverseList2(head2);
        stdOut.printList(head2);
    }
}
