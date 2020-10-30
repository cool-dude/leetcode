/*LC1326: Minimum Number of Taps to Open to Water a Garden
https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
There is a one-dimensional garden on the x-axis.
The garden starts at the point 0 and ends
at the point n. (i.e The length of the garden is n).

There are n + 1 taps located at points [0, 1, ..., n] in the garden.
Given an integer n and an integer array ranges of
length n + 1 where ranges[i] (0-indexed) means
the i-th tap can water the area [i - ranges[i],
i + ranges[i]] if it was open.
Return the minimum number of taps that should be open
to water the whole garden, If the garden cannot be watered return -1.
Example 1:
Input: n = 5, ranges = [3,4,1,1,0,0]
Output: 1

Example 2:
Input: n = 3, ranges = [0,0,0,0]
Output: -1
Explanation: Even if you activate all the four taps you cannot water the whole garden.

Example 3:
Input: n = 7, ranges = [1,2,1,0,2,1,0,1]
Output: 3

Example 4:
Input: n = 8, ranges = [4,0,0,0,0,0,0,0,4]
Output: 2

Example 5:
Input: n = 8, ranges = [4,0,0,0,4,0,0,0,4]
Output: 1*/
class Sln{
    public int minTaps(int n,int[] A){
        int[] dp=new int[n+1];
        Arrays.fill(dp,n+2);
        dp[0]=0;
        for(int i=0;i<=n;i++)
            for(int j=Math.max(i-A[i]+1,0);j<=Math.min(i+A[i],n);++j)
                dp[j]=Math.min(dp[j],dp[Math.max(0,i-A[i])]+1);
        return dp[n]<n+2?dp[n]:-1;
    }
}