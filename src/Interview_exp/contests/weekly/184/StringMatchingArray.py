'''
LC1408: String Matching in an Array
https://leetcode.com/problems/string-matching-in-an-array/
Given an array of string words. Return
all strings in words which is substring
of another word in any order.
Ex 1:
Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.
Ex 2:
Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".
ort words with length first.
Then build a suffix trie for each word and check if it already existed.

Time: O(NlogN + N * S^2), where S is the max length of all words.
NlogN for sorting and N * S^2 for build suffix trie.

Space: O(N * S^2) for suffix trie
'''
class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        def add(word: str):
            node = trie
            for c in word:
                node = node.setdefault(c, {})

        def get(word: str) -> bool:
            node = trie
            for c in word:
                if (node := node.get(c)) is None: return False
            return True
        words.sort(key=len, reverse=True)
        trie, result = {}, []
        for word in words:
            if get(word): result.append(word)
            for i in range(len(word)):
                add(word[i:])
        return result