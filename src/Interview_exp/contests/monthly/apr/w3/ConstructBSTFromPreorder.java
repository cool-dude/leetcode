/*
Return the root node of a binary search
tree that matches the given preorder traversal.
(Recall that a binary search tree is a binary
tree where for every node, any descendant of node.
left has a value < node.val, and any descendant of node.
right has a value > node.val.  Also recall that a preorder
 traversal displays the value of the node first,
 then traverses node.left, then traverses node.right.

Example 1:
Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int n=preorder.length;
        if(n==0) return null;

        TreeNode root=new TreeNode(preorder[0]);
        Deque<TreeNode> deque=new ArrayDeque<TreeNode>();
        deque.push(root);

        for(int i=1;i<n;i++){
            TreeNode node=deque.peek();
            TreeNode child=new TreeNode(preorder[i]);

            while (!deque.isEmpty() && deque.peek().val<child.val)
                node=deque.pop();

            if(node.val<child.val){
                node.right=child;
            }
            else {
                node.left=child;
            }
            // add the child into deque
            deque.push(child);
        }
        return root;
    }
}