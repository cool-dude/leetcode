/*LC:1216:  Valid Palindrome III
https://leetcode.com/problems/valid-palindrome-iii/description/
Given a string s and an integer k, find out
if the given string is a K-Palindrome or not.

A string is K-Palindrome if it can be transformed into
palindrome by removing at most k characters from it.
Example 1:
Input: s = "abcdeca", k = 2
Output: true
Explanation: Remove 'b' and 'e' characters.
//   s[i...j]
//    dp[i][j]: the length of longest palindrome subsequence from S[i...j]
//          if s[i] == s[j], f(s[i...j]) = f(s[i+1...j-1])+2
//          Otherwise: f(s[i...j]) = max(f(s[i+1...j]), f(s[i...j-1]))
// Complexity: Time O(n^2), Space O(n^2)*/
class Sln {
    // Method 3: DP
    // 16ms, beats 90% solutions
    boolean isValidPalindrome(string s, int k) {
        int n = s.length();
        int[][] dp=new int[n][n];
        for(int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for(int j = i + 1; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = 2 + dp[i + 1][j - 1];
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= n - k;
    }
    //T:O(n^2).
    //S:O(n^2).
}