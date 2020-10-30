/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode reverseList(ListNode head){
        ListNode prev=null,cur=head;
        while(cur!=null){
            ListNode tmp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=tmp;
        }
        return prev;
    }

    private ListNode endFirstHalf(ListNode head){
        ListNode fst=head;
        ListNode slw=head;
        while(fst.next!=null && fst.next.next!=null){
            fst=fst.next.next;
            slw=slw.next;
        }
        return slw;
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        ListNode fst=endFirstHalf(head);
        ListNode scd=reverseList(fst.next);

        ListNode p1=head,p2=scd;
        boolean result=true;
        while(result && p2!=null){
            if(p1.val!=p2.val) result=false;
            p1=p1.next;
            p2=p2.next;
        }
        fst.next=reverseList(scd);
        return result;
    }
}