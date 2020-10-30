/*LC395: Longest Substring with At Least K Repeating Characters
https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
Find the length of the longest substring T of a given string
(consists of lowercase letters only) such that every character
in T appears no less than k times.

Example 1:
Input:
s = "aaabb", k = 3
Output:
3
The longest substring is "aaa", as 'a' is repeated 3 times.

Example 2:
Input:
s = "ababbc", k = 2
Output:
5
The longest substring is "ababb", as 'a'
is repeated 2 times and 'b' is repeated 3 times.
HINT:For each h, apply two pointer technique to
find the longest substring with at least K repeating
characters and the number of unique characters in substring is h*/
class Sln {
    public int longestSubstring(String s, int k) {
        char[] str=s.toCharArray();
        int[] counts=new int[26];
        int i,j,idx,max=0,unq,noLessThanK;
        for(int h=1;h<=26;h++){
            Arrays.fill(counts,0);
            i=0;j=0;
            unq=0;noLessThanK=0;
            while (j<str.length()){
                if(unq<=h){
                    idx=str[j]-'a';
                    if(counts[idx]==0)
                        unq++;
                    counts[idx]++;
                    if(counts[idx]==k)
                        noLessThanK++;
                    j++;
                }
                else {
                    idx=str[i]-'a';
                    if(counts[idx]==k)
                        noLessThanK--;
                    counts[idx]--;
                    if(counts[idx]==0)
                        unq--;
                    i++;
                }
                if(unq==h && unq==noLessThanK)
                    max=Math.max(j-i,max);
            }
        }
        return max;
    }
}