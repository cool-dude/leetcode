/*Check If a String Is a Valid Sequence from
Root to Leaves Path in a Binary Tree
Given a binary tree where each path going from
the root to any leaf form a valid sequence,
check if a given string is a valid sequence in such binary tree.

We get the given string from the concatenation
of an array of integers arr and the concatenation
of all values of the nodes along a path results
in a sequence in the given binary tree.

Example 1:
Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
Output: true
Explanation:
The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
Other valid sequences are:
0 -> 1 -> 1 -> 0
0 -> 0 -> 0*/
/**
 * Definition for a binary tree node.
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
    boolean helper(TreeNode node, int[] arr,int idx){
        if(node==null)
            return false;
        else if(idx==arr.length-1){
            if(arr[idx]==node.val && node.left==null && node.right==null)
                return true;
        }
        else if(arr[idx]==node.val)
            return helper(node.left,arr, idx+1,) || helper(node.right,arr,idx+1);
        else return false;
    }
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return helper(root,arr,0);
    }
}