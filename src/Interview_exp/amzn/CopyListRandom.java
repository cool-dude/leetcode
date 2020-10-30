/*https://www.geeksforgeeks.org/clone-linked-list-next-random-pointer-o1-space/*/
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;
    public Node(int v) {
        val = v;
        next = null;
        random = null;
    }
}
class Sln {
    public Node copyRandomList(Node head) {
        Node origCur=head;
        Node cloneCur=null;
        HashMap<Node,Node> map=new HashMap<Node,Node>();
        while(origCur!=null){
            cloneCur=new Node(origCur.val);
            map.put(origCur, cloneCur);
            origCur=origCur.next;
        }
        origCur=head;
        while(origCur!=null){
            cloneCur = map.get(origCur);
            cloneCur.next = map.get(origCur.next);
            cloneCur.random = map.get(origCur.random);
            origCur = origCur.next;
        }
        return map.get(head);
    }
}