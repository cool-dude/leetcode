/*LC131: Palindrome Partitioning
https://leetcode.com/problems/palindrome-partitioning/
Given a string s, partition s such
that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
Example:
Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]*/
/*SLN:first,how to check if a string is palindrome
or not, usually 2 point solution scanning
from front and back. Here if you want to
get all the possible palindrome partition,
first a nested for loop to get every possible
partitions for a string, then a scanning for
all the partitions. That's a O(n^2) for partition
and O(n^2) for the scanning of string, totaling
at O(n^4) just for the partition.

However, if we use a 2d array to keep track
of any string we have scanned so far, with
an addition pair, we can determine whether
it's palindrome or not by justing looking at
that pair, which is this line if
(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])).
This way, the 2d array dp contains the possible palindrome partition among all.

second, based on the prescanned palindrome
partitions saved in dp array, a simple backtrack does the job.*/
class Sln1 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
            }
        }
        helper(res, new ArrayList<>(), dp, s, 0);
        return res;
    }
    void helper(List<List<String>> res, List<String> path, boolean[][] dp, String s, int pos) {
        if(pos == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = pos; i < s.length(); i++) {
            if(dp[pos][i]) {
                path.add(s.substring(pos,i+1));
                helper(res, path, dp, s, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
/*LC132: Palindrome Partitioning II
https://leetcode.com/problems/palindrome-partitioning-ii/
Given a string s, partition s such
that every substring of the partition
is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
Example:
Input: "aab"
Output: 1
Explanation: The palindrome partitioning
["aa","b"] could be produced using 1 cut.*/
/*This can be solved by two points:
cut[i] is the minimum of cut[j - 1] + 1 (j <= i), if [j, i] is palindrome.
If [j, i] is palindrome, [j + 1, i - 1] is palindrome, and c[j] == c[i].
The 2nd point reminds us of using dp (caching).
a   b   a   |   c  c
                j  i
       j-1  |  [j, i] is palindrome
   cut(j-1) +  1*/
class Sln{
    public int minCut(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }
}