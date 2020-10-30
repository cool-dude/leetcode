/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode mergeLists(ListNode left, ListNode right) {
        ListNode result=null;
        if(left==null)
            return right;
        if(right==null)
            return left;
        if(left.val<=right.val){
            result=left;
            result.next=mergeLists(left.next,right);
        }
        else{
            result=right;
            result.next=mergeLists(left,right.next);
        }
        return result;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode sortList(ListNode head) {
        if (head ==null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode middleNext = middle.next;
        middle.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(middleNext);

        ListNode merged = mergeLists(left, right);
        return merged;
    }
}