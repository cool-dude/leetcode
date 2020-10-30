// find LCA of all deepest leaves in a tree(can be a multiway tree)
// O(n) time (n is the num of nodes in tree), O(h) space
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Soln{
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        HashMap<Integer, Integer> heightMap = new HashMap<>();
        recursion(root,  heightMap);
        while (root != null) {
            int leftHeight = root.left == null ? 0 : heightMap.get(root.left.val);
            int rightHeight = root.right == null ? 0 : heightMap.get(root.right.val);
            if (leftHeight == rightHeight) return root;
            else if (leftHeight < rightHeight) root = root.right;
            else root = root.left;
        }
        return null;
    }
    public int recursion(TreeNode root,  HashMap<Integer, Integer> heightMap) {
        if (root == null) return 0;
        int leftHeight = recursion(root.left, heightMap);
        int rightHeight = recursion(root.right, heightMap);
        int maxHeight = Math.max(leftHeight, rightHeight) + 1;
        heightMap.put(root.val, maxHeight);
        return maxHeight;
    }
}