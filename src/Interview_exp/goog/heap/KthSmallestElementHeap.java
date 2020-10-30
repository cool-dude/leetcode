class Sln {
    public int findKthSmallestElementUsingHeap(int a[], int k) {
        //https://stackoverflow.com/questions/11003155/change-priorityqueue-to-max-priorityqueue
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(k, Collections.reverseOrder());

        if (a == null || k > a.length) return -1;
        //Create max with first k elements
        for (int i = 0; i < k; i++) {
            maxHeap.add(a[i]);
        }
        /*Keep updating max heap based on new element
        If new element is less than root,
        remove root and add new element*/
        for (int i = k; i < a.length; i++) {
            if (maxHeap.peek() > a[i]) {
                maxHeap.remove();
                maxHeap.add(a[i]);
            }
        }
        return maxHeap.peek();
    }
}