/*LC316: Remove Duplicate Letters
https://leetcode.com/problems/remove-duplicate-letters/
Given a string s, remove duplicate letters
so that every letter appears once and only
once. You must make sure your result is
the smallest in lexicographical order among all possible results.
Note: This question is the same as
1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
Example 1:
Input: s = "bcabc"
Output: "abc"

Example 2:
Input: s = "cbacdcbc"
Output: "acdb"*/
class Sln {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}