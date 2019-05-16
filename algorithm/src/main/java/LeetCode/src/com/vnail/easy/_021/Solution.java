package LeetCode.src.com.vnail.easy._021;

public class Solution {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }

    public ListNode mergeLists(ListNode l1,ListNode l2){
        ListNode head = new ListNode(0);
        ListNode temp = head;

        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp=temp.next;
        }

        temp.next = l1==null?l2:l1;

        return head.next;
    }
}
