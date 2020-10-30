/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dum = new ListNode(-1);
        dum.next = head;
        ListNode cur = head,prev=dum;

        while(cur!=null){
            if(cur.val==val) prev.next = cur.next;
            else prev = cur;
            cur = cur.next;
        }
        return dum.next;
    }
}