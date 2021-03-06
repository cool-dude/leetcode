package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinctCharacters lsk = new LongestSubstringWithAtMostKDistinctCharacters();
        System.out.println(lsk.lengthOfLongestSubstringKDistinct("aa", 2));
        System.out.println(lsk.lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println(lsk.lengthOfLongestSubstringKDistinct("abaccc", 2));
        System.out.println(lsk.lengthOfLongestSubstringKDistinct("bacc", 2));
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n * k == 0) return 0;

        // sliding window left and right pointers
        int left = 0;
        int right = 0;
        // hashmap character -> its rightmost position
        // in the sliding window
        LinkedHashMap<Character, Integer> hashmap = new LinkedHashMap<Character, Integer>(k + 1);
        int max_len = 1;
        while (right < n) {
            Character character = s.charAt(right);
            // if character is already in the hashmap -
            // delete it, so that after insert it becomes
            // the rightmost element in the hashmap
            if (hashmap.containsKey(character))
                hashmap.remove(character);
            hashmap.put(character, right++);

            // slide window contains k + 1 characters
            if (hashmap.size() == k + 1) {
                // delete the leftmost character
                Map.Entry<Character, Integer> leftmost = hashmap.entrySet().iterator().next();
                hashmap.remove(leftmost.getKey());
                // move left pointer of the slidewindow
                left = leftmost.getValue() + 1;
            }

            max_len = Math.max(max_len, right - left);
        }
        return max_len;
    }
}
