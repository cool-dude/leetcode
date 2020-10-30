package strings;
/**LC5: https://leetcode.com/problems/longest-palindromic-substring/
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 * we need to build a matrix by input and reverse of the input. Like below
 * *** b a b a d
 * ----------------
 * d | 0 0 0 0 1
 * a | 0 1 0 1 0
 * b | 1 0 2 0 0
 * a | 0 2 0 3 0
 * b | 1 0 3 0 0*/
import java.lang.String;
import java.lang.StringBuilder;
import java.util.Arrays;
class Sln {
    String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    String helper(String s1, String s2) {
        char[] rows = s1.toCharArray();
        char[] cols = s2.toCharArray();
        int n = rows.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][n];
        int maxPos = 0, maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] == cols[j]) {
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        maxPos = i;
                    }
                }
            }
        }
        return s1.substring(maxPos + 1 - maxLen, maxLen);
    }
    String findLongestPalindrome(String str) {
        return helper(str, reverseString(str));
    }
}
class Sln2{
    public String longestPalindrome(String s) {
        int max = 0, idx = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = extend(s, i, i);
            int len2 = extend(s, i, i + 1);
            if (max < Math.max(len1, len2)) {
                idx = (len1 > len2) ? (i - len1 / 2) : (i - len2 / 2 + 1);
                max = Math.max(len1, len2);
            }
        }
        return s.substring(idx, idx + max);
    }
    int extend(String s, int i, int j) {
        for (; i >= 0 && j < s.length(); i--, j++)
            if (s.charAt(i) != s.charAt(j))
                break;
        return j - i - 2 + 1; // 2 means current two unmatched char
    }
}