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
        helper(root,res);
        return res.val;
    }
}