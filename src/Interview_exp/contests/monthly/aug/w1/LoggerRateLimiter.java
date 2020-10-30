/*LC359: Logger Rate Limiter
Design a logger system that receive stream of
messages along with its timestamps, each message
should be printed if and only if it is not printed in the last 10 seconds.

Given a message and a timestamp (in seconds granularity),
return true if the message should be printed in the given
timestamp, otherwise returns false.

It is possible that several messages arrive roughly at the same time.

Example:
Logger logger = new Logger();

// logging string "foo" at timestamp 1
logger.shouldPrintMessage(1, "foo"); returns true;

// logging string "bar" at timestamp 2
logger.shouldPrintMessage(2,"bar"); returns true;

// logging string "foo" at timestamp 3
logger.shouldPrintMessage(3,"foo"); returns false;

// logging string "bar" at timestamp 8
logger.shouldPrintMessage(8,"bar"); returns false;

// logging string "foo" at timestamp 10
logger.shouldPrintMessage(10,"foo"); returns false;

// logging string "foo" at timestamp 11
logger.shouldPrintMessage(11,"foo"); returns true;*/
class Logger1 {
    Map<String,Integer> msgs;
    /** Initialize your data structure here. */
    public Logger() {
        msgs=new HashMap<String,Integer>();
    }
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!this.msgs.containsKey(message)){
            this.msgs.put(message,timestamp);
            return true;
        }
        Integer oldTS=this.msgs.get(message);
        if(timestamp-oldTS>=10){
            this.msgs.put(message,timestamp);
            return true;
        }
        else
            return false;
    }
}

class Logger {
    private final Queue<Log> queue;
    private final Set<String> messages;
    /** Initialize your data structure here. */
    public Logger() {
        this.messages = new HashSet<>();
        //the queue is sorted as we are guaranteed to be called shouldPrintMessage by increasing time value
        //the idea is to toss any log pass the window of 10 when a new log is requested
        //e.g. if the head of queue is pointing to log at 1 sec, and we are requested at 11, the 1 sec log would be tossed
        //as it is no longer relevant
        this.queue = new LinkedList<>();
    }
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!queue.isEmpty() && (timestamp - queue.peek().timestamp >= 10)) {
            //toss away all irrelvant logs
            //also remove the message from seen message
            messages.remove(queue.poll().message);
        }
        if (messages.contains(message)) return false;
        queue.offer(new Log(timestamp, message));
        messages.add(message);
        return true;
    }
    private static final class Log {
        private final int timestamp;
        private final String message;
        public Log(int t, String s) {
            this.timestamp = t;
            this.message = s;
        }
    }
}
/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */