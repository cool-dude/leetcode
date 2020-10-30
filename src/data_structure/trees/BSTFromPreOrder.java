/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }*/
/*approach is not optimal one because of \mathcal{O}(N \log N)O(NlogN) time complexity, but very straightforward.
    Let's use here two facts:

    Binary tree could be constructed from preorder and inorder traversal.

    Inorder traversal of BST is an array sorted in the ascending order.
 */
/**
 * Definition for a binary tree node.*/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Sln{
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        if (n == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.push(root);

        for (int i = 1; i < n; i++) {
            // take the last element of the deque as a parent
            // and create a child from the next preorder element
            TreeNode node = deque.peek();
            TreeNode child = new TreeNode(preorder[i]);
            // adjust the parent
            while (!deque.isEmpty() && deque.peek().val < child.val)
                node = deque.pop();

            // follow BST logic to create a parent-child link
            if (node.val < child.val) node.right = child;
            else node.left = child;
            // add the child into deque
            deque.push(child);
        }
        return root;
    }
}





/*
Array deques have no capacity restrictions,
they grow as necessary to support usage.
They are not thread-safe which means that in the
absence of external synchronization, ArrayDeque does
not support concurrent access by multiple threads.
Null elements are prohibited in the ArrayDeque.
ArrayDeque class is likely to be faster than Stack when used as a stack.
ArrayDeque class is likely to be faster than LinkedList when used as a queue.
* */
class Sln{
    public TreeNode bstFromPreOrder(int[] preorder){
        int n=preorder.length;
        if(n==0) return null;

        TreeNode root=new TreeNode(preorder[0]);
        Deque<TreeNode> deque=new ArrayDeque<TreeNode>();
        deque.push(root);

        for(int i=1;i<n;i++){
            TreeNode node=deque.peek();
            TreeNode child=preorder[i];

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
//T:O(N).
//S:O(N).