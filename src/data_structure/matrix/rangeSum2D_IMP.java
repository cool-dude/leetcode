public class 
RangeSumQuery2DMutable {
    int[][] binaryIndexTree;
    int[][] nums;
 
    public RangeSumQuery2DMutable(int[][] nums) {
        int m = nums.length, n = nums[0].length;
        binaryIndexTree = new int[m][n + 1];
        this.nums = nums;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                add(i, j + 1, nums[i][j]);
            }
        }
    }
    private void add(int row, int col, int val) {
        while (col < binaryIndexTree[row].length) {
            binaryIndexTree[row][col] += val;
            col += (col&-col);
        }
    }
    public void update(int row, int col, int val) {
        add(row, col + 1, val - nums[row][col]);
        nums[row][col] = val;
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for (int i = row1; i <= row2; i++) {
            ans += sum(i, col2 + 1) - sum(i, col1);
        }
        return ans;
    }
    private int sum(int row, int col) {
        int ans = 0;
        while (col > 0) {
            ans += binaryIndexTree[row][col];
            col -= (col&-col);
        }
        return ans;
    }
}