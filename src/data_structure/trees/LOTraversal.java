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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels=new ArrayList<>();
        if (root == null)
            return levels;

        // Do Level order traversal keeping
        // track of number of nodes at every level
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int l=0;
        while (!q.isEmpty()) {
            levels.add(new ArrayList<Integer>());
            int len=q.size();
            for(int i=0;i<len;i++){
                // Dequeue an node from queue
                TreeNode tn = q.remove();
                levels.get(l).add(tn.val);
                // Enqueue left and right children
                // of dequeued node
                if (tn.left != null) q.add(tn.left);
                if (tn.right != null) q.add(tn.right);
            }
            l++;
        }
        return levels;
    }
}