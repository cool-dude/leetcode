public class Call {
    /* Minimal rank of
    employee who can
    handle this call */
    private Rank rank;
    /* Person calling. */
    private Caller caller;
    /* Employee handling call. */
    private Employee handler;
    public Call(Caller c) {
        rank = Rank.Responder;
        caller = c;
    }
    /* Set employee handling call. */
    public void setHandler(Employee e) {
        handler = e;
    }
    public void reply(String message) {
    }
    public Rank getRank() {
        return rank;
    }
    public void setRank(Rank r) {
        rank = r;
    }
    public Rank incrementRank() { ... }
    public void disconnect() { ... }
}

public class CallCentre {
    private static CallCentre inst;
    /* 3 levels of
    employees:
    respondents,
    managers,
    directors. */
    private final int LEVELS = 3;
    /* Initialize
    10 respondents,
    4 managers, and
    2 directors. */
    private final int NUM_RESPONDENTS = 10;
    private final int NUM_MANAGERS = 4;
    private final int NUM_DIRECTORS = 2;

    /* List of employees, by level.
     *employeeLevels[0] = respondents
     *employeeLevels[1] = managers
     *employeeLevels[2] = directors*/
    List<List<Employee>> employeeLevels;
    /* Queues for each call's rank */
    List<List<Call>> callQueues;
    protected CallCentre() {}
    /* Get instance
    of singleton class.*/
    public static CallCentre getInstance() {
        if (inst == null) {
            inst = new CallHandler();
        }
        return inst;
    }
    /* Gets the first
    available employee
    who can handle
    this call. */
    public Employee getHandlerForCall(Call call) {}
    /* Routes the call to
    an available employee,
    or saves in a queue
    if no employee
    available. */
    public void dispatchCall(Caller caller) {
        Call call = new Call(caller);
        dispatchCall(call);
    }
    /* Routes the call to
    an available employee,
    or saves in a queue
    if no employee
    available. */
    public void dispatchCall(Call call) {
		/* Try to route the
		call to an employee
		with minimal rank. */
        Employee emp = getHandlerForCall(call);
        if (emp != null) {
            emp.receiveCall(call);
            call.setHandler (emp) ;
        }
        else {
            /* Place the call into
             * corresponding call
             * queue according
             * to its rank. */
            call.reply (
                    "Please wait for "
                    "free employee to"
                    "reply");
            callQueues.get(call.getRank().getValue()).add(call);
        }
    }
    /* An employee got free.
    Look for a waiting call
    that emp. can serve.
    Return true if we
    assigned a call,
    false otherwise. */
    public boolean assignCall(Employee emp) {}
}