/*
str = "aabbcc", k = 3
Result: "abcabc"
The same letters are at
least distance 3 from each other.
 */
class Soln2{
    public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0
                || k > s.length()) return s;

        // Create a frequency map of characters in the string
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray())
            frequencyMap.merge(c, 1, Integer::sum);

        // We need to get the max frequent ones at first,
        // to ensure that characters can be placed k distance apart
        // Hence, heap is used
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<Map.Entry<Character, Integer>>(
                        (a, b) -> (a.getValue() == b.getValue() ?
                                a.getKey().compareTo(b.getKey()) :
                                Integer.compare(b.getValue(), a.getValue()))
                );

        // Add all map entries into the heap
        maxHeap.addAll(frequencyMap.entrySet());

        // Since each character must be apart k distance, keep a queue for storing all previously seen characters
        Queue<Map.Entry<Character, Integer>> previousEntries = new LinkedList<>();
        StringBuilder sb = new StringBuilder(s.length());

        while (!maxHeap.isEmpty()) {
            // Insert the character
            Map.Entry<Character, Integer> current = maxHeap.poll();
            sb.append(current.getKey());
            current.setValue(current.getValue() - 1);
            // Current becomes previous into the queue
            previousEntries.add(current);
            // As long as the number of characters in the previous entries is less than k, do nothing
            if (previousEntries.size() < k)
                continue;
            // Once the previous entries queue is of size k, then evict the first element and enqueue it
            // only when its frequency is positive
            Map.Entry<Character, Integer> firstPrevious = previousEntries.poll();
            if (firstPrevious.getValue() > 0)
                maxHeap.offer(firstPrevious);
        }
        // Only when the result string is of same length as input string, that's success, else return empty result
        return sb.length() == s.length() ? sb.toString() : "";
    }
}