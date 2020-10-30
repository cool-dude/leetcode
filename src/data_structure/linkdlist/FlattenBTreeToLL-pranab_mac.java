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
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = flattenAndGetTail(root);
    }
    // flat a sub node and return the last element
    private TreeNode flattenGetTail(TreeNode root) {
        if (root == null)
            return null;
        // root has two chidren
        if (root.left != null && root.right != null) {
            // first, flatten left child and get the tail
            TreeNode leftTail = flattenGetTail(root.left);
            // append right child to the tail of the flat left child
            leftTail.right = root.right;
            // flatten the right child and save the tail of flat right child
            TreeNode rightTail = flattenGetTail(root.right);
            // now, left child is flatten and is appended by the flat right child; move left child to right
            root.right = root.left;
            // set left child to null since left child is moved to the right
            root.left = null;
            // return the tail of right child for more append
            return rightTail;
        }
        // root only has left child
        else if (root.left != null) {
            // flatten left child
            TreeNode leftTail = flattenGetTail(root.left);
            // move left to right
            root.right = root.left;
            root.left = null;
            // return the tail
            return leftTail;
        }
        // root only has right child
        else if (root.right != null) {
            // just flat the right child and return its tail
            TreeNode rightTail = flattenGetTail(root.right);
            return rightTail;
        }
        // root has no child, return itself as the tail node
        return root;
    }
}