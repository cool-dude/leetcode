/*LC392: Is Subsequence
https://leetcode.com/problems/is-subsequence/
Given a string s and a string t,
check if s is subsequence of t.

A subsequence of a string is a new string
which is formed from the original string
by deleting some (can be none) of the
characters without disturbing the relative
positions of the remaining characters.
(ie, "ace" is a subsequence of "abcde" while "aec" is not).

Follow up:
If there are lots of incoming S, say
S1, S2, ... , Sk where k >= 1B, and you want
to check one by one to see if T has its
subsequence. In this scenario, how would you
change your code?

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false*/
class Sln1{
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0) return true;
        int idxS=0,idxT=0;
        while (idxT<t.length()){
            if(t.charAt(idxT)==s.charAt(idxS)){
                idxS++;
                if(idxS==s.length()) return true;
            }
            idxT++;
        }
        return false;
    }
    //T:O(Len(S)*Len(T))
}
// Follow-up: O(N) time for pre-processing, O(Mlog?) for each S.
// Eg-1. s="abc", t="bahbgdca"
// idx=[a={1,7}, b={0,3}, c={6}]
//  i=0 ('a'): prev=1
//  i=1 ('b'): prev=3
//  i=2 ('c'): prev=6 (return true)
// Eg-2. s="abc", t="bahgdcb"
// idx=[a={1}, b={0,6}, c={5}]
//  i=0 ('a'): prev=1
//  i=1 ('b'): prev=6
//  i=2 ('c'): prev=? (return false)
class Sln2 {
    public boolean isSubsequence(String s, String t) {
        List<Integer>[] idx = new List[256]; // Just for clarity
        for (int i = 0; i < t.length(); i++) {
            if (idx[t.charAt(i)] == null)
                idx[t.charAt(i)] = new ArrayList<>();
            idx[t.charAt(i)].add(i);
        }
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            if (idx[s.charAt(i)] == null) return false; // Note: char of S does NOT exist in T causing NPE
            int j = Collections.binarySearch(idx[s.charAt(i)], prev);
            if (j < 0) j = -j - 1;
            if (j == idx[s.charAt(i)].size()) return false;
            prev = idx[s.charAt(i)].get(j) + 1;
        }
        return true;
    }
}