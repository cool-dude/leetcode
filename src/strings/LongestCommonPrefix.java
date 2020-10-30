/*LC14: Largest Common Prefix
https://leetcode.com/problems/longest-common-prefix/
Write a function to find the longest common prefix string amongst an array of strings.

Example 1:
Input: ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.*/
class Sln{
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            /*Syntax:
            public int indexOf(int ch )
            ch : a character.*/
            while (strs[i].indexOf(prefix)==-1){
                prefix=prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
    }
}