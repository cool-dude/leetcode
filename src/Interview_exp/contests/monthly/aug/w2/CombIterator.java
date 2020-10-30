/*LC1286: Iterator for Combination
https://leetcode.com/problems/iterator-for-combination/
Design an Iterator class, which has:

A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.

Example:
CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.
iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false

Constraints:
1 <= combinationLength <= characters.length <= 15
There will be at most 10^4 function calls per test.
It's guaranteed that all calls of the function next are valid*/
class CombinationIterator {
    Queue<String> queue;
    public CombinationIterator(String chars, int combLen) {
        queue = new LinkedList();
        combinations(chars, 0, "", combLen);
    }
    public void combinations(String chars, int start, String soFar, int k) {
        if (k == 0) {
            queue.add(soFar);
            return;
        }
        for(int i = start; i < chars.length(); i++) {
            combinations(chars, i + 1, soFar + chars.charAt(i), k - 1);
        }
    }
    public String next() {
        return queue.poll();
    }
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
/**Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();*/