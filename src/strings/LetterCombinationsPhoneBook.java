/*LC17: Letter Combinations of a Phone Number
* https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
Given a string containing digits from 2-9
* inclusive, return all possible letter
* combinations that the number could represent.

A mapping of digit to letters (just like on the
* telephone buttons) is given below. Note that 1 does not map to any letters.

Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].*/
class Sln1{
    void helper(String digits,int idx,HashMap<Character,char[]> dict,List<String> res,char[] arr){
        if(idx==digits.length()){
            res.add(new String(arr));
            return;
        }
        char num=digits.charAt(idx);
        char[] candidates=dict.get(num);
        for(int i=0;i<candidates.length;i++){
            arr[idx]=candidates[i];
            helper(digits,idx+1,dict,res,arr);
        }
    }
    public List<String> letterCombinations(String digits){
        HashMap<Character, char[]> phoneMap=new HashMap<Character, char[]>();
        phoneMap.put('2',new char[]{'a','b','c'});
        phoneMap.put('3',new char[]{'d','e','f'});
        phoneMap.put('4',new char[]{'g','h','i'});
        phoneMap.put('5',new char[]{'j','k','l'});
        phoneMap.put('2',new char[]{'m','n','o'});
        phoneMap.put('3',new char[]{'p','q','r','s'});
        phoneMap.put('4',new char[]{'t','u','v'});
        phoneMap.put('5',new char[]{'w','x','y','z'});
        List<String> res=new ArrayList<>();
        if(digits==null||digits.length()==0)
            return res;
        char[] arr=new char[digits.length];
        helper(digits,0,phoneMap,arr);
        return res;
    }
    //T:O(k^n) (k max number of alphabets for any number
    //S:O(1) //hashmap
}

class Sln2{
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> q=new LinkedList<>();
        q.add("");
        while (!q.isEmpty()){
            String str=q.remove();
            if(str.length()==digits.length()){
                ans.add(str);
            }
            else {
                String chars=map[digits.charAt(str.length())];
                for(int i=0;i<chars.length();i++)
                    q.add(str+str.charAt(i));
            }
        }
        return ans;
    }
    //T:exponential
    //S:O(1).
}