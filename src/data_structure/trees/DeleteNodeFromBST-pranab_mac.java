package data_structure.trees;

import leetcode.TreeNode;
/**
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 * */
public class DeleteNodeFromBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteRec(root, key);
    }
    int minValue(TreeNode root) {
        int minv = root.val;
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }
    private TreeNode deleteRec(TreeNode root, int key) {
        if (root == null) return null;

        if (key > root.val)
            root.right = deleteRec(root.right, key);
        else if (key < root.val)
            root.left = deleteRec(root.left, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.val = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.val);
        }
        return root;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Soln{
    private int minValue(TreeNode root){
        int min=root.val;
        while (root.left!=null){
            min=root.left.val;
            root=root.left;
        }
        return min;
    }

    public TreeNode deleteNode(TreeNode root, int key){
        if(root==null) return null;

        if(key > root.val){
            root.right=deleteNode(root.right, key);
        }
        else if(key < root.val){
            root.left=deleteNode(root.left, key);
        }
        else{
            if(root.left==null) {
                return root.right;
            }
            else if(root.right==null) {
                return root.left;
            }
            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.val = minValue(root.right);
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.val);
        }
        return root;
    }
}