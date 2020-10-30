/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dum=new ListNode(-1);
        dum.next=head;
        ListNode prv=dum;

        while(head!=null&&head.next!=null){
            ListNode fst=head;
            ListNode scd=head.next;

            prv.next=scd;
            fst.next=scd.next;
            scd.next=fst;

            prv=fst;
            head=fst.next;
        }
        return dum.next;
    }
}