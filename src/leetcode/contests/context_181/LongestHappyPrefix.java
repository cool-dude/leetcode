/*
* LC1392: Longest Happy Prefix
* https://leetcode.com/problems/longest-happy-prefix/
A string is called a happy prefix
* if is a non-empty prefix which is
* also a suffix (excluding itself).

Given a string s. Return the longest happy prefix of s .
Return an empty string if no such prefix exists.

Example 1:
Input: s = "level"
Output: "l"
Explanation: s contains 4 prefix excluding
* itself ("l", "le", "lev", "leve"), and suffix
("l", "el", "vel", "evel"). The largest prefix which is also suffix is given by "l".

* Example 2:
Input: s = "ababab"
Output: "abab"
Explanation: "abab" is the largest prefix which
* is also suffix. They can overlap in the original string.
Example 3:

Input: s = "leetcodeleet"
Output: "leet"
Example 4:

Input: s = "a"
Output: ""*/
class Sln {
    public String longestPrefix(String s) {
        int pre[]=new int[s.length()];
        int left=0;int right=1;
        while(right<s.length()){
            if(s.charAt(right)==s.charAt(left)){
                pre[right]=left+1;left++;right++;
            }
            else{
                if(left==0)right++;
                else left=pre[left-1];
            }
        }
        if(pre[s.length()-1]==0)return "";
        return s.substring(0,pre[s.length()-1]);
    }
}