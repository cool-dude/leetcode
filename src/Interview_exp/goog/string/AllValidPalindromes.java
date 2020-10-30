/*LC125:Valid Palindrome
https://leetcode.com/problems/valid-palindrome/
Given a string, determine if it is a palindrome,
* considering only alphanumeric characters and ignoring cases.
Note: For the purpose of this problem,
* we define empty string as valid palindrome.
Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true
* Example 2:
Input: "race a car"
Output: false*/
class Sln1 {
    public boolean isPalindrome(String s) {
        int l=0,r=s.length()-1;
        while(l<s.length() && r>=0 && l<r){
            if(!Character.isLetterOrDigit(s.charAt(l)))
                l++;
            else if(!Character.isLetterOrDigit(s.charAt(r)))
                r--;
            else if(Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))){
                l++;
                r--;
            }
            else
                return false;
        }
        return true;
    }
}
/*LC680: Valid Palindrome II
https://leetcode.com/problems/valid-palindrome-ii
Given a non-empty string s, you may
delete at most one character.
Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.*/
class Sln2 {
    boolean isPalindromic(String s,int l,int r){
        while (++l<--r)
            if(s.charAt(l)!=s.charAt(r)) return false;
        return true;
    }
    public boolean validPalindrome(String s){
        int l=-1,r=s.length();
        while (++l<--r)
            if(s.charAt(l)!=s.charAt(r)) return (isPalindromic(s,l,r+1)||isPalindromic(s,l-1,r));
        return true;
    }
}
/*LC:1216: Valid Palindrome III
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
class Sln3 {
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