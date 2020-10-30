/*LC297: Serialize and Deserialize Binary Tree
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
Serialization is the process of converting a data
structure or object into a sequence of bits so that
it can be stored in a file or memory buffer, or
transmitted across a network connection link to be
reconstructed later in the same or another computer
environment.

Design an algorithm to serialize and deserialize
binary tree. There is no restriction on how your
serialization/deserialization algorithm should work.
You just need to ensure that a binary tree can be
serialized to a string and this string can be
deserialized to the original tree structure.
Example:
You may serialize the following tree:
    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]*/
class Sln {
    public String serialize(TreeNode root) {
        return serial(new StringBuilder(), root).toString();
    }

    // Generate preorder string
    private StringBuilder serial(StringBuilder str, TreeNode root) {
        if (root == null) return str.append("#");
        str.append(root.val).append(",");
        serial(str, root.left).append(",");
        serial(str, root.right);
        return str;
    }

    public TreeNode deserialize(String data) {
        return deserial(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    // Use queue to simplify position move
    private TreeNode deserial(Queue<String> q) {
        String val = q.poll();
        if ("#".equals(val)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserial(q);
        root.right = deserial(q);
        return root;
    }
}