'''
LC1192: Critical Connections in a Network
* https://leetcode.com/problems/critical-connections-in-a-network/
There are n servers numbered from 0 to n-1
* connected by undirected server-to-server
* connections forming a network where
* connections[i] = [a, b] represents a connection between servers a and b.
* Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to reach some other server.

Example 1:
Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted'''

'''
Define rank of a node: The depth of a 
node during a DFS. The starting node has a rank 0.

Only the nodes on the current DFS path have 
non-special ranks. In other words, only 
the nodes that we've started visiting, 
but haven't finished visiting, have ranks. So 0 <= rank < n.

(For coding purpose, if a node is not visited 
yet, it has a special rank -2; if we've 
fully completed the visit of a node, it has a special rank n.)

How can "rank" help us with removing cycles? 
Imagine you have a current path of length k 
during a DFS. The nodes on the path has increasing 
ranks from 0 to kand incrementing by 1. Surprisingly, 
your next visit finds a node that has a rank of 
p where 0 <= p < k. Why does it happen? Aha! 
You found a node that is on the current search path! 
That means, congratulations, you found a cycle!

But only the current level of search knows it finds a cycle. 
How does the upper level of search knows, 
if you backtrack? Let's make use of the return 
value of DFS: dfs function returns the minimum 
rank it finds. During a step of search from node
 u to its neighbor v, if dfs(v) returns something 
 smaller than or equal to rank(u), then u knows 
 its neighbor v helped it to find a cycle back 
 to u or u's ancestor. So u knows it should discard 
 the edge (u, v) which is in a cycle.

After doing dfs on all nodes, all edges in 
cycles are discarded. So the remaining edges are critical connections.'''
import collections


class Sln(object):
    def critical_coonnections(self, n, connections):
        def make_graph(connections):
            graph = collections.defaultdict(list)
            for con in connections:
                graph[con[0]].append(con[1])
                graph[con[1]].append(con[0])
            return graph

        graph = make_graph(connections)
        connections = set(map(tuple, (map(sorted, connections))))
        rank = [-2]*n

        def dfs(node, depth):
            if rank[node] >= 0:
                return rank[node]
            rank[node] = depth
            min_back_depth = n
            for nbr in graph[node]:
                if rank[nbr] == depth-1:
                    continue  # don't immediately go back.
                back_depth=dfs(nbr, depth+1)
                if back_depth <= depth:
                    connections.discard(tuple(sorted(node, nbr)))
                min_back_depth = min(min_back_depth, nbr)
            rank[node] = n
            return min_back_depth

        dfs(0, 0)
        return list(connections)