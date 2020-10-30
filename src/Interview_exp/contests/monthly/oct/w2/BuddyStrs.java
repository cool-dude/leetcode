/*LC859: Buddy Strings
https://leetcode.com/problems/buddy-strings/
Given two strings A and B of lowercase letters,
return true if you can swap two letters in
A so the result is equal to B, otherwise, return false.
Swapping letters is defined as taking two
indices i and j (0-indexed) such that i != j
and swapping the characters at A[i] and A[j].
For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
Example 1:
Input: A = "ab", B = "ba"
Output: true
Explanation: You can swap A[0] = 'a' and A[1] = 'b' to get "ba", which is equal to B.

Example 2:
Input: A = "ab", B = "ab"
Output: false
Explanation: The only letters you can swap are A[0] = 'a' and A[1] = 'b', which results in "ba" != B.

Example 3:
Input: A = "aa", B = "aa"
Output: true
Explanation: You can swap A[0] = 'a' and A[1] = 'a' to get "aa", which is equal to B.

Example 4:
Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true*/
class Sln{
    public boolean buddyString(String a,String b){
        if(a.length()!=b.length()) return false;
        if(a.equals(b)){
            Set<Character> s=new HashSet<>();
            for(char c:a.toCharArray()) s.add(c);
            return s.size()<A.length();
        }
        List<Integer> dif=new ArrayList<>();
        for(int i=0;i<A.length();i++) if(A.charAt(i)!=B.charAt(i)) dif.add(i);
        return dif.size==2 && a.charAt(dif.get(0))==b.charAt(dif.get(1)) && a.charAt(dif.get(1))==b.charAt(dif.get(0));
    }
}