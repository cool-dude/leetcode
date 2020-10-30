/*Given an integer K and a linked list in which
each node stores a single character.The task is
to join every K consecutive nodes of the linked
list to form a single word. Finally, print the
string obtained by joining these words (space separated).

Examples:
Input: List = ‘a’ -> ‘b’ -> ‘c’ ->’d’ -> ‘e’ -> NULL, k = 3
Output: abc de
The first three nodes form the first word “abc”
and next two nodes form the second word “de”.*/
class Node{
    int val;
    Node next;
}
class Sln{
    public String findWordString(Node head,int k){
        String ans="";
        int cnt=0;
        String word="";
        while (head){
            if(cnt==k){
                if(ans!=""){
                    ans+=" ";
                }
                ans+=word;
                word="";
                cnt=0;
            }
            word+=head.val;
            cnt++;
            head=head.next;
        }
        if(ans!=" ")
            ans+=" ";
        ans+=word;
        return ans;
    }
    //T:O(n).
    //S:O(1).
}