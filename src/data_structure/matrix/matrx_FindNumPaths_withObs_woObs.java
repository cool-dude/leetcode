public class NPathObs{
	int numRows;
	int numCols;
	public int cnt(int[][] a,int r,int c){
		if(r==numRows-1 && c==numCols-1)
			return 1;
		int lft=0,dwn=0;
		
		if(r!=numRows-1 && a[r+1][c]!=-1){
			lft=cnt(a,r+1,c);
		}
		else if(c!=numCols-1 && a[r][c+1]!=-1){
			dwn=cnt(a,r,c+1);
		}
		return lft+dwn;
	}
	public int cntDP(int[][] a){
		int res[][]=a;

		for(int i=1;i<numRows;i++){
			for(int j=1;j,numCols;j++){
				if(res[i][j]!=-1){
					res[i][j]=0;
					if(res[i-1][j]>0)
						res[i][j]+=res[i-1][j];
					if(res[i][j-1]>0)		
						res[i][j-1]+=res[i][j-1];
				}
			}
		}
	}
}