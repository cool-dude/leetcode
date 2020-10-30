/*Input: str = "abaaa"
Output:  Below are 5 palindrome sub-strings
a
aa
aaa
aba
b

Input: str = "geek"
Output:  Below are 4 palindrome sub-strings
e
ee
g
k*/
class Sln{
    HashSet<String> set;
    public List<String> uniqPalindromicsSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<String>();
        }
        set=new HashSet<>();
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1); // even length
        }
        return new ArrayList<String>(set);
    }
    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right) && s.charAt(i)) {
            if(!set.contains(s.substring(left,right+1)))
                set.add(s.substring(left,right+1));
            left--; right++;
        }
    }
}