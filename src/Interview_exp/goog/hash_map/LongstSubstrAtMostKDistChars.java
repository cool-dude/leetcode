/*LC59: Longest Substring with At Most Two Distinct Characters
https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
Given a string s , find the length of the longest substring t
* that contains at most 2 distinct characters.
Example 1:
Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:
Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.*/
class Sln1 {
    private static int lenLongestSubst2Distinct(String s) {
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
            if (map.size() > 2) {
                max = Math.max(max, i - start);
                while (map.size() > 2) {
                    char t = s.charAt(start);
                    int count = map.get(t);
                    if (count > 1) {
                        map.put(t, count - 1);
                    } else {
                        map.remove(t);
                    }
                    start++;
                }
            }
        }
        max = Math.max(max, s.length() - start);
    }
}
/*LC340: Longest Substring with At Most K Distinct Characters
https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
Given a string, find the length of the longest
substring T that contains at most k distinct characters.

Example 1:
Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.*/
class Sln2{
    public static int lenLongestSubstrKDistinct(String s, int k) {
        int max=0;
        HashMap<Character, Integer> map=new HashMap<Character, Integer>();
        int start=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else{
                map.put(c, 1);
            }
            if(map.size() > k){
                max = Math.max(max, i-start);
                while (map.size() > k){
                    char t = s.charAt(start);
                    int count = map.get(t);
                    if(count>1){
                        map.put(t, count-1);
                    }
                    else{
                        map.remove(t);
                    }
                    start++;
                }
            }
        }
        return Math.max(max, s.length()-start);
    }
}
//T:O(N*k).
//S:O(N).