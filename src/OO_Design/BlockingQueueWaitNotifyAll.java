public class MyBlockingQueue<T> {
    private List<T> queue;
    private int limit = 10;
    public MyBlockingQueue(int limit) {
        queue = new LinkedList<>();
        this.limit = limit;
    }
    /*Notice how notifyAll() is only called
     * from enqueue() and dequeue() if the queue size is equal
     * to the size bounds (0 or limit)*/
    public synchronized void enqueue(T t) throws InterruptedException {
        while(queue.size() == limit) {
            wait();
        }
        if(queue.size() == 0) {
            notifyAll();
        }
        queue.add(t);
    }
    public synchronized T dequeue() throws InterruptedException {
        while(queue.size() == 0) {
            wait();
        }
        if(queue.size() == limit) {
            notifyAll();
        }
        return queue.remove(0);
    }
}