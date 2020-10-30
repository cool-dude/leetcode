/*LC126. Word Ladder II
https://leetcode.com/problems/word-ladder-ii
Given two words (beginWord and endWord),
and a dictionary's word list, find all shortest
transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list.
Note that beginWord is not a transformed word.

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the sam              e.
Example 1:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
Output:
[
["hit","hot","dot","dog","cog"],
["hit","hot","lot","log","cog"]
]
Example 2:
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.*/
class Sln {
    List<List<String>> result =  new ArrayList<List<String>>();
    Map<String, List<String>> pattern_match = new HashMap<String, List<String>>();
    public List<List<String>> findLadders(String beginWord,
                                          String endWord, List<String> wordList) {
        int length = beginWord.length();
        for(String word : wordList) {
            for(int i=0;i<length;i++) {
                String new_word = word.substring(0,i) + '*' + word.substring(i+1,length);
                List<String> list = pattern_match.getOrDefault(new_word, new ArrayList<>());
                list.add(word);
                pattern_match.put(new_word, list);
            }
        }
        Map<String, Boolean> visited = new HashMap<>();
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        HashMap<String, Integer> restore = new HashMap<>();
        queue.add(new Pair(beginWord, 1));
        restore.put(beginWord, 1);
        visited.put(beginWord, true);
        while(!queue.isEmpty()) {
            Pair<String, Integer> queued_word = queue.remove();
            int manipulations = queued_word.getValue();
            String key_word = queued_word.getKey();
            boolean found = false;

            for (int i = 0; i < length; i++) {
                String newWord = key_word.substring(0, i) + '*' + key_word.substring(i + 1, length);
                for(String word : pattern_match.getOrDefault(newWord, new ArrayList<>())) {
                    if(word.equals(endWord))
                        found = true;
                    if(!visited.containsKey(word)) {
                        visited.put(word, true);
                        restore.put(word, manipulations+1);
                        queue.add(new Pair(word,manipulations+1));
                    }
                }
            }
            if(found)
                break;
        }
        DFS(beginWord, endWord, restore, new ArrayList<>(), pattern_match);
        return result;
    }
    public void DFS(String beginWord, String endWord,  HashMap<String, Integer> restore,
                    List<String> solution, Map<String, List<String>> pattern_match) {
        solution.add(beginWord);
        if(endWord.equals(beginWord)) {
            if(!result.contains(solution))
                result.add(new ArrayList(solution));
        }
        else {
            for (int i = 0; i < beginWord.length(); i++) {
                String newWord = beginWord.substring(0, i) + '*' + beginWord.substring(i + 1, beginWord.length());
                for(String word : pattern_match.getOrDefault(newWord, new ArrayList<>())) {
                    if (restore.getOrDefault(word,0) == restore.getOrDefault(beginWord,0) + 1) {
                        DFS(word, endWord, restore, solution, pattern_match);
                    }
                }
            }
        }
        solution.remove(solution.size()-1);
    }
}