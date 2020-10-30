class Customer{
    //int cust_id;
    atomic int startTime;
    int cur_win_credit;
    int total_credit;
}

class RateLimiter{
    static int TIME_WINDOW=5000;
    static int CUST_RATE=1000;
    ConcurrentHashMap<Integer, Customer> customerMap;
    //Map<Integer, Integer> rateCountMap;
    boolean rateLimit(int cust_id){
        int currentTime=System.currentTimeIMillis();
        if(rateCountMap.containsKey(cust_id)){
            int startTime=customerMap.get(cust_id).getStartTime();
            //write lock
            if(customerMap.get(cust_id).getCurWindowCredit()<CUST_RATE && (currentTime-startTime)<TIME_WINDOW){
                int cur_win_credit=customerMap.get(cust_id).getCurWindowCredit();
                int total_credit=customerMap.get(cust_id).getTotalCredit();
                //inside sempaphore /read-write locks
                rateCountMap.put(cust_id,new Customer(startTime, cur_win_credit-1, total_credit);
                //rateTimeMap.get(cust_id).add(currentTime);
                return true;
            }
            else if(currentTime-startTime>=TIME_WINDOW){
                int cur_win_credit=customerMap.get(cust_id).getCurWindowCredit();
                int total_credit=customerMap.get(cust_id).getTotalCredit();
                if(cur_win_credit+total_credit>10*CUST_RATE) total_credit=10*CUST_RATE;
                else total_credit+=cur_win_credit;
                cur_win_credit=CUST_RATE;
                customerMap.put(cust_id,new Customer(startTime,cur_win_credit, total_credit));
                return true;
            } 
            else{
                return false;
            }  
        }
        else{
            customerMap.put(cust_id,new Customer(currentTime,CUST_RATE-1,CUST_RATE));
            return true;
        }
    }
}