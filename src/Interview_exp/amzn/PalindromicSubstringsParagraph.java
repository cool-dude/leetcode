/*Find all substring palindromes in paragraph
which can include space. E.g. “mom mom dad dad”
output would be - “mom”, “dad”, “mom mom”, “dad dad”.
Space by itself cannot be considered a palindrome.

As a follow up I was asked to solve it when this was a huge paragraph instead of just a few words.*/
class Sln1 {
    //return count
    public int countSubstringsWithSpace(String s) {
        int count = 0;
        if (s == null || s.length() == 0) return 0;
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            count+=extendPalindrome(s, i, i)+extendPalindrome(s, i, i + 1); // even length
        }
        return count;
    }
    private int extendPalindrome(String s, int left, int right) {
        int c=0;
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right) && s.charAt(i)!=' ') {
            c++; left--; right++;
        }
        return c;
    }
}

class Sln2{
    //return all possible substrings
    public void printPalindromicSubstringsWithSpace(String s) {
        if (s == null || s.length() == 0) return 0;
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1); // even length
        }
    }
    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right) && s.charAt(i)!=' ') {
            System.out.print(s.substring(left,right+1)+" ");
            left--; right++;
        }
    }
}