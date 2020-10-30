public class M{
	static void print(int m[][]){
		int R=m.length();
		int C=m[0].length();
		int max_s,max_i,max_j;
		int S[][]=new int[R][C];
		for(int i=0;i<R;i++)
			S[i][0]=m[i][0];
		for(int j=0;j<C;j++)
			S[0][j]=m[0][j];
		for(int i=1;i<R;i++){
			for(int j=1;j<C;j++){
				if(m[i][j])
					S[i][j]=min(S[i][j-1],min(S[i-1][j],S[i-1][j-1]))+1;
				else
					S[i][j]=0;
			}
		}
		max_s=S[0][0],max_i=0,max_j=0;
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				if(max_s<S[i][j]){
					max_s=S[i][j];
					max_i=i;
					max_j=j;
				}
			}
		}
		System.out.println("Maximum size sub-matrix is: ");
        for(i = max_i; i > max_i - max_of_s; i--)
        {
            for(j = max_j; j > max_j - max_of_s; j--)
            {
                System.out.print(M[i][j] + " ");
            }  
            System.out.println();
        }  
	}
}
//T:O(RXC).
//S:O(RXC).