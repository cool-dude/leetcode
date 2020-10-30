/*LC472: Concatenated Words
https://leetcode.com/problems/concatenated-words/
Given a list of words (without duplicates),
please write a program that returns all
concatenated words in the given list of words.
A concatenated word is defined as a string that is
comprised entirely of at least two shorter words in the given array.
Example:
Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
"dogcatsdog" can be concatenated by "dog", "cats" and "dog";
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
Note:
The number of elements of the given array will not exceed 10,000
The length sum of elements in the given array will not exceed 600,000.
All the input string will only include lower case letters.
The returned elements order does not matter.*/
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class Sln{
    boolean wordCanForm(String word, Set<String> dict){
        boolean[] dp=new boolean[word.length()+1];
        dp[0]=true;
        for(int i=1;i<=word.length();i++){
            for(int j=0;j<i;j++){
                //public String substring(int begIndex, int endIndex)
                //beginIndex :  the begin index, inclusive.
                //endIndex :  the end index, exclusive.
                String subStr=word.substring(j,i);
                if(dp[j] && dict.contains(subStr)){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<Strig> ans=new ArrayList<>();
        Set<String> dict=new HashSet<>();
        if(words.length==1){
            return ans;
        }
        for(String word:words){
            dict.add(word);
        }
        for(String word:words){
            int len=word.length();
            if(len==0) {
                continue;
            }
            else{
                dict.remove(word);
                if(wordCanForm(word, dict)){
                    ans.add(word);
                }
                dict.add(word);
            }
        }
        return ans;
    }
}