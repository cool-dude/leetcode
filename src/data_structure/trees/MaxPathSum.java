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
    static class Result{
        public int val;
    }

    private int findMaxUtil(TreeNode node,Result res){
        if(node==null)
            return 0;
        //l and r store
        //max sum going
        //through lft/right subtree
        int l = findMaxUtil(node.left,res);
        int r = findMaxUtil(node.right,res);

        // Max path for parent
        // call of root. This path
        // must include at-most
        // one child of root
        int max_single = Math.max(Math.max(l, r) + node.val, node.val);

        // Max Top represents the
        // sum when the Node under
        // consideration is the
        // root of the maxsum path
        // and no ancestors of
        // root are there in max sum path
        int max_top =Math.max(max_single,l + r + node.val);

        // Store the
        // Maximum Result.
        res.val = Math.max(res.val, max_top);

        return max_single;
    }

    public int maxPathSum(TreeNode root) {
        Result r = new Result();
        r.val = Integer.MIN_VALUE;

        // Compute and return result
        findMaxUtil(root, r);
        return r.val;
    }
}