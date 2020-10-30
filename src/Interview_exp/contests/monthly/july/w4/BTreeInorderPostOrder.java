/*LC106: Construct Binary Tree from
Inorder and Postorder Traversal
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
Given inorder and postorder traversal
of a tree, construct the binary tree.

Note:
You may assume that duplicates
do not exist in the tree.

For example, given
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7*/
/**Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }*/
class Sln {
    Map<Integer, Integer> map = new HashMap(); // can also make local and pass in fucntion calls.
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return constructTreeFromInPost(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }
    TreeNode constructTreeFromInPost(int[] inorder, int[] postorder, int start, int end, int index) {
        if (start > end) return null;
        TreeNode root = new TreeNode(postorder[index]);

        int inRootIndex = map.get(root.val);

        root.right = constructTreeFromInPost(inorder, postorder, inRootIndex + 1, end, index - 1);
        root.left = constructTreeFromInPost(inorder, postorder, start, inRootIndex - 1, index - (end - inRootIndex) - 1);
        return root;
    }
}