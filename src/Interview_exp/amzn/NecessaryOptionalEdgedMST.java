/*Given a weighted undirected graph with V vertices,
E edges, each of cost C, find which edges appear in
all minimum spanning trees and which ones appear only
in some minimum spanning trees. The necessary edges
will be printed first, followed by the non-necassary
ones. (in the same order as they appear in the input)
Input:
5 7 // 5 vertices, 7 edges
1 2 1 // First edge, from node 1 to node 2, with cost 1
2 3 1
3 4 2
4 1 2
1 5 3
4 5 3
2 5 6
Output:
// Edges that appear in all minimum spanning trees
1 2
2 3
// Edges that appear in some minimum spanning trees
3 4
4 1
1 5
4 5*/
If we observe carefully, the optional edges are
the ones that have same weight and connects
same disjoint sets. We can use Kruskal's
algorithm for building minimum spanning tree &
Union Find for detecting cycles. When we detect
cycles using Union Find, we can check for all the
edges having same weight and connecting same disjoint set.
Such edges can be put in optional edges, else in nonOptional.
Example on above graph -
First sort all the edges by weight, the ones with
same weight can be sorted by order in which they
appear input. (above input is already sorted)
Initially each vertex is one disjoint set = [[1],[2],[3],[4],[5]],
optional edges = [], non Optional edges = []
Process all the edges of same weight together.

weight = 1.
Edge = [1,2]. (it connects disjoint sets [1] and [2])
Edge = [2,3] (it connects disjoint sets [2] and [3])
Since both edges of weight 1 connects different disjoint sets, add both in non Optional edges.
Disjoint sets after step 1 = [[1,2,3],[4][5]]
weight = 2
Edge = [3,4] (it connects disjoint sets [1,2,3] and [4])
Edge = [4,1] ( it also connects disjoint sets [1,2,3] and [4]]
Since both edges of weight 2 connects same disjoint sets, add both in optional edges.
Disjoint sets after step 2 = [[1,2,3,4],[5]]
weight = 3
Edge = [1,5] (it connects disjoint sets [1,2,3,4] and [5])
Edge = [4,5] ( it also connects disjoint sets [1,2,3,4] and [5]]
Since both edges of weight 3 connects same disjoint sets, add both in optional edges.
Disjoint sets after step 3 = [[1,2,3,4,5]]
Since now there is only 1 disjoint set, which means we have build the minimum spanning
tree and all the vertices are connected !!