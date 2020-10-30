import java.io.*;
class Sln1 {
    static int findOptimal(int N) {
        if (N <= 6)
            return N;
        int max = 0;
        for (int b = N - 3; b >= 1; b--) {
            int cur = (N - b - 1) * findOpt(b);
            if (cur > max)
                max = cur;
        }
        return max;
    }
}

class Sln2{
    static int findOptimalDP(int N){
        if(N<=6)
            return N;
        int screen[]=new int[N];
        int b;
        for(int n=1;n<=6;n++)
            screen[n-1]=n;

        for(int n=7;n<=N;n++){
            screen[n-1]=0;
            for(b=N-3;b>=1;b--){
                int cur=(n-b-1)*screen[b-1];
                if(cur>screen[n-1])
                    screen[n-1]=cur;
            }
        }
        return screen[N-1];
    }
    //T:O(n^2).
}

class Sln3{
    public int findOptimal(int ){
        if(N<=6) return N;
        int[] dp=new int[N];
        for(int n=1;n<=6;n++)
            dp[n-1]=n;
        for(int n=7;n<=N;n++){
            dp[n-1]=Math.max(2*dp[n-4],
                    Math.max(3*dp[n-5],4*dp[n-6]));
        }
        return dp[n-1];
    }
}