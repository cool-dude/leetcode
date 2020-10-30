/*LC205:Isomorphic Strings
https://leetcode.com/problems/isomorphic-strings/
Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be
* replaced to get t.
All occurrences of a character must be replaced with another
* character while preserving the order of characters.
* No two characters may map to the same character but a character may map to itself.
Example 1:
Input: s = "egg", t = "add"
Output: true
Example 2:
Input: s = "foo", t = "bar"
Output: false
Example 3:
Input: s = "paper", t = "title"
Output: true
Note:*/
class Sln{
    public boolean isIsoMorph(String s,String t){
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            }
            else {
                map.put(c1, c2);
            }
        }
        HashSet<Character> set = new HashSet<>(map.values());
        if (set.size() == map.keys().size()) {
            return true;
        }
        return false;
    }
}