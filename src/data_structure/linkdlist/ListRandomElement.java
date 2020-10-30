/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode head;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head=head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        double rand=Math.random();
        if(rand==0) rand=1;
        double idx=0;
        int prev=0;

        ListNode fst=head;
        ListNode slw=head;
        while(fst!=null){
            fst = fst.next;
            idx += rand;
            if((int)idx > prev){
                prev=(int)idx;
                slw=slw.next;
            }
        }
        return slw.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */