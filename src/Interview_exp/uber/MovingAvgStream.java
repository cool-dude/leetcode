class MovingAverage {
    double sum;
    int size;
    LinkedList<Integer> list;
    /** Initialize your data structure here. */
    public MovingAverage(int _size) {
        list = new LinkedList<>();
        size = _size;
        sum = 0;
    }
    public double next(int val) {
        sum += val;
        list.offer(val);
        if(list.size() <= size){
            return (sum/list.size());
        }
        sum -= list.poll();
        return sum/size;
    }
}