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

class Sln2{
    public String longestPrefix(String str){
        int n=str.length();
        int[] lps=new int[n];
        lps[0]=0;
        int len=0,i=1;
        while (i<n){
            if(str.charAt(i)==str.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            // (str[i] != str[len])
            else {
                // This is tricky. Consider
                // the example. AAACAAAA
                // and i = 7. The idea is
                // similar to search step.
                if (len != 0) {
                    len = lps[len-1];
                    // Also, note that we do
                    // not increment i here
                }
                // if (len == 0)
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return str.substring(0,lps[n-1]);
    }
}