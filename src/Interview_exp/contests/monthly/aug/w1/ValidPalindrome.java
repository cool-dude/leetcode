/*LC125: Valid Palindrome
https://leetcode.com/problems/valid-palindrome/
Given a string, determine if it is a palindrome,
considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem,
we define empty string as valid palindrome.

Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:
Input: "race a car"
Output: false

Constraints:
s consists only of printable ASCII characters.*/
class Sln {
    public boolean isPalindrome(String s) {
        int l=0,r=s.length()-1;
        while(l<s.length() && r>=0 && l<r){
            if(!Character.isLetterOrDigit(s.charAt(l)))
                l++;
            else if(!Character.isLetterOrDigit(s.charAt(r)))
                r--;
            else if(Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))){
                l++;
                r--;
            }
            else
                return false;
        }
        return true;
    }
}