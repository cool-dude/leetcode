/*LC17. Letter Combinations of a Phone Number
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
Given a string containing digits from 2-9 inclusive,
return all possible letter combinations

A mapping of digit to letters (just like on the
telephone buttons) is given below. Note that
* 1 does not map to any letters.

Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:*/
class Sln {
    List<String> output = new ArrayList<String>();
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    void backtrack(String combination, String next_digits){
        if(next_digits.length()==0) {
            output.add(combination);
            return;
        }
        else {
            /*public String substring(int begIndex, int endIndex)
            beginIndex :  the begin index, inclusive.
            endIndex :  the end index, exclusive.
            Return Value : The specified substring.*/
            String digit=next_digits.substring(0,1);
            String letters=phone.get(digit);
            for(int i=0;i<letters.length();i++){
                String letter=letters.substring(i,i+1);
                /*public String substring(int begIndex)
                begIndex : the begin index, inclusive.
                Return Value : The specified substring.*/
                backtrack(combination+letter,next_digits.substring(1));
            }
        }
    }
    public List<String> letterCombinations(String digits){
        if(digits.length()!=0)
            backtrack("",digits);
        return output;
    }
}