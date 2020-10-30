class Node{
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value){
        this.key=key;
        this.value=value;
    }
}
class LRUCache {
    private HashMap<Integer, Node> map;
    private int capacity, count;
    private Node head, tail;
    public LRUCache(int cp) {
        capacity = cp;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count = 0;
    }
    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    public int get(int key) {
        if (map.get(key)!=null) {
            Node node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            System.out.println("Got the value : " +
                    result + " for the key: " + key);
            return result;
        }
        System.out.println("Did not get any value" +
                " for the key: " + key);
        return -1;
    }
    public void put(int key, int value) {
        System.out.println("Going to set the (key, "+
                "value) : (" + key + ", " + value + ")");
        if (map.get(key)!=null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }
        else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            }
            else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }
    }
}
/**Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);*/
/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
        import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
class Node{
    int k,v;
    Node prev,next;
    public Node(int k_,int v_){
        k=k_;
        v=v_;
    }
}
class Solution {
    Map<Integer,Node> map;
    int size,count;
    Node head,tail;
    public Solution(int sz){
        size=sz;
        map=new HashMap<>();
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
        head.prev=null;
        tail.next=null;
        count=2;
    }
    void deleteLoc(Node nd){
        nd.prev.next=nd.next;
        nd.next.prev=nd.prev;
        //delete(nd);
    }
    void addToHead(Node nd){
        nd.next=head.next;
        nd.next.prev=nd;
        nd.prev=head;
        head.next=nd;
    }
    public int get(int k_){
        if(map.get(k_)!=null){
            Node n=map.get(k_);
            deleteLoc(n);
            addToHead(n);
            return n.v;
        }
        else
            return -1;
    }
    void put(int k_,int v_){
        if(map.get(k_)!=null){
            Node n=map.get(k_);
            n.v=v_;
        }
        else{
            Node n=new Node(k_,v_);
            map.put(k_,n);
            if(count<size){
                count++;
            }
            else{
                System.out.println("LINE 70 key delete:"+tail.prev.k);
                map.remove(tail.prev.k);
                deleteLoc(tail.prev);
            }
            n.prev=tail.prev;
            n.next=tail;
            tail.prev=n;
        }
    }
    public static void main(String[] args) {
        Solution s=new Solution(5);
        s.put(1,1);
        s.put(2,2);
        s.put(3,3);
        System.out.println("3 val:"+s.get(3));
        System.out.println("2 val:"+s.get(2));
        System.out.println("1 val:"+s.get(1));
        s.put(4,4);
        System.out.println("3 val:"+s.get(3));
    }
}