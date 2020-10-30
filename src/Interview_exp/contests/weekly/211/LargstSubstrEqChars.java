/*LC1624:Largest Substring Between Two Equal Characters
https://leetcode.com/problems/largest-substring-between-two-equal-characters/
Given a string s, return the length of the
longest substring between two equal characters,
excluding the two characters. If there is no such substring return -1.
A substring is a contiguous sequence of characters within a string.
Example 1:
Input: s = "aa"
Output: 0

Example 2:
Input: s = "abca"
Output: 2
Explanation: The optimal substring here is "bc".

Example 3:
Input: s = "cbzxy"
Output: -1
Explanation: There are no characters that appear twice in s.

Example 4:
Input: s = "cabbac"
Output: 4
Explanation: The optimal substring here is "abba". Other non-optimal substrings include "bb" and "".
Constraints:
1 <= s.length <= 300
s contains only lowercase English letters.*/
class Sln {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] indices=new int[26];
        int max=-1;
        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(indices[idx]>0)
                max=Math.max(max,i-indices[idx]);
            else
                indices[idx]=i+1;
        }
        return max;
    }
}