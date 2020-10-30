package whatever;
import MyBlockingQueue;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
class Actor extends Thread {
    int capacity;
    UUID actorId;
    //MyBlockingQueue<Runnable> taskQueue;
    Queue<String> messages;
    boolean isStopped;
    public Actor(int _capacity) {
        actorId = UUID.randomUUID();
        //taskQueue = blockingQueue;
        messages = new LinkedList<>();
        capacity = _capacity;
        isStopped = false;
    }
    //getters and setters
    //auto-populate via lombok/guava library
    UUID getActorId(){
        return actorId;
    }
    boolean isMessageQueuEmpty(){
        return messages.size()==0;
    }
    int getMessageQueueSize(){
        return messages.size();
    }
    public void receiveMessage(String msg){
        messages.offer(msg);
    }
    void runActionHandler(String action){
        switch (action){
            //execute depending on the action
        }
    }
    public void run() {
        while(!isStopped) {
            try {
                while (!messages.isEmpty()) {
                    String action = messages.poll();
                    runActionHandler(action);
                }
            }
            catch(Exception e) {
                // log
            }
        }
    }
    public synchronized void doStop() {
        if(isStopped!=true) {
            isStopped = true;
            this.interrupt();
        }
    }
    public synchronized boolean isStopped() {
        return isStopped;
    }
}