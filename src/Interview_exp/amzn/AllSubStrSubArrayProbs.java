/*LC3: Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/
Given a string, find the length of the longest substring without repeating characters.
Example 1:
Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.*/
/*basic idea is, keep a hashmap
which stores the characters in string
as keys and their positions as values,
and keep two pointers which define the
max substring. move the right pointer to
scan through the string , and meanwhile
update the hashmap. If the character is
already in the hashmap, then move the left
pointer to the right of the same character
last found. Note that the two pointers can only move forward. */
class Sln{
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for(int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
/*LC992: Subarrays with K Different Integers
https://leetcode.com/problems/subarrays-with-k-different-integers/
Given an array A of positive integers,
call a (contiguous, not necessarily distinct)
subarray of A good if the number of different integers in that subarray is exactly K.
(For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
Return the number of good subarrays of A.
Example 1:
Input: A = [1,2,1,2,3], K = 2
Output: 7
Explanation: Subarrays formed with exactly 2
different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].

Example 2:
Input: A = [1,2,1,3,4], K = 3
Output: 3
Explanation: Subarrays formed with exactly
3 different integers: [1,2,1,3], [2,1,3], [1,3,4].*/
class Window{
    Map<Integer, Integer> count;
    int distinctCount;
    Window(){
        count=new HashMap<>();
    }
    void add(int x){
        count.put(x, count.getOrDefault(x,0)+1);
        if(count.get(x)==1){
            distinctCount++;
        }
    }
    void remove(int x){
        count.put(x, count.get(x)-1);
        if(count.get(x)==0){
            distinctCount--;
        }
    }
    int getDistinctCount(){
        return distinctCount;
    }
}
class Sln2{
    public int subarraysWithKDistinct(int[] arr, int k) {
        Window w1=new Window();
        Window w2=new Window();
        int ans=0,l1=0,l2=0;
        for(int r=0;r<arr.length;r++){
            int x=arr[r];
            w1.add(x);
            w2.add(x);

            while (w1.getDistinctCount()>k){
                w1.remove(arr[l1++]);
            }
            while (w2.getDistinctCount()>=k){
                w2.remove(arr[l2++]);
            }
            ans+=l2-l1;
        }
        return ans;
    }
}