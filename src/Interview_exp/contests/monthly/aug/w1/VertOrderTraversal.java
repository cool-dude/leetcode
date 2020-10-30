/*LC987: Vertical Order Traversal of a Binary Tree
https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
Given a binary tree, return the vertical order
traversal of its nodes values.

For each node at position (X, Y), its left and
right children respectively will be at positions
(X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to
X = +infinity, whenever the vertical line
touches some nodes, we report the values of
the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position,
then the value of the node that is reported
first is the value that is smaller.

Return an list of non-empty reports in
order of X coordinate.  Every report will
have a list of values of nodes.

Example 1:
Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).

Example 2:
Input: [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.

Note:
The tree will have between 1 and 1000 nodes.
Each node's value will be between 0 and 1000.*/
/**Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }*/
class Sln {
    //This is EXACT SAME as https://leetcode.com/problems/binary-tree-vertical-order-traversal/
    //Just that we need to sort two numbers if they are on same level based on
    // 1. Depth and 2.Smaller number first(if depth same)
    class NodeInfo{
        private TreeNode node;
        private int level; //Vertical Level (left decreasing. right increating)
        private int depth; //Horizontal distancde from root (top to bottom increasing)
        public NodeInfo(TreeNode _node, int _level, int _depth){
            this.node = _node;
            this.level = _level;
            this.depth = _depth;
        }
    }
    /***The map already stores the list in the way of {LevelNumber,List}. Hence, level number is already taken care of.
     Now, within a list, we need to care about two things
     1. Depth should be in ascending order
     2. If depth is same, make sure the lower number is first**/
    public class NodeInfoComparator implements Comparator<NodeInfo> {
        public int compare(NodeInfo n1, NodeInfo n2){
            if(n1.depth < n2.depth) return -1;
            if(n1.depth > n2.depth) return 1;
            else return n1.node.val - n2.node.val;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;
        //Map to Store lists for each level number {levelNumber,List}
        Map<Integer,List<NodeInfo>> map = new TreeMap();
        //Queue is used for doing BFS on the binary tree
        Queue<NodeInfo> queue = new LinkedList();
        //Adding details level and depth in NodeInfo object so that it can be used to sort later
        queue.add(new NodeInfo(root,0,0));
        //Traverse the entire binary tree and keep adding the NodeInfo objects to corresponding levelNumber in map
        while (!queue.isEmpty() ) {
            NodeInfo n =  queue.remove();
            List<NodeInfo> list = map.getOrDefault(n.level,new ArrayList());
            list.add(n);
            map.put(n.level,list);
            // add child nodes of the current level in the queue for the next level
            if (n.node.left != null) queue.add(new NodeInfo(n.node.left,n.level-1,n.depth+1));
            if (n.node.right != null) queue.add(new NodeInfo(n.node.right,n.level+1,n.depth+1));
        }
        //Iterate over each level number in map
        map.forEach((levelNumber,list)->{
            //Sorting the list based on the criteria specified below
            Collections.sort(list,new NodeInfoComparator());
            //Add all the nodes for current level
            List<Integer> currLevel = new ArrayList(list.size());
            for(NodeInfo n: list){
                currLevel.add(n.node.val);
            }
            //Adding the current level to the final result
            levels.add(currLevel);
        });
        return levels;
    }
}