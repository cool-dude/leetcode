/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

class Solution {
    private ListNode reverse(ListNode prv, ListNode nxt){
        ListNode last=prv.next;
        ListNode cur=last.next;
        while (cur!=nxt){
            last.next=cur.next;
            cur.next=prv.next;
            prv.next=cur;
            cur=last.next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1)
            return head;
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode prev = fake;
        int i = 0;
        ListNode p = head;
        while (p!=null){
            i++;
            if(i%k==0){
                prev = reverse(prev, p.next);
                p = prev.next;
            }
            else{
                p = p.next;
            }
        }
        return fake.next;
    }
}


class Soln{
    private ListNode reverse(ListNode prv, ListNode nxt){
        ListNode last=prv.next;
        ListNode cur=last.next;
        while (cur!=nxt){
            last.next=cur.next;
            cur.next=prv.next;
            prv.next=cur;
            cur=last.next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k){
        if(head==null || k==1)
            return head;
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode prev = fake;
        int i = 0;
        ListNode p = head;
        while (p!=null){
            i++;
            if(i%k==0){
                prev = reverse(prev, p.next);
                p = prev.next;
            }
            else{
                p = p.next;
            }
        }
        return fake.next;
    }
}