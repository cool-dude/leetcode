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
    public List<String> letterCombinations(String digits){
        HashMap<Character, String> phone=new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res=new ArrayList<>();
        if(digits==null||digits.length==0)
            return res;
        for(int i=0;i<digits.length();i++){
            List<String> tmp=new ArrayList<>();
            String op=phone.get(digits.charAt(i));
            res.add("");
            for(int j=0;j<res.size();j++){
                for(int k=0;k<op.length();k++){
                    tmp.add(new StringBuilder(res.get(j)).append(op.charAt(k)).toString());
                }
            }
            res.clear();
            res.addAll(tmp);
        }
        return res;
    }
    //T:O(n^3).
    //S:O(n)(not counting phonebook hashmap)
}

class Sln3{
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }
}