/*Given a binary tree,
you need to compute the length of the
diameter of the tree. The diameter of a
binary tree is the length of the longest
path between any two nodes in a tree.
This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the
path [4,2,1,3] or [5,2,1,3]. */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int md=-1;
    int height(TreeNode node){
        if(node==null)
            return 0;
        int lh=height(node.left);
        int rh=height(node.right);
        int d=lh+rh;
        md=Math.max(md,d);
        return 1+Math.max(lh,rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int h=height(root);
        return md;
    }
}