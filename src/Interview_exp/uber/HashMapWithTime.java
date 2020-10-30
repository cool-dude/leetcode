/*Add third dimension of time to hashmap ,
 so ur hashmap will look something like this -
  HashMap<K, t, V> where t is a float value.
  Implement the get and put methods to this map.
  The get method should be something like -
  map.get(K,t) which should give us the value.
  If t does not exists then map should return
  the closest t' such that t' is smaller than t.
  For example, if map contains (K,1,V1) and (K,2,V2)
  and the user does a get(k,1.5) then the output
  should be v1 as 1 is the next smallest number to 1.5* */
public class TimeHashMap<Key, Time, Value> {
    private HashMap<Key, TreeMap<Time, Value>> map = new HashMap<Key, TreeMap<Time, Value>>();
    public Value get(Key key, Time time) {
        final TreeMap<Time, Value> redBlackBST = map.get(key);
        if (redBlackBST == null) return null;
        final Time floorKey = redBlackBST.floorKey(time);
        return floorKey == null ? null : redBlackBST.get(floorKey);
    }
    public void put(Key key, Time time, Value value) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<Time, Value>());
        }
        map.get(key).put(time, value);
    }
    public static void main(String args[]){
        TimeHashMap<String, Double, String> data = new TimeHashMap<String, Double, String>();
        data.put("K",1.0,"K1");
        data.put("K",2.0,"K2");
        System.out.println(data.get("K",0.9));
        System.out.println(data.get("K",1.0));
        System.out.println(data.get("K",1.5));
        System.out.println(data.get("K",2.0));
        System.out.println(data.get("K",2.2));
    }
}