/*LC684: Redundant Connection
https://leetcode.com/problems/redundant-connection/
In this problem, a tree is an undirected
graph that is connected and has no cycles.
The given input is a graph that started as a
tree with N nodes (with distinct values 1, 2, ..., N),
with one additional edge added. The added
edge has two different vertices chosen
from 1 to N, and was not an edge that already existed.
The resulting graph is given as a 2D-array
of edges. Each element of edges is a pair [u, v]
with u < v, that represents an undirected edge connecting nodes u and v.
Return an edge that can be removed so that
the resulting graph is a tree of N nodes.
If there are multiple answers, return the
answer that occurs last in the given 2D-array.
The answer edge [u, v] should be in the same format, with u < v.
Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
1
/ \
2 - 3
Example 2:
Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
|   |
4 - 3*/
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class Sln1{
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[20001];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }
        for(int[] ele:edges){
            int index1 = findparent(parent,ele[0]);
            int index2 = findparent(parent,ele[1]);
            if(index1==index2){
                return ele;
            }
            else{
                parent[index1] = index2;
            }
        }
        return new int[0];
    }
    int findparent(int[] parent,int index){
        while(index!=parent[index]){
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
}
/*LC685:Redundant Connection II
https://leetcode.com/problems/redundant-connection-ii/
In this problem, a rooted tree is a directed
graph such that, there is exactly one node
(the root) for which all other nodes are descendants
of this node, plus every node has exactly
one parent, except for the root node which has no parents.
The given input is a directed graph that started
as a rooted tree with N nodes (with distinct
values 1, 2, ..., N), with one additional directed
edge added. The added edge has two different
vertices chosen from 1 to N, and was not an edge that already existed.
The resulting graph is given as a 2D-array of edges.
Each element of edges is a pair [u, v] that
represents a directed edge connecting nodes
u and v, where u is a parent of child v.
Return an edge that can be removed so that the
resulting graph is a rooted tree of N nodes.
If there are multiple answers, return the
answer that occurs last in the given 2D-array.
Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given directed graph will be like this:
  1
 / \
v   v
2-->3
Example 2:
Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
Output: [4,1]
Explanation: The given directed graph will be like this:
5 <- 1 -> 2
     ^    |
     |    v
     4 <- 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between
1 and N, where N is the size of the input array.
Case 1: "c" is the only node which has 2 parents
and there is not path (c->...->b) which means
no cycle. In this case, removing either "e1" or
"e2" will make the tree valid. According to
the description of the problem, whichever
edge added later is the answer.

Case 2: "c" is the only node which has 2 parents
and there is a path(c->...->b) which means
there is a cycle. In this case, "e2" is the only
edge that should be removed. Removing "e1" will
make the tree in 2 separated groups. Note,
in input edges, "e1" may come after "e2".

Case 3: this is how it looks like if edge
(a->root) is added to the tree. Removing any
of the edges along the cycle will make the
tree valid. But according to the description
of the problem, the last edge added to complete
the cycle is the answer. Note: edge "e2" (an
edge pointing from a node outside of the cycle
to a node on the cycle) can never happen in this case,
because every node including root has exactly
one parent. If "e2" happens, that make a node
on cycle have 2 parents. That is impossible.

As we can see from the pictures, the answer must be:
one of the 2 edges that pointing to the same node in case 1 and case 2; there is one and only one such node which has 2 parents.
the last edge added to complete the cycle in case 3.
Note: both case 2 and case 3 have cycle, but in case 2, "e2" may not be the last edge added to complete the cycle.

Now, we can apply Disjoint Set (DS) to build the tree
in the order the edges are given. We define ds[i] as
the parent or ancestor of node i. It will become
the root of the whole tree eventually if edges does
not have extra edge. When given an edge (a->b),
we find node a's ancestor and assign it to ds[b].
Note, in typical DS, we also need to find node b's
ancestor and assign a's ancestor as the ancestor of
b's ancestor. But in this case, we don't have to,
since we skip the second parent edge (see below), it is guaranteed a is the only parent of b.

If we find an edge pointing to a node that already
has a parent, we simply skip it. The edge skipped
can be "e1" or "e2" in case 1 and case 2. In case 1,
removing either "e1" or "e2" will make the tree valid.
In case 3, removing "e2" will make the tree valid,
but removing "e1" will make the tree in 2 separated groups and one of the groups has a cycle. In case 3, none of the edges will be skipped because there is no 2 edges pointing to the same node. The result is a graph with cycle and "n" edges.

How to detect cycle by using Disjoint Set (Union Find)?
When we join 2 nodes by edge (a->b), we check a's ancestor,
if it is b, we find a cycle! When we find a cycle,
 we don't assign a's ancestor as b's ancestor.
 That will trap our code in endless loop. We need to
 save the edge though since it might be the answer in case 3.

Now the code. We define two variables (first and second)
to store the 2 edges that point to the same node if
there is any (there may not be such edges, see case 3).
 We skip adding second to tree. first and second hold
 the values of the original index in input edges of the
 2 edges respectively. Variable last is the edge added
 to complete a cycle if there is any (there may not
 be a cycle, see case 1 and removing "e2" in case 2).
 And it too hold the original index in input edges.

After adding all except at most one edges to the tree,
we end up with 4 different scenario:

case 1 with either "e1" or "e2" removed. Either way,
the result tree is valid. The answer is the edge
being removed or skipped (a.k.a. second)
case 2 with "e2" removed. The result tree is valid.
The answer is the edge being removed or skipped (a.k.a. second)
case 2 with "e1" removed. The result tree is
invalid with a cycle in one of the groups.
The answer is the other edge (first) that points
to the same node as second.
case 3 with no edge removed. The result tree is
invalid with a cycle. The answer is the last edge
added to complete the cycle.
In the following code,
last == -1 means "no cycle found" which is scenario 1 or 2
second != -1 && last != -1 means "one edge removed and the result tree has cycle" which is scenario 3
second == -1 means "no edge skipped or removed" which is scenario 4*/
class Sln2 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] can1 = {-1, -1};
        int[] can2 = {-1, -1};
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            if (parent[edges[i][1]] == 0) {
                parent[edges[i][1]] = edges[i][0];
            }
            else {
                can2 = new int[] {edges[i][0], edges[i][1]};
                can1 = new int[] {parent[edges[i][0]], edges[i][1]};
                edges[i][1] = 0;
            }
        }
        for (int i = 0; i < edges.length; i++)
            parent[i] = i;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][1] == 0) {
                continue;
            }
            int child = edges[i][1], father = edges[i][0];
            if (root(parent, father) == child) {
                if (can1[0] == -1) {
                    return edges[i];
                }
                return can1;
            }
            parent[child] = father;
        }
        return can2;
    }
    int root(int[] parent, int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}