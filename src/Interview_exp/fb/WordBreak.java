/*LC139: Word Break
Given a non-empty string s and a
* dictionary wordDict containing a
* \list of non-empty words, determine
* if s can be segmented into a
* space-separated sequence of one or more dictionary words.

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false*/
public class Soln {
    public boolean wordBreak(String s,
                             Set<String> dict) {
        return wordBreakHelper(
                s, dict, 0);
    }

    public boolean wordBreakHelper(
            String s,
            Set<String> dict,
            int start) {
        if (start == s.length())
            return true;
        for (String word : dict) {
            int len = word.length();
            int end = start + len;
            //end idx be
            //<= string len
            if (end > s.length())
                continue;
            if (s.substring(start, start + len).equals(word))
                if (wordBreakHelper(s, dict, start + len))
                    return true;
        }
        return false;
    }

    public boolean wordBreakDP(String s,
                               Set<String> dict) {
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true;
        //set first to be true,
        //why? Because we need
        //initial state
        for (int i = 0; i < s.length(); i++) {
            //should continue
            //match position
            if (!t[i]) continue;

            for (String word : dict) {
                int len = word.length();
                int end = i + len;
                if (end > s.length())
                    continue;
                if (t[end])
                    continue;
                if (s.substring(i, end).equals(word)) {
                    t[end] = true;
                }
            }
        }
        return t[s.length()];
    }
}

class Sln {
    public boolean wordBreak(String s, Set<String> dict) {
        int[] pos = new int[s.length() + 1];
        Arrays.fill(pos, -1);
        pos[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            if (pos[i] != -1) {
                for (int j = i + 1; j <= s.length(); j++) {
                    String sub = s.substring(i, j);
                    if (dict.cotains(sub)) {
                        pos[j] = i;
                    }
                }
            }
        }
        return pos[s.length()] != -1;
    }
    //T:O(n^2)
    //S:O(n)
    public void wordBreakDP(String str,Set<String> dict){
       boolean[] dp=new boolean[s.length()+1];
       dp[0]=true;
       //set first to be truewhy? Because we need
        //initial state
        for(int i=0;i<str.length();i++){
            if(!dp[i]) continue;
            for(String word:dict){
                int len=word.length();
                int end=i+len;
                if(end>str.length()) continue;
                if(dp[end]) continue;
                if(str.substring(i,end).equals(word)){
                    dp[end]=true;
                }
            }
        }
        return dp[str.length()];
    }
    //T:O(n*MAx(word_legth))
    //S:O(n)
}