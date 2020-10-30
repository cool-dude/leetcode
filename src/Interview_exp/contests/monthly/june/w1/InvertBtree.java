/*Invert Binary Tree
Example:
Input:
    4
  /   \
 2      7
/ \    / \
1   3 6   9
Output:
4
/   \
7     2
/ \   / \
9   6 3   1*/
class Sln {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode t=root.left;
        root.left=root.right;
        root.right=t;
        return root;
    }
}