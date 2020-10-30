package coderbyte;
public class FindSubArray {
    public static void main(String[] args) {
        int[] in=new int[]{3,2,7,1};
        int S=19;
        int pos=0;
        System.out.println(insert(in,S,pos));
    }
    public static boolean subSetDP(int[] A, int sum) {
        boolean[][] dp = new boolean[A.length + 1][sum + 1];
        // if sum is not zero and subset is 0, we can't make it
        for(int i=1;i<=sum;i++){
            dp[0][i]=false;
        }
        // if sum is 0 the we can make the empty subset to make sum 0
        for(int i=0;i<=A.length;i++){
            dp[i][0]=true;
        }
        //
        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=sum;j++){
                //first copy the data from the top
                dp[i][j] = dp[i-1][j];

                //If solution[i][j]==false check if can be made
                if(dp[i][j]==false && j>=A[i-1])
                    dp[i][j] = dp[i][j] || dp[i-1][j-A[i-1]];
            }
        }
        return dp[A.length][sum];
    }
}