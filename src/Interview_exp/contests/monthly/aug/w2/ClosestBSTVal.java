/*LC270: Closest Binary Search Tree Value
https://leetcode.com/problems/closest-binary-search-tree-value/
Given a non-empty binary search tree and a
target value, find the value in the BST
that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4*/
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
    public int closestValue(TreeNode root, double target) {
        int ret=root.val;
        while (root!=null){
            if(Math.abs(target-root.val)<Math.abs(target-ret)){
                ret=root.val;
            }
            root=root.val>target?root.left:root.right;
        }
        return ret;
    }
}