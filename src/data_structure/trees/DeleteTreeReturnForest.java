/*
* LC1110: Delete Nodes And Return Forest

* Given the root of a binary tree,
* each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete,
* we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.
* You may return the result in any order.

Example 1:
Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]*/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Sln{
    boolean[] isTarget=new boolean[1001];
    List<TreeNode> result;
    private void visit(TreeNode node, boolean isRoot){
        if(node==null) return;
        if(isRoot && !isTarget[node.val]){
            result.add(node);
        }
        visit(node.left, isTarget[node.val]);
        visit(node.right, isTarget[node.val]);

        if(node.left!=null && isTarget[node.left.val]) node.left=null;
        if(node.right!=null && isTarget[node.right.val]) node.right=null;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_del) {
        result=new ArrayList<TreeNode>();
        if(root==null) return null;
        for(int td:to_del){
            isTarget[td]=true;
        }
        visit(root, true);
        return result;
    }
}