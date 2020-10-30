import java.io.*;
class M{
	static int spiral(int m[][],int row,int col){
		int k=0,l=0;
		//k=starting row(0,r-1),
		//l=start col(0,c-1)
		while(k<row && l<col){
			for(int i=0;i<col;i++)
				print(a[k][i]+" ");
			k++;
			for(int i=k;i<row;i++)
				print(a[i][col-1]+" ");
			
			col--;
			if(k<row){
				for(int i=col-1;i>=l;i--)
					print(a[row-1][i]+" ");
				row--;
			}
			if(l<col){
				for(int i=row-1;i>=k;i--)
					print(a[i][l]+" ");
				l++;
			}
		}
	}
}

class Sln{
	public List<Integer> spiralOrder(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		if(row==0 && col==0) {
			return new ArrayList<>();
		}
		List<Integer> res=new ArrayList<>();
		int k=0,l=0;
		//k=starting row(0,r-1),
		//l=start col(0,c-1)
		while(k<row && l<col){
			for(int i=1;i<col;i++){
				res.add(matrix[k][i]);
			}
			k++;

			for(int i=k;i<row;i++){
				res.add(matrix[i][col-1]);
			}
			col--;

			if(k<row){
				for(int i=col-1;i>=l;i--){
					res.add(matrix[row-1][i]);
				}
				row--;
			}
			if(l<col){
				for(int i=row-1;i>=k;i--){
					res.add(matrix[i][l]);
				}
				l++;
			}
		}
		return res;
	}
}
//T:O(RXC).

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
		print(arr, i + 1, j + 1, m - 1, n - 1);
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
}