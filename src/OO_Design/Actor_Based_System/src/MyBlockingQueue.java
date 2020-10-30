package whatever;
import java.io.*;
class MyBlockingQueue<T> {
    private List<T> queue;
    private int limit = 10;
    public MyBlockingQueue(int limit) {
        queue = new LinkedList<>();
        this.limit = limit;
    }
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