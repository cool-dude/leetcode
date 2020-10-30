/*LC1525: Number of Good Ways to Split a String
You are given a string s, a split is called good
if you can split s into 2 non-empty strings p
and q where its concatenation is equal to s and
the number of distinct letters in p and q are the same.

Return the number of good splits you can make in s.

Example 1:
Input: s = "aacaba"
Output: 2
Explanation: There are 5 ways to split "aacaba" and 2 of them are good.
("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).

Example 2:
Input: s = "abcd"
Output: 1
Explanation: Split the string as follows ("ab", "cd").

Example 3:
Input: s = "aaaaa"
Output: 4
Explanation: All possible splits are good.
Example 4:

Input: s = "acbadbaada"
Output: 2
T:O(26*n)
Hint 1
Define pref[i] as the number of unique characters in
str[0...i]. Can you fill this in a single forward pass? (Use Maps).
Hint 2
Define suff[i] as the number of unique characters in
str[i....]. Can you fill this in a single backward pass? (Use Maps).

Final Algorithm
Fill pref and suff array
Fix the ending point of the first string as i and check
if pref[i] == suff[i +1]. If yes, you have one instance. */
class Sln {
    public int numSplits(String s) {
        int n=s.length();
        Map<Integer,Integer> map=new HashMap<>();
        int[] pref=new int[n];
        int[] suff=new int[n];
        for(int i=0;i<n;i++){
            int cur=s.charAt(i)-'a';
            map.put(cur,map.getOrDefault(cur,0)+1);
            pref[i]=map.keySet().size();
        }
        map.clear();
        for(int i=n-1;i>=0;i--){
            int cur=s.charAt(i)-'a';
            map.put(cur,map.getOrDefault(cur,0)+1);
            suff[i]=map.keySet().size();
        }
        int res=0;
        for(int i=1;i<n;i++){
            if(pref[i-1]==suff[i])
                res++;
        }
        return res;
    }
}