/*LC347: Top K Frequent Elements
Given a non-empty array of integers,
return the k most frequent elements.
Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.*/
class Sln {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int num: nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        for(int key: hm.keySet()){
            int frequency = hm.get(key);
            if(bucket[frequency] == null)
                bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }
        List<Integer> res=new ArrayList<>();
        for(int pos = bucket.length-1; pos >= 0 && k>0; pos--){
            if(bucket[pos] != null){
                res.addAll(bucket[pos]);
                k-=bucket[pos].size();
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}