/*LC1530: Number of Good Leaf Nodes Pairs
https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/
Given the root of a binary tree and an integer
distance. A pair of two different leaf nodes
of a binary tree is said to be good if the
length of the shortest path between them is
less than or equal to distance.
Return the number of good leaf node pairs in the tree.

Example 1:
Input: root = [1,2,3,null,4], distance = 3
Output: 1
Explanation: The leaf nodes of the tree are 3 and 4 a
nd the length of the shortest path between them is 3.
This is the only good pair.

Example 2:
Input: root = [1,2,3,4,5,6,7], distance = 3
Output: 2
Explanation: The good pairs are [4,5] and [6,7]
with shortest path = 2. The pair [4,6] is not
good because the length of ther shortest path
between them is 4.

Example 3:
Input: root = [7,1,4,6,null,5,3,null,null,null,null,null,2], distance = 3
Output: 1
Explanation: The only good pair is [2,5].

Example 4:
Input: root = [100], distance = 1
Output: 0

Example 5:
Input: root = [1,1,1], distance = 2
Output: 1
In above example , assume maximum distance = 4. So we maintain an array of size 4.

For root node 1,
left = [ 0,0,1,0,0]
right = [0,1,0,0,0]
Here, left[2] = 1, which denotes that there
is one leaf node with distance 2 in left
subtree of root node 1.
right[1] = 1, which denotes that there is
one leaf node with distance 1 in right subtree of root node 1.
In this way, we have to recursively,
calculate the left and right subtree of every root node.

Once we have both left and right arrays
for a particular root, we have to just
calculate total number of good node pairs
formed using result += left[l]*right[r];

Before we bactrack to parent, we have to
return the distance for parents by adding up
left and right subtrees of current node.
Note that we are doing - res[i+1] = left[i]+right[i];
The intution is that, if a leaf node is at
distance i from current node, it would be
at distance i+1 from its parent. Hence,
will building the res array, we are adding
sum in i+1 th position and return to parent.*/
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
    int result = 0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root,distance);
        return result;
    }
    int[] dfs(TreeNode root,int distance){
        if(root == null)
            return new int[distance+1];
        if(root.left == null && root.right == null){
            int res[] = new int[distance+1];
            res[1]++;
            return res;
        }
        int[] left = dfs(root.left,distance);
        int[] right = dfs(root.right,distance);
        for(int l=1;l<left.length;l++){
            for(int r = distance-1;r>=0;r--){
                if(l+r <=distance)
                    result += left[l]*right[r];
            }
        }
        int res[] = new int[distance+1];
        //shift by 1
        for(int i=res.length-2;i>=1;i--){
            res[i+1] = left[i]+right[i];
        }
        return res;
    }
}