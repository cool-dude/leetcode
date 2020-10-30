/*
* 589. N-ary Tree Preorder Traversal
Given an n-ary tree, return the preorder
* traversal of its nodes' values.

Nary-Tree input serialization is represented
* in their level order traversal, each group
* of children is separated by the null value (See examples).



Follow up:
Recursive solution is trivial, could you do it iteratively?
Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]

* Example 2:
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]*/
class Node {
    public int val;
    public List<Node> children;
    public boolean flag;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, boolean f, List<Node> _children) {
        val = _val;
        flag = f;
        children = _children;
    }
}
class Sln{
    public List<Integer> preorder(Node root){
        List<Integer> result=new ArrayList<Integer>();
        if(root==null){
            return result;
        }
        result.add(root.val);
        for(Node child:root.children){
            result.addAll(preorder(child));
        }
        return result;
    }
}

class Sln2{
    public List<Integer> postOrderWithFlag(Node root){
        List<Integer> res=new ArrayList<Integer>();
        if(root==null){
            return res;
        }
        for(Node child:root.children){
            res.addAll(postOrderWithFlag(child));
        }
        if(root.flag==true){
            res.add(root.val);
        }
        return res;
    }
}