/*
* Given a source and a target node for
n-ary tree find the distance between them.
 consider the following n-ary tree -- You can
 use int or char for your tree (was easier to draw using characters)
    *             A
    *         /  /  \  \
    *       B   F   D   E
    *      / \      |   /|\
    *     K  J      G  C H I
    *    / \                \
    *   N   M                 L
    *
int getDistance(TreeNode source, TreeNode target) where TreeNode can be defined as:

class TreeNode {
    int key;         // or char key;
    TreeNode parent;
}
Having a parent will allow you
* to get to a solution without traversing entire tree.
Bonus: How would the solution be if the TreeNode was defined as below:

class TreeNode {
    int key;            // or char key;
    TreeNode[] children;
}
getDistance(A, G) ==> 2
getDistance(M, H) ==> 5
getDistance(C, L) ==> 3
getDistance(B, M) ==> 2*/
class Sln1{
    public static int findDist(TreeNode src, TreeNode dst) {
        final Map<TreeNode, Integer> parents = new HashMap<>();
        TreeNode current = src;
        int dist = 0;
        while (current != null) {
            parents.put(current, dist++);
            current = current.parent;
        }
        current = dst;
        dist = 0;
        while (!parents.containsKey(current)) {
            current = current.parent;
            dist++;
        }
        return parents.get(current) + dist;
    }
}

class TreeNode {
    int key;         // or char key;
    TreeNode parent;
    List<TreeNode> children;
}
class Sln2{
    public static int findDist(TreeNode root, TreeNode src, TreeNode dst) {
        TreeNode lca = findLCA(root, src, dst);
        return dist(lca, src, 0) + dist(lca, dst, 0);
    }
    static int dist(TreeNode p, TreeNode c, int h) {
        if (p == c) {
            return h;
        } else if (p == null) {
            return Integer.MAX_VALUE;
        }
        for (TreeNode n : p.children) {
            int d = dist(n, c, h + 1);
            if (d != Integer.MAX_VALUE) {
                return d;
            }
        }
        return Integer.MAX_VALUE;
    }
    static TreeNode findLCA(TreeNode root, TreeNode src, TreeNode dst) {
        if (root == src || root == dst || root == null) {
            return root;
        }
        TreeNode ans = null;
        for (TreeNode node : root.children) {
            TreeNode lca = findLCA(node, src, dst);
            if (lca == null) {
                continue;
            } else if (lca != src && lca != dst) {
                return node;
            } else if (lca == src || lca == dst) {
                if (ans == src || ans == dst) {
                    return root;
                } else {
                    ans = lca;
                }
            }
        }
        return ans;
    }
}