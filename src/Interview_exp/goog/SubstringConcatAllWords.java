/*LC30. Substring with Concatenation of All Words
* https://leetcode.com/problems/substring-with-concatenation-of-all-words/
You are given a string, s, and a list of words,
* words, that are all of the same length.
* Find all starting indices of substring(s) in s
* that is a concatenation of each word in words
* exactly once and without any intervening characters.
Example 1:
Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
*
Example 2:
Input:
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
Output: []*/
class Sln{
    public List<Integer> findSubstring(String s, String[] words) {
        if(words.length == 0 || s.length() < (words.length * words[0].length())){
            return new ArrayList<Integer>();
        }
        List<Integer> ans=new ArrayList<Integer>();
        int start = 0;
        int end = 0;
        int incr = words[0].length();
        HashMap<String, Integer> patMap = new HashMap<>();
        for(int i=0;i<words.length;i++){
            patMap.put(words[i], patMap.getOrDefault(words[i], 0)+1);
        }
        HashMap<String, Integer> searchMap = new HashMap<>();
        int c = 0;
        int maxStart = s.length()-(words.length * words[0].length());
        while (start<=maxStart && end+incr<=s.length()){
            String word = s.substring(end, end+incr);
            int freqNow = searchMap.getOrDefault(word, 0);
            int reqFreq = patMap.getOrDefault(word, 0);
            freqNow++;
            if(freqNow <= reqFreq){
                end += incr;
                c++;
                searchMap.put(word, freqNow);
            }
            if(c==words.length){
                ans.add(start);
            }
            if(reqFreq==0||freqNow > reqFreq||c==words.length){
                start++;
                end=start;
                searchMap=new HashMap<>();
                c=0;
            }
        }
        return ans;
    }
}
class Sln2 {
    public List<Integer> findSubstring(String s, String[] words) {
        if(words.length == 0 || s.length() < (words.length * words[0].length())){
            return new ArrayList<Integer>();
        }
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        List<Integer> indexes = new ArrayList<>();
        int n = s.length(), num = words.length, len = words[0].length();
        for (int i = 0; i < n - num * len + 1; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                String word = s.substring(i + j * len, i + (j + 1) * len);
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                }
                else {
                    break;
                }
                j++;
            }
            if (j == num) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}