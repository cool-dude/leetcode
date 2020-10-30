/* Definition for a binary tree node.
        * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Soln {
    int md = -1;
    int height(Node node) {
        if (node == null)
            return 0;

        int lh = height(node.left);
        int rh = height(node.right);
        int d = lh + rh + 1;
        md = Math.max(md, d);
        return 1 + Math.max(lh, rh);
    }
    int diameter(Node node){
        int h=height(node);
        return md;
    }
}