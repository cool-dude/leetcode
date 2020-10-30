// "static void main" must be defined in a public class.
class Sln {
    static int m, n;
    public static void main(String[] args) {
        char[][] input = new char[][]{{'S', 'O', 'O', 'S', 'S'},
                {'D', 'O', 'D', 'O', 'D'},
                {'O', 'O', 'O', 'O', 'X'},
                {'X', 'D', 'D', 'O', 'O'},
                {'X', 'D', 'D', 'D', 'O'}};
        int rst = multiSourceShortest(input);
        System.out.println(rst);
    }
    public static int multiSourceShortest(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int MAX = m*n;
        int[][] rst = new int[n][m];
        int path = Integer.MAX_VALUE;
        // Sweep from upper left to bottom right
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 'D'){
                    rst[i][j] = MAX;
                }
                else if(matrix[i][j] == 'X'){
                    rst[i][j] = 0;
                }
                else {
                    int cellAbove = i > 0 ? rst[i-1][j] : MAX;
                    int cellLeft = j > 0 ? rst[i][j-1] : MAX;
                    rst[i][j] = Math.min(cellAbove, cellLeft) + 1;
                }
            }
        }
        // Sweep from bottom right to upper left
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                if(matrix[i][j] != 'D') {
                    int cellBelow = i < n - 1 ? rst[i + 1][j] : MAX;
                    int cellRight = j < m - 1 ? rst[i][j + 1] : MAX;
                    rst[i][j] = Math.min(rst[i][j], Math.min(cellBelow, cellRight) + 1);
                }
                // pick out the source nodes and get min path length
                if(matrix[i][j] == 'S'){
                    path = Math.min(path, rst[i][j]);
                }
            }
        }
        return path;
    }
}