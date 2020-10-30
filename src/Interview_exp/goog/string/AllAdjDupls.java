/*LC1047: Remove All Adjacent Duplicates In String
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
Given a string S of lowercase letters, a duplicate
removal consists of choosing two adjacent and
equal letters, and removing them.
We repeatedly make duplicate removals on S until we no longer can.
Return the final string after all such duplicate
removals have been made.  It is guaranteed the answer is unique.
Example 1:
Input: "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the
letters are adjacent and equal, and this is the only possible move.
 The result of this move is that the string is "aaca",
 of which only "aa" is possible, so the final string is "ca".*/
class Sln1{
    public String removeDuplicates(String s) {
        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[i]) // count = 2
                i -= 2;
        }
        return new String(res, 0, i);
    }
}
/*LC1209: Remove All Adjacent Duplicates in String II
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
Given a string s, a k duplicate removal consists
of choosing k adjacent and equal letters from s
and removing them causing the left and the
right side of the deleted substring to concatenate together.
We repeatedly make k duplicate removals on s
until we no longer can.
Return the final string after all such duplicate removals have been made.
It is guaranteed that the answer is unique.
Example 1:
Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:
Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:
Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"*/
class Sln2 {
    public String removeDuplicates(String s, int k) {
        Stack<Integer> counts = new Stack<>();
        char[] sa = s.toCharArray();
        int j = 0;
        for (int i = 0; i < s.length(); ++i, ++j) {
            sa[j] = sa[i];
            if (j == 0 || sa[j] != sa[j - 1]) {
                counts.push(1);
            }
            else {
                int incremented = counts.pop() + 1;
                if (incremented == k) {
                    j = j - k;
                }
                else {
                    counts.push(incremented);
                }
            }
        }
        return new String(sa, 0, j);
    }
}