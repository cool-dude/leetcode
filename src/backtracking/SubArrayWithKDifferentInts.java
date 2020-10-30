/*LC992. Subarrays with K Different Integers
* https://leetcode.com/problems/subarrays-with-k-different-integers/
Given an array A of positive integers, call a
* (contiguous, not necessarily distinct) subarray of
* A good if the number of different integers in that subarray is exactly K.
(For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
Return the number of good subarrays of A.

Example 1:
Input: A = [1,2,1,2,3], K = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different
* integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].

* Example 2:
Input: A = [1,2,1,3,4], K = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers:
* [1,2,1,3], [2,1,3], [1,3,4].
* Intuition
For convenience,
* let's denote subarrays by tuples: (i,j) = [A[i], A[i+1], ..., A[j]],
* and call a subarray valid if it has K different integers.

For each j, let's consider the set Sj
​of all i such that the subarray (i, j) is valid.

Firstly, Sj must be a contiguous interval.
* If i1 < i2 < i3, (i1,j) and (i3,j) are valid,
* but (i2,j) is not valid, this is a contradiction
* because (i2,j) must contain more than K different elements
* [as (i3,j) contains K], but (i1,j) [which is a superset of (i2,j)] only contains K different integers.

So now let's write Sj as intervals: Sj = [left1j, left2j]
The second observation is that the endpoints of these
* intervals must be monotone increeasing - namely, left1j and left2j​
  are monotone increasing. With similar logic to the above,
  * we could construct a proof of this fact, but the
  * intuition is that after adding an extra
  * element to our subarrays, they are already
  * valid, or we need to shrink them a bit to keep them valid.*/
class Window{
    Map<Integer, Integer> count;
    int distinctCount;
    Window(){
        count=new HashMap<>();
    }
    void add(int x){
        count.put(x, count.getOrDefault(x,0)+1);
        if(count.get(x)){
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
class Sln{
    public int subarraysWithKDistinct(int[] arr, int k) {
        Window w1=new Window();
        Window w2=new Window();
        int ans=0,l1=0,l2=0;
        for(int r=0;r<arr.length;r++){
            int x=arr[r];
            w1.add(x);
            w2.add(x);
            while (w1.distinctCount()>k){
                w1.remove(arr[l1++]);
            }
            while (w2.distinctCount()>=k){
                w2.remove(arr[l2++]);
            }
            ans+=l2-l1;
        }
        return ans;
    }
}