/*LC127: Word Ladder
https://leetcode.com/problems/word-ladder/
Given two words (beginWord and endWord),
* and a dictionary's word list, find the
* length of shortest transformation sequence
* from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
* Note that beginWord is not a transformed word.
* Example 1:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: As one shortest transformation is
* "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

* Example 2:
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
* output: 0
Explanation: The endWord "cog" is not in wordList,
* therefore no possible transformation.*/
import java.util.*;
class Sln {
    static HashSet<String> set;
    static HashSet<Character> chars;
    public static void main(String[] args) {
        set = new HashSet();
        chars = new HashSet();
        String[] strings = new String[]{"hot", "dot", "dog", "lot", "log","cog"};
        Arrays.stream(strings)
                .forEach(word -> {
                    set.add(word);
                    word.chars()
                            .mapToObj(c -> (char) c)
                            .forEach(v -> chars.add(v));
                });
        chars.forEach(character -> System.out.println(character));
        System.out.println(ladderLength("hit", "cog", Arrays.asList(strings)));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> words = new HashSet<>(wordList);
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                List<String> candidates = transform(words, word);
                for (String candidate: candidates) {
                    if (endWord.equals(candidate)) {
                        return count;
                    }
                    queue.offer(candidate);
                }
            }
        }
        return 0;
    }
    static List<String> transform(Set<String> words, String word) {
        List<String> candidates = new ArrayList<>();
        StringBuffer sb = new StringBuffer(word);
        for (int i = 0; i < sb.length(); i++) {
            char temp = sb.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (temp == c) {
                    continue;
                }
                sb.setCharAt(i, c);
                String newWord = sb.toString();
                if (words.remove(newWord)) {
                    candidates.add(newWord);
                }
            }
            sb.setCharAt(i, temp);
        }
        return candidates;
    }
}