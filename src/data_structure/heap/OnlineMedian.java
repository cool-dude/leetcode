class MedianFinder{
    PriorityQueue<Integer> lo,hi;
    /** initialize your data structure here. */
    public MedianFinder() {
        lo = new PriorityQueue<>((a, b) -> a - b);
        hi = new PriorityQueue<>((a, b) -> b - a);
    }
    public void addNum(int num) {
        if (lo.size() == 0) {
            lo.offer(num);
            return;
        }
        if (lo.size() > hi.size()) {
            if (num >= lo.peek()) {
                lo.offer(num);
                hi.offer(lo.poll());
            }
            else
                hi.offer(num);
        }
        else {
            if (num >= lo.peek())
                lo.offer(num);
            else {
                hi.offer(num);
                lo.offer(hi.poll());
            }
        }
    }
    public double findMedian() {
        if (lo.size() == 0)
            return 0;
        if (lo.size() > hi.size())
            return lo.peek();
        else
            return (lo.peek() + hi.peek()*1.0) / 2;
    }
}