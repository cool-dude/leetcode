/*LC121: Best Time to Buy and Sell Stock
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
/**dp[i, j] represents the max profit up until prices[j] using at most i transactions.
 * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
 *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
 * dp[0, j] = 0; 0 transactions makes 0 profit
 * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.*/
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
            int localMax=dp[i-1][0]-prices[0];
            for(int j=1;j<n;j++) {
                dp[i][j]=Math.max(dp[i][j-1],prices[j]+localMax);
                localMax=Math.max(localMax,dp[i-1][j]-prices[j]);
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