/*DP on Strings
General problem statement for this pattern can
vary but most of the time you are given two
strings where lengths of those strings are not big

Statement
Given two strings s1 and s2, return some result.

Approach
Most of the problems on this pattern requires a solution that can be accepted in O(n^2) complexity.
*/
// i - indexing string s1
// j - indexing string s2
class Sln1 {
    for(int i = 1;i <=n; ++i){
        for (int j = 1; j <= m; ++j) {
            if (s1[i - 1] == s2[j - 1]) {
                dp[i][j] = /*code*/;
            } else {
                dp[i][j] = /*code*/;
            }
        }
    }
If you
are given
one string
s the
approach may
little vary

        for(
    int l = 1;
    l<n; ++l)

    {
        for (int i = 0; i < n - l; ++i) {
            int j = i + l;
            if (s[i] == s[j]) {
                dp[i][j] = /*code*/;
            } else {
                dp[i][j] = /*code*/;
            }
        }
    }
        1143.
    Longest Common
    Subsequence Medium

        for(
    int i = 1;
    i <=n; ++i)

    {
        for (int j = 1; j <= m; ++j) {
            if (text1[i - 1] == text2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }
        647.
    Palindromic Substrings
    Medium

        for(
    int l = 1;
    l<n; ++l)

    {
        for (int i = 0; i < n - l; ++i) {
            int j = i + l;
            if (s[i] == s[j] && dp[i + 1][j - 1] == j - i - 1) {
                dp[i][j] = dp[i + 1][j - 1] + 2;
            } else {
                dp[i][j] = 0;
            }
        }
    }
}
516. Longest Palindromic Subsequence Medium

1092. Shortest Common Supersequence Medium

72. Edit Distance Hard

115. Distinct Subsequences Hard

712. Minimum ASCII Delete Sum for Two Strings Medium

5. Longest Palindromic Substring Medium