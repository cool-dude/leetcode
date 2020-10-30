class Sln {
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


class Sln{
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
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=1+Math.min(dp[i-1][j-1]-1,Math.min(dp[i-1][j],dp[i][j-1]));
                }
                else {
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[m][n];
    }
}