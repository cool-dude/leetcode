/*LC1514: Path with Maximum Probability
https://leetcode.com/problems/path-with-maximum-probability/
You are given an undirected weighted graph
of n nodes (0-indexed), represented by an
edge list where edges[i] = [a, b] is an
undirected edge connecting the nodes a and
b with a probability of success of traversing
that edge succProb[i].
Given two nodes start and end, find the path
with the maximum probability of success to go
from start to end and return its success
probability.
If there is no path from start to end, return 0.
Your answer will be accepted if it differs from
the correct answer by at most 1e-5.
Example 1:
Input: n = 3, edges = [[0,1],[1,2],[0,2]],
succProb = [0.5,0.5,0.2], start = 0, end = 2
Output: 0.25000
Explanation: There are two paths from start to end,
one having a probability of success = 0.2 and
the other has 0.5 * 0.5 = 0.25.

Example 2:
Input: n = 3, edges = [[0,1],[1,2],[0,2]],
succProb = [0.5,0.5,0.3], start = 0, end = 2
Output: 0.30000

Example 3:
Input: n = 3, edges = [[0,1]],
succProb = [0.5], start = 0, end = 2
Output: 0.00000
Explanation: There is no path between 0 and 2.
Constraints:
2 <= n <= 10^4
0 <= start, end < n
start != end
0 <= a, b < n
a != b
0 <= succProb.length == edges.length <= 2*10^4
0 <= succProb[i] <= 1
There is at most one edge between every two nodes.
1.Markov Chain
2.Simply BFS, at every stage, you need to
remember 2 things: current node + current
probability at this node
3.One node can be reached from mulitple paths,
we cannot simply use a visited array or a set
to avoid repeatness.
4.What we can do is to record "best probability
so far for each node". Then add to queue for BFS only if:
it can make a better prob for this current node. */
class Sln{
    class State {
        int node;
        double prob;
        State(int _node, double _prob) {
            node = _node;
            prob = _prob;
        }
    }
    public double maxProbablity(int n, int[][] edges,
                                double[] succProb, int start, int end){
        Map<Integer,List<double[]>> map=new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int[] edge=edges[i];
            map.putifAbsent(edge[0],new ArrayList<>());
            map.putIfAbsent(edge[1],new ArrayList<>());
            map.get(edge[0]).add(new double[]{edge[1],succProb[i]});
            map.get(edge[1]).add(new double[]{edge[0],succProb[i]});
        }
        double[] probs=new double[n];
        Queue<State> queue=new LinkedList<>();
        queue.add(new State(start,1.0));
        while (!queue.isEmpty()){
            State st=queue.poll();
            int parent=st.node;
            double prob=st.prob;
            for(double[] child:map.getOrDefault(parent,new ArrayList<>())){
                //add to queue only if:it can make better choice
                if(probs[(int)child[0]]>=prob*child[1]) continue;
                queue.add(new State((int)child[0],prob*child[1]));
                probs[(int)child[0]]=prob*child[1];
            }
        }
        return probs[end];
    }
}