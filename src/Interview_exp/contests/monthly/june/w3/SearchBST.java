/*Given the root node of a binary search tree (BST)
and a value. You need to find the node in the BST
that the node's value equals the given value. Return
the subtree rooted with that node. If such node doesn't
 exist, you should return NULL.

For example,
Given the tree:
        4
       / \
      2   7
     / \
    1   3
And the value to search: 2
You should return this subtree:
      2
     / \
    1   3*/
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
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root!=null && root.val!=val){
            root=val<root.val?root.left:root.right;
        }
        return root;
    }
}