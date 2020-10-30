/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Soln {
    List<List<Integer>> result;

    private void checkSum(TreeNode node, int sum, List<Integer> list, int curSum) {
        if(node==null)
            return;
        curSum += node.val;
        list.add(node);
        if(curSum==sum && node.left==null && node.right==null){
            result.add(list);
        }
        checkSum(node.left, sum, list, curSum);
        checkSum(node.right, sum, list, curSum);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result=new ArrayList<>();
        if(root==null) return result;
        List<Integer> list=new ArrayList<>();
        checkSum(root,sum,list,0);
        return result;
    }
}