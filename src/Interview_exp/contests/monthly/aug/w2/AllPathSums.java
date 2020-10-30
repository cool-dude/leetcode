/*LC112: Path Sum
https://leetcode.com/problems/path-sum/
Given a binary tree and a sum, determine
if the tree has a root-to-leaf path such
that adding up all the values along the path equals the given sum.
Note: A leaf is a node with no children.

Example:
Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
The basic idea is to subtract the value of current node from sum
until it reaches a leaf node and the subtraction equals 0,
then we know that we got a hit. Otherwise the subtraction at the end could not be 0.*/
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
class Sln1 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.left==null&&root.right==null) return sum==root.val;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
}
/*LC113: Path Sum II
Given a binary tree and a sum, find all
root-to-leaf paths where each path's sum equals the given sum.
Note: A leaf is a node with no children.
Example:
Given the below binary tree and sum = 22,
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:
[
   [5,4,11,2],
   [5,8,4,5]
]*/
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
class Sln2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>>ret = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        pathSum(root, sum, cur, ret);
        return ret;
    }
    void pathSumRec(TreeNode root, int sum, List<Integer>cur, List<List<Integer>>ret){
        if (root == null){
            return;
        }
        cur.add(root.val);
        if (root.left == null && root.right == null && root.val == sum){
            ret.add(new ArrayList(cur));
        }
        else{
            pathSumRec(root.left, sum - root.val, cur, ret);
            pathSumRec(root.right, sum - root.val, cur, ret);
        }
        cur.remove(cur.size()-1);
    }
}
/*LC437: Path Sum III
https://leetcode.com/problems/path-sum-iii/
You are given a binary tree in
which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the
root or a leaf, but it must go downwards
(traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the
values are in the range -1,000,000 to 1,000,000.
Example:
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1
Return 3. The paths that sum to 8 are:
1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11*/
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
 * }*
 * The prefix stores the sum from the root to the current node in the recursion
 * The map stores <prefix sum, frequency> pairs before getting to the current node.
 * We can imagine a path from the root to the current node. The sum from any node
 * in the middle of the path to the current node = the difference between the sum from the root to the current node and the prefix sum of the node in the middle.
 * We are looking for some consecutive nodes that sum up to the given target value,
 * which means the difference discussed in 2. should equal to the target value.
 * In addition, we need to know how many differences are equal to the target value.
 * Here comes the map. The map stores the frequency of all possible sum in the
 * path to the current node. If the difference between the current sum and the
 * target value exists in the map, there must exist a node in the middle of the path,
 * such that from this node to the current node, the sum is equal to the target value.
 * Note that there might be multiple nodes in the middle that satisfy what is discussed in 4. The frequency in the map is used to help with this.
 * Therefore, in each recursion, the map stores all information we need to
 * calculate the number of ranges that sum up to target. Note that each range starts from a middle node, ended by the current node.
 * To get the total number of path count, we add up the number of valid paths ended by EACH node in the tree.
 * Each recursion returns the total count of valid paths in the subtree rooted at the current node. And this sum can be divided into three parts:
 * - the total number of valid paths in the subtree rooted at the current node's left child
 * - the total number of valid paths in the subtree rooted at the current node's right child
 * - the number of valid paths ended by the current node*/
class Sln3 {
    int helper(TreeNode root,int curSum,int target,Map<Integer,Integer> preSum){
        if(root==null)
            return 0;
        curSum+=root.val;
        int res=preSum.getOrDefault(curSum-target,0);
        preSum.put(curSum,preSum.getOrDefault(curSum,0)+1);
        res+=helper(root.left,curSum,target,preSum)+helper(root.right,curSum,target,preSum);
        preSum.put(curSum,preSum.getOrDefault(curSum,0)-1);
        return res;
    }
    public int pathSum(TreeNode root, int sum) {
        Map<Integer,Integer> preSum=new HashMap<>();
        preSum.put(0,1);
        return helper(root,0,sum,preSum);
    }
}