/*LC121:Best Time to Buy and Sell Stock
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
Note that you cannot sell a stock before you buy one.
Example 1:
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.*/
class Sln1 {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int max=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min)
                min=prices[i];
            else if(prices[i]-min>max)
                max=prices[i]-min;
        }
        return max;
    }
}
/*LC122: Best Time to Buy and Sell Stock II
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
Design an algorithm for maximum profit.
You may complete as many transactions as you
like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time
(i.e., you must sell the stock before you buy again).
Example 1:
Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

Example 2:
Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
engaging multiple transactions at the same time. You must sell before buying again.

Example 3:
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case,
no transaction is done, i.e. max profit = 0.*/
/*
* D=p[y]-p[x]
* =*p[y]-p[y-1]+...+p[x+1]-p[x]*
* =D[y]+D[y-1]....+D[x+1]
* =Sum of D from x+1 to y
*
Note that there could be neg/zero D .
*  It doesn't matter so long the sum of the sequence is the largest.

Now we are allowed unlimited transactions.
* So if there is a negative D, we could just
* break the sequence into 2, that is, into
* 2 transactions so as to avoid the negative element.*/
class Sln2{
    public int maxProfit(int[] prices){
        int res=0;
        for(int i=1;i<prices.length;i++)
            res+=Math.max(0,prices[i]-prices[i-1]);
        return res;
    }
}
/*LC123: Best Time to Buy and Sell Stock III
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
Say you have an array for which the ith
element is the price of a given stock on day i.
Design an algorithm to find the maximum profit.
You may complete at most two transactions.
Example 1:
Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:
Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.*/
/* First assume no money,
* so buy1 means that we have to borrow money
* from others, we want to borrow less so that
* we have to make our balance as max as we can(because this is negative).
sell1 means we decide to sell the stock,
* after selling it we have price[i] money
* and we have to give back the money we owed,
* so we have price[i] - |buy1| = prices[i] + buy1,
* we want to make this max.

buy2 means we want to buy another stock,
* we already have sell1 money, so after
* buying stock2 we have buy2 = sell1 - price[i]
* money left, we want more money left, so we make it max

sell2 means we want to sell stock2, we can
* have price[i] money after selling it, and
*  we have buy2 money left before, so sell2 = buy2 + prices[i], we make this max.

So sell2 is the most money we can have.*/
class Sln2{
    public int maxProfit(int[] prices){
        int sell1=0,sell2=0,buy1=Integer.MIN_VALUE,buy2=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            buy1=Math.max(buy1, -prices[i]);
            sell1=Math.max(sell1, buy1+prices[i]);
            buy2=Math.max(buy2, sell1-prices[i]);
            sell2=Math.max(sell2, buy2+prices[i]);
        }
        return sell2;
    }
}
//DP Solutions
class Sln2{
    public int MaxProfitDp(int[] prices) {
        if (prices.Length == 0) return 0;
        var dp = new int[3][prices.length];
        for (int k = 1; k <= 2; k++)  {
            for (int i = 1; i < prices.Length; i++) {
                int min = prices[0];
                for (int j = 1; j <= i; j++)
                    min = Math.Min(min, prices[j] - dp[k-1][j-1]);
                dp[k][i] = Math.Max(dp[k][i-1], prices[i] - min);
            }
        }
        return dp[2][prices.length - 1];
    }
    public int MaxProfitDpCompact1(int[] prices) {
        if (prices.length == 0) return 0;
        var dp = new int[3][prices.Length];
        for (int k = 1; k <= 2; k++) {
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                min = Math.min(min, prices[i] - dp[k-1][i-1]);
                dp[k][i] = Math.Max(dp[kp][i-1], prices[i] - min);
            }
        }
        return dp[2][prices.length - 1];
    }
    public int MaxProfitDpCompact1T(int[] prices) {
        if (prices.length == 0) return 0;
        var dp = new int[3][prices.length];
        var min = new int[3];
        Array.Fill(min, prices[0]);
        for (int i = 1; i < prices.Length; i++) {
            for (int k = 1; k <= 2; k++) {
                min[k] = Math.Min(min[k], prices[i] - dp[k-1][i-1]);
                dp[k, i] = Math.Max(dp[k][i-1], prices[i] - min[k]);
            }
        }
        return dp[2][prices.length - 1];
    }
    public int MaxProfitDpCompact2(int[] prices) {
        if (prices.Length == 0) return 0;
        var dp = new int[3];
        var min = new int[3];
        Array.Fill(min, prices[0]);
        for (int i = 1; i < prices.Length; i++)  {
            for (int k = 1; k <= 2; k++) {
                min[k] = Math.Min(min[k], prices[i] - dp[k-1]);
                dp[k] = Math.Max(dp[k], prices[i] - min[k]);
            }
        }
        return dp[2];
    }
    //T:O(kn),S:O(kn)
}
/*LC188: Best Time to Buy and Sell Stock IV
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
Say you have an array for which the i-th
element is the price of a given stock on day i.
Design an algorithm to find the maximum profit.
You may complete at most k transactions.
Example 1:
Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

Example 2:
Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.*/
/**dp[i][j] = maximum profit from at most i transactions using prices[0..j]
 A transaction is defined as one buy + sell.
 Now on day j, we have two options
 1.Do nothing (or buy) which doesn't change
 the acquired profit : dp[i][j] = dp[i][j-1]
 2.Sell the stock: In order to sell the stock,
 you must've bought it on a day t=[0..j-1].
 Maximum profit that can be attained is t:0->j-1
 max(prices[j]-prices[t]+dp[i-1][t-1])
 where prices[j]-prices[t] is the profit
 from buying on day t and selling on day j.
 dp[i-1][t-1] is the maximum profit that
 can be made with at most i-1 transactions
 with prices prices[0..t-1].
 T:O(n^2k).
 In order to reduce it to O(nk), we
 must find
 t:0->j-1 max(prices[j]-prices[t]+dp[i-1][t-1])
 this expression in constant time. If you see carefully,
 t:0->j-1 max(prices[j]-prices[t]+dp[i-1][t-1]) is same as
 prices[j] + t:0->j-1 max(dp[i-1][t-1]-prices[t])
 Second part of the above expression
 maxTemp = t:0->j-1 max(dp[i-1][t-1]-prices[t])
 can be included in the dp loop by keeping track of the maximum value till j-1.
 Base case:
 dp[0][j] = 0; dp[i][0] = 0
 DP loop:
 for i : 1 -> k
 maxTemp = -prices[0];
 for j : 1 -> n-1
 dp[i][j] = max(dp[i][j-1], prices[j]+maxTemp);
 maxTemp = max(maxTemp, dp[i-1][j-1]-prices[j]);
 return dp[k][n-1];*/
class Sln4{
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        if(n<=1)
            return 0;
        //if k >= n/2, then you can make maximum number of transactions.
        if(k>=n/2){
            int maxProf=0;
            for(int i=1;i<n;i++){
                if(prices[i]>prices[i-1])
                    maxProf+=prices[i]-prices[i-1];
            }
            return maxProf;
        }
        int[][] dp=new int[k+1][n];
        for(int i=1;i<=k;i++){
            int localMax=-prices[0];
            for(int j=1;j<n;j++) {
                dp[i][j]=Math.max(dp[i][j-1],prices[j]+localMax);
                localMax=Math.max(localMax,dp[i-1][j-1]-prices[j]);
            }
        }
        return dp[k][n-1];
    }
}
/*LC309: Best Time to Buy and Sell Stock with Cooldown
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
Say you have an array for which the ith element
is the price of a given stock on day i.

Design an algorithm to find the maximum profit.
You may complete as many transactions as you like
(ie, buy one and sell one share of the stock
multiple times) with the following restrictions:

You may not engage in multiple transactions at
the same time (ie, you must sell the stock before
you buy again).
After you sell your stock, you cannot buy stock
 on next day. (ie, cooldown 1 day)
Example:
Input: [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]*/
class Sln {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int n=prices.length;
        int[] s0,s1,s2=new int[n];
        s1[0]=-prices[0];
        s0[0]=0;
        s2[0]=Math.MIN_VALUE;
        for(int i=1;i<prices.length;i++){
            s0[i]=Math.max(s0[i-1],s2[i-1]);
            s1[i]=Math.max(s1[i-1],s0[i-1]-prices[i]);
            s2[i]=s1[i-1]+prices[i];
        }
        return Math.max(s0[n-1],s2[n-1]);
    }
}