/*Design a data structure that supports
all following operations in average O(1) time.

insert(val): Inserts an item val to the
set if not already present.
remove(val): Removes an item val from the
set if present.
getRandom: Returns a random element from current
 set of elements (it's guaranteed that at least
 one element exists when this method is called).
 Each element must have the same probability of being returned.

Example:
// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();
// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);
// Returns false as 2 does not exist in the set.
randomSet.remove(2);
// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);
// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();
// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);
// 2 was already in the set, so return false.
randomSet.insert(2);
// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();*/
import java.util.*;
class RandomSet{
    List<Integer> nums;
    Map<Integer,Integer> locs;
    Random rand=new Random();
    public RandomSet(){
        nums=new ArrayList<Integer>();
        locs=new HashMap<Integer,Integer>();
    }
    public boolean insert(int val){
        if(locs.containsKey(val)) return false;
        locs.put(val,nums.size());
        nums.add(val);
        return true;
    }
    public boolean remove(int val){
        if(!locs.containsKey(val)) return false;
        int loc=locs.get(val);
        if(loc<nums.size()-1){ //not the last one, then swap last
            int lastone=nums.get(nums.size()-1);
            nums.set(loc,lastone);
            locs.put(lastone,loc);
        }
        locs.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }
    public int getRandom(){
        return nums.get(rand.nextInt(nums.size()));
    }
}