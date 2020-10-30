/*LC97: Interleaving String
https://leetcode.com/problems/interleaving-string/
Given s1, s2, s3, find whether s3 is
* formed by the interleaving of s1 and s2.

Example 1:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true

Example 2:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false*/
class Sln{
    public boolean isInterLeave(String s1,String s2,String s3){
        if(s3.length()!=s1.length()+s2.length()){
            return false;
        }
        boolean[][] dp=new boolean[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                if(i==0&&j==0)
                    dp[i][j]=true;
                else if(i==0)
                    dp[0][j]=dp[0][j-1] && s2.charAt(j-1)==s3.charAt(j-1);
                else if(j==0)
                    dp[i][0]=dp[i-1][0] && s1.charAt(i-1)==s3.charAt(i-1);
                else
                    dp[i][j]=(dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
    //T:O(MXN).
    //S:O(MxN).
}