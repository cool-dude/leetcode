/*LC72: Edit Distance
https://leetcode.com/problems/edit-distance/
Given two words word1 and word2, find
the minimum number of operations required
to convert word1 to word2.
You have the following 3 operations permitted on a word:
Insert a character
Delete a character
Replace a character
Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')*/
class Sln1 {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        if(m==0) return n;
        if(n==0) return m;
        // If last characters same,
        // nothing much to do.
        // Ignore last characters
        // remaining strings.
        if (word1.charAt(m-1)
                == word2.charAt(n-1))
            return minDistance(word1.substring(0,m-1),
                    word2.substring(0,n-1));
        // If last characters not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
        return 1 + Math.min ( Math.min(minDistance(word1, word2.substring(0,n-1)),    // Insert
                minDistance(word1.substring(0,m-1), word2)),   // Remove
                minDistance(word1.substring(0,m-1), word2.substring(0,n-1)));  //replace
    }
}

class Sln2{
    public int minDistance(String word1, String word2){
        int m=word1.length();
        int n=word2.length();
        //one/both of the words empty
        if(m*n==0){
            return m+n;
        }
        int[][] dp=new int[m+1][n+1];
        //first word with empty word(second)
        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        //second word with empty(first)
        for(int j=0;j<=n;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        return dp[m][n];
    }
}