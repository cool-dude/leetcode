/*LC2: Add Two Numbers
https://leetcode.com/problems/add-two-numbers/
You are given two non-empty linked lists
representing two non-negative integers.
The digits are stored in reverse order
and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain
any leading zero, except the number 0 itself.

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.*/
/**Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }*/
class Sln{
    static int carry=0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null){
            if(carry==0)
                return null;
            return new ListNode(carry);
        }
        int res=0;
        if(l1!=null){
            res+=l1.val;
            l1=l1.next;
        }
        if(l2!=null){
            res+=l2.val;
            l2=l2.next;
        }
        res = res + carry;
        carry = res/10;
        res = res%10;
        ListNode head = new ListNode(res);
        head.next = addTwoNumbers(l1,l2);
        return head;
    }
}