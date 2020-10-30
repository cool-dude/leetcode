/* Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }*/
class Solution {
    private void dfs(TreeNode node,int l, List<List<Integer>> results){
        if(l>=results.size()){
            List<Integer> newLevel=new ArrayList<Integer>();
            newLevel.add(node.val);
            results.add(newLevel);
        }
        else{
            if(l%2==0)
                results.get(l).add(node.val);
            else
                results.get(l).add(0, node.val);
        }
        if(node.left!=null) dfs(node.left, l+1, results);
        if(node.right!=null) dfs(node.right, l+1, results);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<List<Integer>>();
        List<List<Integer>> results=new ArrayList<List<Integer>>();
        dfs(root,0,results);
        return results;
    }
}