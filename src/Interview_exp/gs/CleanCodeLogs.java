/*data = [
  ("Whole Foods", 48.11, 5),
  ("Comcast", 89.99, 10),
  ("Comcast", 89.99, 20),
  ("Comcast", 89.99, 30),
  ("T-Mobile", 40.00, 45),
  ("T-Mobile", 40.00, 55),
  ("T-Mobile", 40.33, 65),
  ("Jetblue", 20.11, 80),
  ("Jetblue", 20.11, 90),
  ("Jetblue", 20.11, 95),
]
-> [ “Comcast” ]
Question:
Each line represents a COMPANY, AMOUNT, DAY
Return a list of companies which are "persistent".

For this problem, a "persistent" company means:
There are 3+ transactions with the same company,
same price, and the same interval of time b/w transaction
A company is not "persistent" if any one of the transactions:
Is at a diff interval from the rest, ex Jetblue
Is a diff price from the rest, ex. T-Mobile
Is not in a set of 3+, ex. Whole Foods
 */
class Sln{
    public class Feed {
        String company;
        double amount;
        int day;
    }
    public List<String> persistentCompanies(List<Feed> feeds){
        Map<String, List<Integer>> logs=new HashMap<>();
        for(Feed feed:feeds){
            String key=feed.company+feed.amount.toString();
            if(!logs.containsKey(key))
                logs.put(key,new ArrayList<>());
            logs.get(key).add(feed.day);
        }
        List<String> result=new ArrayList<>();
        for(Map.Entry e:logs.entrySet()){
            List<Integer> days=(List<Integer>)e.getValue();
            if(days.size()<3) continue;
            int diff=days.get(1)-days.get(0);
            for(int i=2;i<days.size();i++){
                int curDiff=days.get(i)-days.get(i-1);
                if(curDiff!=diff) continue;
            }
            result.add((String)e.getKey());
        }
        return result;
    }
}