/*LC98:Validate Binary Search Tree
* https://leetcode.com/problems/validate-binary-search-tree/
Given a binary tree, determine if
* it is a valid binary search tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes
* with keys less than the node's key.
The right subtree of a node contains only nodes
* with keys greater than the node's key.
Both the left and right subtrees must
* also be binary search trees.
Example 1:
    2
   / \
  1   3
Input: [2,1,3]
Output: true
Example 2:
    5
   / \
  1   4
     / \
    3   6
Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5
* but its right child's value is 4.*/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Sln {
    boolean helper(TreeNode node, int min,int max){
        if(node==null){
            return true;
        }
        else if(node.val>max || node.val<min){
            return false;
        }
        else return helper(node.left, min, node.val) &&
                    helper(node.right, node.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}