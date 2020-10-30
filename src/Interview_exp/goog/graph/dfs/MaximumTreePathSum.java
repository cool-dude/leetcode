/*LC124: Binary Tree Maximum Path Sum
* https://leetcode.com/problems/binary-tree-maximum-path-sum/
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any
* sequence of nodes from some starting node
* to any node in the tree along the parent-child c
* onnections. The path must contain at least
* one node and does not need to go through the root.
Example 1:
Input: [1,2,3]
       1
      / \
     2   3

Output: 6
Example 2:
Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7
Output: 42*/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Sln{
    class Res{
        public int val;
    }
    private int helper(TreeNode root, Res res){
        if(root==null) return 0;
        int l=helper(root.left, res);
        int r=helper(root.right, res);
        int max_single=Math.max(Math.max(l,r)+root.val, root.val);
        int max_top=Math.max(max_single, root.val+l+r);
        res.val = Math.max(res.val, max_top);
        return max_single;
    }
    public int maxPathSum(TreeNode root){
        Res res=new Res();
        res.val=Integer.MIN_VALUE;
        helper(root,r);
        return res.val;
    }
}