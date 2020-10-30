package coderbyte;
public class MaxSquare {
    public static void main(String[] args) {
        int[][] in = new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        System.out.println(findMaxSquare(in));
    }

    private static int findMaxSquare(int[][] in) {
        int max = 0;
        for (int i = 1; i < in.length; i++) {
            for (int j = 1; j < in[0].length; j++) {
                if (in[i][j] == 1) {
                    int curMax = Math.min(in[i - 1][j - 1],
                            Math.min(in[i - 1][j], in[i][j - 1])) + 1;
                    in[i][j] = curMax;
                    if (curMax > max)
                        max = curMax;
                }
            }
        }
        return max * max;
    }

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
}
