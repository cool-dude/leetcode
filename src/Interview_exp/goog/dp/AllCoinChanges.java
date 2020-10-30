/*LC322: Coin Change
https://leetcode.com/problems/coin-change/
You are given coins of different
denominations and a total amount of
money amount. Write a function to
compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.
Example 1:
Input: coins = [1, 2, 5], amount= 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.*/
//min number coins for certain amount
//Recursive DP
class Sln1 {
    public int makeChange(int c, int[] coins) {
        if (c == 0) return 0;
        int min = Integer.MAX_VALUE;
        for(int coin:coins){
            //remove one coin
            if (c - coin >= 0) {
                int curMin = makeChange(c - coin,coins);
                if (curMin < min) min = curMin;
            }
        }
        //Add coin removed
        return min + 1;
    }
}
//top-down DP
class Sln2 {
    int makeChangeRecur(int c,int[] dp, int[] coins){
        if(dp[c]>=0) return dp[c];
        int minCoins = Integer.MAX_VALUE;
        for(int coin:coins){
            if(c-coin>=0){
                int curMin=makeChangeRecur(c-coin, dp, coins);
                if(curMin<minCoins)
                    minCoins=curMin;
            }
        }
        dp[c]=minCoins+1;
        return dp[c];
    }
    public int makeChange(int c,int[] coins){
        int[] dp=new int[c];
        Arrays.fill(dp,-1);
        return makeChangeRecur(c, dp, coins);
    }
}
//botoom-up DP
class Sln3{
    int makeChange(int c,int[] coins){
        int[] dp=new int[c+1];
        Arrays.fill(dp, 0);
        for(int i=1;i<=c;i++){
            int min=Integer.MAX_VALUE;
            for(int coin:coins){
                if(i-coin>=0){
                    //Add 1 coin
                    int cur=dp[i-coin]+1;
                    if(cur<min)
                        min=cur;
                }
            }
            dp[i]=min;
        }
        return dp[c];
    }
}
/*LC518:Coin Change II
https://leetcode.com/problems/coin-change-2/
You are given coins of different denominations and a
total amount of money. Write a function to compute the
number of combinations that make up that amount. You
may assume that you have infinite number of each kind of coin.
Example 1:
Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Example 2:
Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be
made up just with coins of 2.

Example 3:
Input: amount = 10, coins = [10]
Output: 1
Note:
You can assume that
0 <= amount <= 5000
1 <= coin <= 5000*/
/*dp[i][j]:number of combinations for amount j by using i types of coins
State:1.Not using i-th coin. Use i-1 coins to make up j.
2.Use i-th coin, make up j-coins[i-1] by using first i coins, dp[i][j-coins[i-1]]
dp[i][0]=1*/
class Sln4 {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length+1][amount+1];
        dp[0][0]=1;
        for(int i=1;i<=coins.length;i++){
            dp[i][0]=1;
            for(int j=1;j<=amount;j++){
                dp[i][j]=dp[i-1][j]+(j>=coins[i-1]?dp[i][j-coins[i-1]]:0);
            }
        }
        return dp[coins.length][amount];
    }
}
//bottom-up dp
class Sln5{
    public int change(int amount,int[] coins){
        int[] dp=new int[amount+1];
        Arrays.fill(dp,0);
        dp[0]=1;
        for(int i=0;i<coins.length;i++)
            for(int j=coins[i];j<=amount;j++)
                dp[j]+=dp[j-coins[i]];
        return dp[amount];
    }
}