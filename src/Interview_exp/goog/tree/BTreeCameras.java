/*LC968: Binary Tree Cameras
https://leetcode.com/problems/binary-tree-cameras/
Given a binary tree, we install cameras on the nodes of the tree.
Each camera at a node can monitor its parent, itself, and its immediate children.
Calculate the minimum number of cameras needed to monitor all nodes of the tree.
Example 1:
Input: [0,0,null,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes if placed as shown.
Example 2:
Input: [0,0,null,0,null,0,null,null,0]
Output: 2
Explanation: At least two cameras are needed to monitor
all nodes of the tree. The above image shows one of the valid configurations of camera placement.*/
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
    int res=0;
    int dfs(TreeNode root) {
        if (root == null) return 2;
        int l = dfs(root.left), r = dfs(root.right);
        if (l == 0 || r == 0) {
            res++;
            return 1;
        }
        return l == 1 || r == 1 ? 2 : 0;
    }
    public int minCameraCover(TreeNode root) {
        return (dfs(root) < 1 ? 1 : 0) + res;
    }
}