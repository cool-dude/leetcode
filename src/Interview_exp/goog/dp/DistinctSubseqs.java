/*LC115. Distinct Subsequences
https://leetcode.com/problems/distinct-subsequences/
Given a string S and a string T,
count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string
which is formed from the original string by deleting some
(can be none) of the characters without disturbing the relative
positions of the remaining characters. (ie, "ACE" is a
subsequence of "ABCDE" while "AEC" is not).

Example 1:
Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:

As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)
rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
Example 2:

Input: S = "babgbag", T = "bag"
Output: 5
Explanation:

As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
^  ^^
babgbag
  s = "rara" t = "ra"
  dp[i][j] = dp[i][j - 1] + (t.charAt(i - 1) == s.charAt(j - 1) ? dp[i - 1][j - 1] : 0);
  ex: rara and ra, if a match happens, how much prefix of this one we have before + how much match without using
      one before. other words, substring using it [i - 1][j - 1] (how many prefix matches) + substring without
      using it [i][j - 1].
  e r a r a
e 1 1 1 1 1 -> any string will contasin one and only one empty string substring
r 0 1 1 2 2 -> ex: on (1, 1) r matches a r, it is obviously 1 equal substring
a 0 0 1 1 3        on (1, 2) r doesn't match a so we just see from previous which is dp[i][j - 1]
  |
  v
  empty string contains no substring except another empty string*/
class Sln {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < t.length(); i++)
            for (int j = 1; j < s.length(); j++)
                dp[i][j] = dp[i][j - 1] + (t.charAt(i - 1) == s.charAt(j - 1) ? dp[i - 1][j - 1] : 0);
        return dp[t.length()][s.length()];
    }
}