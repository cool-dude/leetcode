package whatever;
import java.io.*;
import java.util.Scanner;
public class ActorSystem {
    static final MSG_CAPACITY=100;
    MyBlockingQueue<Actor> myqueue;
    ConcurrentHashMap<String, LinkedHashMap<UUID, Runnable>> actorsMap;
    boolean isShutDown;
    public ActorSystem(int threadCount, int maxNoOfTasks) {
        myqueue = new MyBlockingQueue<>(maxNoOfTasks);
        actorsMap = new ConcurrentHashMap<>();
    }
    public synchronized void execute(String taskType,String action) throws InterruptedException {
        if(isShutDown) {
            throw new IllegalStateException("ActorSystem is shutdown");
        }
        try {
            if (myqueue.size() < myqueue.capacity()) {
                Actor actor = new Actor(c);
                actorsMap.put(actorsMap.getOrDefault(taskType, new LinkedHashMap<>()).add(actor.getUUID(), actor));
                myqueue.enqueue(actor);
                actor.receiveMessage(action);
            }
            else {
                LinkedHashMap<UUID, Runnable> actorTypeMap = actorsMap.get(taskType);
                for (UUID uuid : actorTypeMap.keySet()) {
                    Actor actor = actorTypeMap.get(uuid);
                    if (actor.getMessageQueueSize() < MSG_CAPACITY)
                        actor.receiveMessage(action);
                }
            }
            actor.run();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public synchronized void setShutDown() {
        isShutDown=true;
        for(Actor actor:myqueue){
            if(!actor.isStopped())
                actor.doStop();
        }
    }
}