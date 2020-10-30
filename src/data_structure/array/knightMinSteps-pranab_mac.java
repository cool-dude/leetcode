class GFG {
    // Class for storing
    // a cell's data
    static class cell {
        int x, y, d;
        public cell(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    // Utility method
    // returns true if (x, y) lies
    // inside Board
    static boolean isInside(int x, int y, int N) {
        if (x >= 1 && x <= N && y >= 1 && y <= N)
            return true;
        return false;
    }

    // Method returns minimum step
    // to reach target position
    static int minStepToReachTarget(int knightPos[], int targetPos[],
                                    int N){
        // x and y direction, where a knight can move
        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};

        // queue for storing states of knight in board
        Queue<cell> q = new LinkedList<>();
        // push starting position of knight with 0 distance
        q.add(new cell(knightPos[0], knightPos[1], 0));
        cell t;
        int x, y;
        boolean visit[][] = new boolean[N + 1][N + 1];

        // make all cell unvisited
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                visit[i][j] = false;

        // visit starting state
        visit[knightPos[0]][knightPos[1]] = true;
        // loop untill we have one element in queue
        while (!q.isEmpty()) {
            t = q.front();
            q.remove(0);

            // if current cell is equal to target cell,
            // return its distance
            if (t.x == targetPos[0] && t.y == targetPos[1])
                return t.d;

            // loop for all reachable states
            for (int i = 0; i < 8; i++) {
                x = t.x + dx[i];
                y = t.y + dy[i];

                // If reachable state is not yet visited and
                // inside board, push that state into queue
                if (isInside(x, y, N) && !visit[x][y]) {
                    visit[x][y] = true;
                    q.add(new cell(x, y, t.d + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    // Driver code
    public static void main(String[] args) {
            int N = 30;
        int knightPos[] = {1, 1};
        int targetPos[] = {30, 30};
        System.out.println(minStepToReachTarget(knightPos, targetPos, N));
    }
}

class Solution {
    public int minKnightMoves(int x, int y) {
        int[][] dirs = new int[][]
                {{2,1}, {2, -1}, {-2,1}, {-2, -1},  {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};
        int[] start = new int[]{0,0};
        int[] target = new int[]{x, y};
        int distTarget = dist(start, target) + 6;

        Queue<int[]> q = new LinkedList<>();
        HashSet<String> v = new HashSet<>();
        q.offer(start);

        int ans = 0;
        while(!q.isEmpty()){
            int qs = q.size();
            for(int i=0;i<qs;i++){
                int[] cur = q.poll();
                if(cur[0] == target[0] && cur[1]==target[1]){
                    return ans;
                }
                for(int d=0;d<8;d++){
                    int[] nd = new int[]{cur[0] + dirs[d][0], cur[1] + dirs[d][1]};
                    String key = nd[0] + "_" + nd[1];
                    if(v.contains(key)) continue;
                    if(dist(nd, target) >= distTarget) continue; //Prune based on the target distance.
                    q.offer(nd);
                    v.add(key);
                }
            }
            ans++;
        }
        return ans;
    }
    private int dist(int[] x, int[] y){
        return Math.abs(x[0]-y[0]) + Math.abs(x[1]-y[1]);
    }
}