class Soln{
	List<Integer> res;
	public void helper(int[][] a,int i,int j,int m,int n){
		// If i or j lies outside the matrix
		if (i >= m || j >= n) {
			return;
		}
		// Print First Row
		for (int p = i; p < n; p++) {
			res.add(a[i][p]);
		}
		// Print Last Column
		for (int p = i + 1; p < m; p++) {
			res.add(a[p][n - 1]);
		}
		// Print Last Row, if Last and
		// First Row are not same
		if ((m - 1) != i) {
			for (int p = n - 2; p >= j; p--) {
				res.add(a[m - 1][p]);
			}
		}
		// Print First Column, if Last and
		// First Column are not same
		if ((n - 1) != j) {
			for (int p = m - 2; p > i; p--) {
				res.add(a[p][j]);
			}
		}
		helper(arr, i + 1, j + 1, m - 1, n - 1);
	}
	public List<Integer> spiralOrder(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		if (row == 0 && col == 0) {
			return new ArrayList<>();
		}
		res=new ArrayList<>();
		helper(matrix,0,0,row,col);
		return res;
	}
	//T:O(RXC)
}