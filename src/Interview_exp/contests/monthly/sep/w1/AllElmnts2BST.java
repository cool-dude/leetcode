/*LC1305: All Elements in Two Binary Search Trees
https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
Given two binary search trees root1 and root2.
Return a list containing all the integers from both trees sorted in ascending order.
Example 1:
Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]

Example 2:
Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]

Example 3:
Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]

Example 4:
Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]

Example 5:
Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]*/
/**Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }*/
class Sln {
    void inorder(TreeNode root,List<Integer> lst){
        if(root==null)
            return;
        inorder(root.left,lst);
        lst.add(root.val);
        inorder(root.right,lst);
    }
    List<Integer> mergeList(List<Integer> l1,List<Integer> l2){
        List<Integer> lst=new ArrayList<>();
        int i=0,j=0;
        while (i<l1.size() && j<l2.size()){
            if(l1.get(i)<l2.get(j)) lst.add(l1.get(i++));
            else lst.add(l2.get(j++));
        }
        while (i<l1.size()) lst.add(l1.get(i++));
        while (j<l2.size()) lst.add(l2.get(j++));
        return lst;
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1=new ArrayList<>();
        inorder(root1,l1);
        List<Integer> l2=new ArrayList<>();
        inorder(root2,l2);
        return mergeList(l1,l2);
    }
}