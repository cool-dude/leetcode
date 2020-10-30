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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null)
            return result;
        TreeNode cur=root;
        while(cur!=null){
            if(cur.left==null) {
                result.add(cur.val);
                cur=cur.right;
            }
            else{
                TreeNode prv=cur.left;
                while(prv.right!=null &&
                        prv.right!=cur){
                    prv=prv.right;
                }
                if(prv.right==null){
                    prv.right=cur;
                    cur=cur.left;
                }
                else{
                    prv.right=null;
                    result.add(cur.val);
                    cur=cur.right;
                }
            }
        }
        return result;
    }
}