/*Minimum steps to minimize n as per given condition
Given a number n, count minimum steps to
minimize it to 1 according to the following criteria:
If n is divisible by 2 then we may reduce n to n/2.
If n is divisible by 3 then you may reduce n to n/3.
Decrement n by 1.

Examples:
Input : n = 10
Output : 3

Input : 6
Output : 2*/
/*Soln1: Greedy approach
DOES NOT WORK*/
class Sln1{
    public int getMinSteps(int n){
        int steps=0;
        while (n>1){
            if(n%3==0) n/=3;
            else if(n%2==0) n/=2;
            else n--;
            steps++;
        }
        return steps;
    }
}

/*DP Approach(top-down):
f(n) = 1 + f(n-1)
f(n) = 1 + f(n/2) // if n is divisible by 2
f(n) = 1 + f(n/3) // if n is divisible by 3*/
class Sln2{
    int getMinStepsRec(int n,int[] dp){
        if(n==1) return 0;
        if(dp[n]!=-1) return dp[n];
        int res=getMinStepsRec(n-1,dp);
        if(n%2==0) res=Math.min(res,getMinStepsRec(n/2,dp));
        if(n%3==0) res=Math.min(res,getMinStepsRec(n/3,dp));
        dp[n]=1+res;
        return dp[n];
    }
    public int getMinSteps(int n){
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return getMinStepsRec(n,dp);
    }
}

/*Bottom up DP soln*/
class Sln3{
    public int getMinSteps(int n) {
        int[] dp=new int[n+1];
        dp[1]=0;
        for(int i=2;i<=n;i++){
            int t[3]={Integer.MAX_VALUE};
            if(i%3==0)
                t[0]=dp[i/3];
            if(i%2==0)
                t[1]=dp[i/2];
            t[2]=dp[i-1];
            dp[i]=1+Math.min(t[0],Math.min(t[1],t[2]));
        }
        return dp[n];
    }
}