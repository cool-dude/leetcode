/*LC1433: Check If a String Can Break Another String
https://leetcode.com/problems/check-if-a-string-can-break-another-string/
Given two strings: s1 and s2 with the same size,
check if some permutation of string s1 can break
some permutation of string s2 or vice-versa (in other words s2 can break s1).

A string x can break string y (both of size n)
if x[i] >= y[i] (in alphabetical order) for all i between 0 and n-1.

Example 1:
Input: s1 = "abc", s2 = "xya"
Output: true
Explanation: "ayx" is a permutation of s2="xya" which can break to string "abc" which is a permutation of s1="abc".

Example 2:
Input: s1 = "abe", s2 = "acd"
Output: false
Explanation: All permutations for s1="abe" are: "abe", "aeb", "bae", "bea", "eab" and "eba" and all permutation for s2="acd" are: "acd", "adc", "cad", "cda", "dac" and "dca". However, there is not any permutation from s1 which can break some permutation from s2 and vice-versa.

Example 3:
Input: s1 = "leetcodee", s2 = "interview"
Output: true*/
class Sln {
    boolean possible(int[] s1F,int[] s2F){
        int b=0,s=0;
        for(int i=0;i<26;i++){
            b+=s1F[i];
            s+=s2F[i];
            if(b>s)
                return false;
        }
        return true;
    }
    public boolean checkIfCanBreak(String s1, String s2) {
        int [] s1F = new int[26];
        int [] s2F = new int[26];
        for(char c: s1.toCharArray()) s1F[c - 'a']++;
        for(char c: s2.toCharArray()) s2F[c - 'a']++;
        return possible(s1F,s2F) || possible(s2F,s1F);
    }
}