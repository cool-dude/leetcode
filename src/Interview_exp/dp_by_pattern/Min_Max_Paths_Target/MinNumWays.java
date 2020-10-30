//Minimum number of ways
class Sln{
    public int minNumWays(int[] ways, int target) {
        int[] dp = new int[ways.length + 1];
        for(int i=1;i<=target;i++)
            for(int j=0;j<ways.length;j++)
                if(ways[j]<=i)
                    dp[i]=Math.min(dp[i], dp[i-ways[j]]+ways[j]);
            }
        }
        return dp[target];
    }
}

//Minimum cost climbing stairs
class Sln{
    public int minCost(int n){
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=cost[1];
        for(int i=2;i<=n;i++)
            dp[i]=Math.min(dp[i-1],dp[i-2])+(i==n?0:cost[i]);
    }
}

//Minimum path sum
class Sln{
    public int minPathSum(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int initial=grid[m-1][n-1];
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
                grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1])
        return grid[m-1][n-1]-initial;
    }
}
/*
Some questions point out the number of repetitions, in that case, add one more loop to simulate every repetition.

688. Knight Probability in Chessboard Medium

494. Target Sum Medium

377. Combination Sum IV Medium

935. Knight Dialer Medium

1223. Dice Roll Simulation Medium

416. Partition Equal Subset Sum Medium

808. Soup Servings Medium

790. Domino and Tromino Tiling Medium

801. Minimum Swaps To Make Sequences Increasing

673. Number of Longest Increasing Subsequence Medium

63. Unique Paths II Medium

576. Out of Boundary Paths Medium

1269. Number of Ways to Stay in the Same Place After Some Steps Hard

1220. Count Vowels Permutation Hard
*/