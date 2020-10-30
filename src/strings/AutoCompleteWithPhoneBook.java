/* LC17: Letter Combinations of a Phone Number
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
    public List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> q=new LinkedList<>();
        q.add("");
        while (!q.isEmpty()){
            String str = q.remove();
            if(str.length()==digits.length()){
                ans.add(str);
            }
            else {
                String chars=map[digits.charAt(str.length())];
                for(int i=0;i<chars.length();i++)
                    q.add(str+chars.charAt(i));
            }
        }
        return ans;
    }
    //T:exponential
    //S:O(1).
    public List<String> letterCombinations(String digits){
        List<String> ans=new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] map=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
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
                    q.add(str+chars.charAt(i));
            }
        }
        return ans;
    }
    //T:exponential
    //S:O(1).
}

class AutoCompleteSln{
    private static int SIZE=26;
    class TrieNode{
        String prefix;
        TrieNode children[SIZE];
        boolean isWord;
        public TrieNode(String s){
            prefix=s;
            for(int i=0;i<SIZE;i++)
                children[i]=new TrieNode();
            isWord=false;
        }
    }
    void insert(TrieNode root,String word){
        if(word==null||word.length==0)
            return;
        TrieNode pCrawl=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(pCrawl.children[c-'a']==null)
                pCrawl.children[c-'a']=new TrieNode(word.substring(0,i+1));
            pCrawl=pCrawl.children[c-'a'];
            if(i==word.length()-1) pCrawl.isWord=true;
        }
    }
    public List<String> findAllWords(TrieNode root,String word){
        List<String> results=new ArrayList<>();
        TrieNode pCrawl=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(pCrawl.children[c-'a']!=null)
                pCrawl=pCrawl.children[c-'a'];
            else
                return results;
        }
        findAllChildren(pCrawl,results);
        return results;
    }
    void findAllChildren(TrieNode node,List<String> results){
        if(node.isWord) results.add(node.prefix);
        for(int i=0;i<SIZE;i++){
            if(node.children[i]!=null)
                findAllChildren(node.children[i],results);
        }
    }
    public static void main(String[] args) {
        AutoComplete ac = new AutoComplete();
        String[] words = new String[]{"cat", "ca", "dog", "cats"};
        for (String w : words) {
            ac.insert(w);
        }
        System.out.println(ac.findAllWords("ca"));
    }
}