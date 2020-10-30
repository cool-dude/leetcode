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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> op=new LinkedList<>();
        if (root == null)
            return op;
        LinkedList<TreeNode> st=new LinkedList<>();
        st.add(root);
        while(!st.isEmpty()){
            TreeNode node=st.pollLast();
            op.addFirst(node.val);
            if(node.left!=null){
                st.add(node.left);
            }
            if(node.right!=null){
                st.add(node.right);
            }
        }
        return op;
    }
}