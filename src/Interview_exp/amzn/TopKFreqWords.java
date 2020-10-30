/*LC692: Top K Frequent Words
* https://leetcode.com/problems/top-k-frequent-words/
Given a non-empty list of words,
* return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest.
* If two words have the same frequency,
* then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.*/
import java.utils.*;
class Sln{
    public List<Strig> topKFrequent(String[] words, int k) {
        Map<String, Integer> count=new HashMap();
        for(String word:words){
            count.put(word, count.getOrDefault(word, 0)+1);
        }
        List<String> candidates=new ArrayList(count.keySet());
        Collections.sort(candidates, (w1,w2)->count.get(w1).equals(count.get(w2))?
                w1.compareTo(w2):count.get(w2)-count.get(w1));
        return candidates.subList(0,k);
    }
    //T:O(nlgn).
    //S:O(n)

    public List<String> topKFrequent(String[] words,int k){
        Map<String, Integer> count=new HashMap<>();
        for(String word:words){
            count.put(word,count.getOrDefault(word,0)+1);
        }
        //min-heap
        PriorityQueue<String> minHeap=new PriorityQueue<Strinng>(
                (w1,w2)->count.get(w1).equals(count.get(w2))?
                        w2.compareTo(w1):count.get(w1)-count.get(w2));
        for(String word:words){
            minHeap.offer(word);
            if(minHeap.size()>k) minHeap.poll();
        }
        List<String> ans=new ArrayList<>();
        while (!minHeap.isEmpty()) ans.add(minHeap.poll());
        Collections.sort(ans, Collections.reverseOrder());
        return ans;
    }
    //T:O(nlgk)
    //S:O(n)
}