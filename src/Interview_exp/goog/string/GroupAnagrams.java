/*LC49: Group Anagrams
* https://leetcode.com/problems/group-anagrams/
* Given an array of strings, group anagrams together.
Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]*/
class Sln{
    public List<List<String>> groupAnagrams(String[] strs){
        if(strs.length==0||strs==null) return new ArrayList();
        Map<String,List> map=new HashMap<>();
        int[] cnt=new int[26];
        for(String str:strs){
            Arrays.fill(cnt,0);
            for(char c:str.toCharArray()) cnt[c-'a']++;
            StringBuilder sb=new StringBuilder("");
            for(int i=0;i<26;i++){
                sb.append('#');
                sb.append(cnt[i]);
            }
            String ky=sb.toString();
            if(!map.containsKey(ky)) map.put(ky, new ArrayList<>());
            map.get(ky).add(str);
        }
        return new ArrayList(map.values());
    }
}