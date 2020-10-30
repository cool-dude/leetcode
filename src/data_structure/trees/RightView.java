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
    static int max;
    private void helper(TreeNode node, int l,List<Integer> list){
        if(node==null)
            return;
        if(max<l){
            list.add(node.val);
            max=l;
        }
        helper(node.right,l+1,list);
        helper(node.left,l+1,list);
    }

    public List<Integer> rightSideView(TreeNode root) {
        max=0;
        List<Integer> result=new ArrayList<Integer>();
        helper(root,1,result);
        return result;
    }
}