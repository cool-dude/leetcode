class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return double[]{};
        }
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int i = 0; i < nums.length; i++) {
            // add new element into one of the heap
            if (maxHeap.isEmpty() || nums[i] < maxHeap.peek()) {
                maxHeap.offer(nums[i]);
            }
            else {
                minHeap.offer(nums[i]);
            }
            // remove element outside window
            if (i >= k) {
                if (nums[i - k] <= maxHeap.peek()) {
                    maxHeap.remove(nums[i - k]);
                }
                else {
                    minHeap.remove(nums[i - k]);
                }
            }
            // balance two heaps, make sure
            // maxHeap contains one
            // more element if k odd.
            while (minHeap.size() >= maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            while (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }
            // add result
            if (i >= k - 1) {
                result.add(maxHeap.peek());
            }
        }
        return result.stream().mapToDouble(i->i).toArray();
    }

    public double[] medianSlidWindow(int[] nums,int k){
        if(nums==null||nums.length==0||k==0)
            return double[]{};
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for(int i=0;i<nums.length;i++){
            //add new element max
            if(maxHeap.isEmpty() || nums[i]<maxHeap.peek()){
                maxHeap.offer(nums[i]);
            }
            else{
                minHeap.offer(nums[i]);
            }
            // remove element outside window
            if (i >= k) {
                if(nums[i-k] <= maxHeap.peek()){
                    maxHeap.remove(nums[i-k]);
                }
                else {
                    minHeap.remove(nums[i-k]);
                }
            }
            // balance 2 heaps, make sure
            // maxHeap contains one
            // more element if k odd.
            while (minHeap.size() >= maxHeap.size()+1) {
                maxHeap.offer(minHeap.poll());
            }
            while (maxHeap.size() > minHeap.size()+1) {
                minHeap.offer(maxHeap.poll());
            }
            // add result
            if (i >= k - 1) {
                result.add(maxHeap.peek());
            }
        }
        return result.stream().mapToDouble(i->i).toArray();
    }
}
//T:O(N*K*logK).