//recurive soln for eggs and floors
class Sln1{
    public int minTrials(int e,int f){
        if(f==0||f==1||e==1) return f;
        int min_trials=Integer.MAX_VALUE, cur_min_trials;
        for(int cur=1;cur<=f;cur++){
            cur_min_trials=1+Math.max(minTrials(e-1,cur-1),minTrials(e,f-cur));
            min_trials=Math.min(min_trials,cur_min_trials);
        }
        return min_trials;
    }
}

class Sln2{
    public int minTotalTrials(int e,int f){
        int[][] dp=new int[e+1][f+1];
        for(int i=1;i<=e;i++){
            //0 floors no trials
            dp[i][0]=0;
            //1 floor 1 trial
            dp[i][1]=1;
        }
        for(int i=1;i<=f;i++){
            //one egg, number of floors
            dp[1][i]=i;
        }
        for(int i=2;i<=e;i++){
            for(int j=2;j<=f;j++){
                int min=Integer.MAX_VALUE,cur_min;
                for(int cur=1;cur<=j;cur++){
                    cur_min=1+Math.max(dp[i-1][cur-1],dp[i][j-cur]);
                    min=Math.min(min,cur_min);
                }
                dp[i][j]=min;
            }
        }
        return dp[e][f];
    }
}