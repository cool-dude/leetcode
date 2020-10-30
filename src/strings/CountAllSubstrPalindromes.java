/*LC647: Palindromic Substrings
* https://leetcode.com/problems/palindromic-substrings/
Given a string, your task is to count how
* many palindromic substrings in this string.
The substrings with different start indexes or end
* indexes are counted as different substrings even they consist of same characters.
Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".*/
class Sln1 {
    int extendPalindrome(String s, int left, int right) {
        int count=0;
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
        return count;
    }
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            count+=extendPalindrome(s, i, i); // odd length;
            count+=extendPalindrome(s, i, i + 1); // even length
        }
        return count;
    }
    //T:O(N^2).
    //S:O(1)(except recursion stack space).
}
/*Print all palindromic substrings
Input: str = "abaaa"
Output:  Below are 5 palindrome sub-strings
a
aa
aaa
aba
Input: str = "geek"
Output:  Below are 4 palindrome sub-strings
e
ee
g
k*/
class Sln2{
    Set<String> set;
    public List<String> unqPalindromicSubstrings(String s){
        if(s==null||s.length()==0)
            return new ArrayList<String>();
        set=new HashSet<>();
        for(int i=0;i<s.length();i++){//i is mid-point
            extendPalindrome(s,i,i);
            extendPalindrome(s,i,i+1);
        }
        return new ArrayList<String>(set);
    }
    void extendPalindrome(String s,int left,int right){
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            if(!set.contains(s.substring(left,right+1)))
                set.add(s.substring(left,right+1));
            left++;right--;
        }
    }
}