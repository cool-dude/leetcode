/*Given an array of size N and an integer K,
the task is to divide the array into K
segments such that sum of the minimum of
K segments is maximized.
Input: a[] = {5, 7, 4, 2, 8, 1, 6}, K = 3
Output: 7
Divide the array at indexes 0 and 1.
Then the segments are {5}, {7}, {4, 2, 8, 1, 6}.
 Sum of the min-s is 5 + 7 + 1 = 13*/
class Sln{
    int MAX=Integer.MAX_VALUE;
    public int minSum(int[] arr,int n,int idx,int k,int[][] dp){
        // If k segments have been divided
        if (k == 0) {
            // If we are at the end
            if (idx == n)
                return 0;
            // If we donot reach the end
            // then return a negative number
            // that cannot be the sum
            else
                return Integer.MIN_VALUE;
        }
        // If at end but
        // k segments are not formed
        else if (idx == n)
            return Integer.MIN_VALUE;
        else if (dp[idx][k] != -1)
            return dp[idx][k];
        else {
            int ans=0;
            int min=a[idx];
            for(int i=idx+1;i<n;i++){
                min=Math.min(min,a[i]);
                ans=Math.max(ans,minSum(arr,n,idx+1,k-1,dp)+min);
            }
            return dp[idx][k]=ans;
        }
    }
    // Driver code
    public static void main(String[] args) {
        int[] a = { 5, 7, 4, 2, 8, 1, 6 };
        int k = 3;
        int n = a.length;
        int[][] dp = new int[MAX][MAX];
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++)
                dp[i][j] = -1;
        }
        System.out.println(maximizeSum(a, n, 0, k, dp));
    }
    //T:O(n*k).
    //S:O(n*k).
}