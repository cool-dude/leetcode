package dailycodings;
class Sln1 {
    static char[][] board;
    static int m = 5;
    static int[][] positions;
    public static void main(String[] args) {
        board = new char[][]{
                {'b', '0', '0', '0', '0'},
                {'0', '0', 'b', '0', '0'},
                {'0', '0', 'b', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'b', '0', 'b', '0', '0'}
        };
        positions = new int[][]{
                {0, 0},
                {1, 2},
                {2, 2},
                {4, 0}
        };
        System.out.println(findTotalAttack(board, positions, m));
    }
    static int findTotalAttack(char[][] board, int[][] positions, int m) {
        int total = 0;
        for (int i = 0; i < positions.length; i++) {
            int[] val = positions[i];
            int r = val[0];
            int c = val[1];
            total += moveTopLeft(r, c, board) +
                    moveTopRight(r, c, board) +
                    moveDownRight(r, c, board) +
                    moveDownLeft(r, c, board);
        }
        return total;
    }
    static int moveDownLeft(int r, int c, char[][] board) {
        int attack = -1;
        while (r >= 0 && c >= 0 && r < m && c < m && board[r][c] != '1') {
            if (board[r][c] == 'b')
                attack++;
            else
                board[r][c] = '1';
            r++;
            c--;
        }
        return attack;
    }
    static int moveDownRight(int r, int c, char[][] board) {
        int attack = -1;
        while (r >= 0 && c >= 0 && r < m && c < m && board[r][c] != '1') {
            if (board[r][c] == 'b')
                attack++;
            else
                board[r][c] = '1';
            r++;
            c++;
        }
        return attack;
    }
    static int moveTopRight(int r, int c, char[][] board) {
        int attack = -1;
        while (r >= 0 && c >= 0 && r < m && c < m && board[r][c] != '1') {
            if (board[r][c] == 'b')
                attack++;
            else
                board[r][c] = '1';
            r--;
            c++;
        }
        return attack;
    }
    static int moveTopLeft(int r, int c, char[][] board) {
        int attack = -1;
        while (r >= 0 && c >= 0 && r < m && c < m && board[r][c] != '1') {
            if (board[r][c] == 'b')
                attack++;
            else
                board[r][c] = '1';
            r--;
            c--;
        }
        return attack;
    }
}

class Sln2{
    class Point {
        int x, y;
    }
    public int countAttackingBishopPairs(Point[] points, int M) {
        Map<Integer, Map<Integer, Integer>> posMap = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> negMap = new HashMap<>();
        for(Point point : points) {
            int posBoundaryX = point.x - Math.min(point.x, point.y);
            int posBoundaryY = point.y - Math.min(point.x, point.y);
            int negBoundaryX = point.x - Math.min(point.x, M - point.y);
            int negBoundaryY = point.y + Math.min(point.x, M - point.y);
            if(!posMap.containsKey(posBoundaryX)) {
                posMap.put(posBoundaryX, new HashMap<>());
            }
            if(!posMap.get(posBoundaryX).containsKey(posBoundaryY)) {
                posMap.get(posBoundaryX).put(posBoundaryY, 0);
            }
            Map<Integer, Integer> map = posMap.get(posBoundaryX);
            map.put(posBoundaryY, map.get(posBoundaryY) + 1);
            if(!negMap.containsKey(negBoundaryX)) {
                negMap.put(negBoundaryX, new HashMap<>());
            }
            if(!negMap.get(negBoundaryX).containsKey(negBoundaryY)) {
                negMap.get(negBoundaryX).put(negBoundaryY, 0);
            }
            map = negMap.get(negBoundaryX);
            map.put(negBoundaryY, map.get(negBoundaryY) + 1);
        }
        int count = 0;
        for(Map<Integer, Integer> map : posMap.values()) {
            for(int c : map.values()) {
                count += c * (c - 1) / 2;
            }
        }
        for(Map<Integer, Integer> map : negMap.values()) {
            for(int c : map.values()) {
                count += c * (c - 1) / 2;
            }
        }
        return count;
    }
}
// Java implementation of the approach
/*Let dp[i][j] denote the number of ways to
place j bishops on diagonals with indices
up to i which have the same color as diagonal i.
Then i = 1…2N-1 and j = 0…K.
We can calculate dp[i][j] using only values of dp[i-2]
(we subtract 2 because we only consider diagonals
of the same color as i). There are two ways to
get dp[i][j]. Either we place all j bishops on
previous diagonals: then there are dp[i-2][j]
ways to achieve this. Or we place one bishop on diagonal
i and j-1 bishops on previous diagonals. The number
of ways to do this equals the number of squares in
diagonal i – (j – 1), because each of j-1 bishops
placed on previous diagonals will block one square on the current diagonal.
The base case is simple: dp[i][0] = 1, dp[1][1] = 1.
Once we have calculated all values of dp[i][j],
the answer can be obtained as follows: consider
all possible numbers of bishops placed on black diagonals
i=0…K, with corresponding numbers of bishops on white
diagonals K-i. The bishops placed on black and white
diagonals never attack each other, so the placements
can be done independently. The index of the last black
diagonal is 2N-1, the last white one is 2N-2. For
each i we add dp[2N-1][i] * dp[2N-2][K-i] to the answer.*/
class Sln3 {
    static int squares(int i) {
        if ((i & 1) == 1)
            return i / 4 * 2 + 1;
        else
            return (i - 1) / 4 * 2 + 2;
    }
    static long bishop_placements(int n, int k) {
        if (k > 2 * n - 1)
            return 0;
        // dp table to store the values
        long[][] dp = new long[n * 2][k + 1];
        // Setting the base conditions
        for (int i = 0; i < n * 2; i++)
            dp[i][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i < n * 2; i++) {
            for (int j = 1; j <= k; j++)
                dp[i][j]
                        = dp[i - 2][j]
                        + dp[i - 2][j - 1] * (squares(i) - j + 1);
        }
        long ans = 0;
        for (int i = 0; i <= k; i++) {
            ans += dp[n * 2 - 1][i] * dp[n * 2 - 2][k - i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 2;
        int k = 2;
        long ans = bishop_placements(n, k);
        System.out.println(ans);
    }
}