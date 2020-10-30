/*LC21: Merge Two Sorted Lists
https://leetcode.com/problems/merge-two-sorted-lists/
Merge two sorted linked lists and return
it as a new sorted list. The new list
should be made by splicing together
the nodes of the first two lists.

Example:
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4*/
/**Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }*/
class Sln1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead=new ListNode(-1);
        ListNode prev=preHead;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                prev.next=l1;
                l1=l1.next;
            }
            else{
                prev.next=l2;
                l2=l2.next;
            }
            prev=prev.next;
        }
        prev.next=(l1==null? l2 : l1);
        return preHead.next;
    }
}
/*LC23: Merge k Sorted Lists
https://leetcode.com/problems/merge-k-sorted-lists/
You are given an array of k linked-lists lists,
each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted
linked-list and return it.
Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:
Input: lists = []
Output: []
Example 3:
Input: lists = [[]]
Output: []

Constraints:
k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.*/
class Sln2 {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> heap = new PriorityQueue<>(
                (a,b)-> Integer.compare(a.val,b.val));
        ListNode head = new ListNode(0), cur = head;
        for (ListNode node : lists)
            if (node != null)
                heap.offer(node);
        while (!heap.isEmpty()) {
            cur.next = heap.poll();
            cur = cur.next;
            if (cur.next != null) heap.offer(cur.next);
        }
        return head.next;
    }
}