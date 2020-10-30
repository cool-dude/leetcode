/*LC1408: String Matching in an Array
https://leetcode.com/problems/string-matching-in-an-array/
Given an array of string words. Return
all strings in words which is substring
of another word in any order.

Example 1:
Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.

Example 2:
Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".*/
class Sln{
    public List<String> stringMatching(String[] words) {
        List<String> result=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                //https://stackoverflow.com/questions/4089558/what-is-the-big-o-of-string-contains-in-java
                if(words[i].contains(words[j])){
                    if(!result.contains(words[j]))
                        result.add(words[j]);
                }
                //https://stackoverflow.com/questions/4089558/what-is-the-big-o-of-string-contains-in-java
                if(words[j].contains(words[i])){
                    if(!result.contains(words[j]))
                        result.add(words[j]);
                }
            }
        }
        return result;
    }
}