/*
LC748: Shortest Completing Word
https://leetcode.com/problems/shortest-completing-word/
Find the minimum length word from a given
 dictionary words, which has all the letters
 from the string licensePlate. Such a word is
 said to complete the given string licensePlate
 Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.

It is guaranteed an answer exists. If there are multiple answers,
return the one that occurs first in the array.

The license plate might have the same letter occurring multiple times.
For example, given a licensePlate of "PP", the word "pair"
does not complete the licensePlate, but the word "supper" does.

Example 1:
Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
Output: "steps"
Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
Note that the answer is not "step", because the letter "s" must occur in the word twice.
Also note that we ignored case for the purposes of comparing whether a letter exists in the word.

Example 2:
Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
Output: "pest"
Explanation: There are 3 smallest length words that contains the letters "s".
We return the one that occurred first.*/
class Solution {
    boolean matches(String word, int[] charMap){
        int [] targetMap = new int[26];
        for(int i = 0; i < word.length(); i++){
            if(Character.isLetter(word.charAt(i))) targetMap[word.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(charMap[i]!=0 && targetMap[i]<charMap[i]) return false;
        }
        return true;
    }
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String tgt=licensePlate.toLowerCase();
        int[] charMap=new int[26];
        //construct char map
        for(int i=0;i<tgt.length();i++)
            if(Character.isLetter(tgt.charAt(i))) charMap[tgt.charAt(i)-'a']++;
        int min=Integer.MAX_VALUE;
        String res=null;
        for(int i=0;i<words.length;i++){
            String word=words[i].toLowerCase();
            if(matches(word, charMap) && word.length()<min){
                min=word.length();
                res=word;
            }
        }
        return word;
    }
}