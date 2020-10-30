/*GRaph with straight and curved edges
You are given list of edges in graph
and for each pair of vertices that are
connected by edge, there are 2 edges
between them, one curved edge and one straight
edge i.e. the tuple (x, y, w1, w2) means
between vertices x and y, there is straight edge
with weight w1 and a curved edge with weight w2.
You are given two vertices a and b and you have
to go from a to b through a series of edges such
that in the entire path you can use at most 1 curved edge.
 Your task is to find the shortest path from a to b
 satisfying the above condition.*/
class Sln {
    class Node {
        int v;
        int w1;
        int w2;
        public Node(int v_, int w1_, int w2_) {
            v = v_;
            w1 = w1_;
            w2 = w2_;
        }
    }
    class QNode implements Comparable<QNode> {
        int qval;
        int curvCount;
        public QNode(int qv_, int cc_) {
            qval = qv_;
            curvCount = cc_;
        }
    }
    public int shortestPathCurvedEdge(int n, int[][] edges, int src, int dst) {
        Map<Integer, List<Node>> map = new HashMap<>();
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            int w1 = e[2];
            int w2 = e[3];
            map.putIfAbsent(x, new ArrayList<>());
            map.get(x).add(new Node(y, w1, w2));
        }
        int[][] shortestPath = new int[2][n + 1];
        Arrays.fill(shortestPath[0], Integer.MAX_VALUE);
        Arrays.fill(shortestPath[1], Integer.MAX_VALUE);
        boolean[][] visited = new boolean[2][n + 1];
        Queue<QNode> q = new Queue<>();
        shortestPath[0][src] = 0;
        shortestPath[1][src] = 0;
        q.add(new QNode(src, 0));
        q.add(new QNode(src, 1));
        while (!q.isEmpty()) {
            QNode qnode = q.poll();
            if (qnode.qval == dst) {
                return Math.min(shortestPath[0][dst], shortestPath[1][dst]);
            }
            if (qnode.curvCount == 0 && !visited[0][qnode.qval]) {
                visited[0][qnode.qval] = true;
                for (Node nbr : map.getOrDefault(qnode.qval, new ArrayList<Node>())) {
                    shortestPath[0][nbr.v] = Math.min(shortestPath[0][nbr.v], shortestPath[0][qnode.qval] + nbr.w1);
                    shortestPath[1][nbr.v] = Math.min(shortestPath[1][nbr.v], shortestPath[0][qnode.qval] + nbr.w2);
                    q.add(new QNode(nbr.v,0));
                    q.add(new QNode(nbr.v, 1));
                }
            }
            else if (qnode.curvCount == 1 && !visited[1][qnode.qval]) {
                visited[1][qnode.qval] = true;
                for (Node nbr : map.getOrDefault(qnode.qval, new ArrayList<Node>())) {
                    shortestPath[1][nbr.v] = Math.min(shortestPath[1][nbr.v], shortestPath[1][qnode.qval] + nbr.w2);
                    q.add(new QNode(nbr.v, 1));
                }
            }
        }
        return -1;
    }
}