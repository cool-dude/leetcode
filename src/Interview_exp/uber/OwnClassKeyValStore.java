/*Write your own class for key value store which has four methods:
put(key,value)
get(key)
getRandom() this should return a random value with equal probability
deleteWithKey(key)

I was allowed to use hashmap internally to store data.
this was my second technical phone interview because they wanted to get some more idea about my technical skills.

use a hashmap to store key, value pair.
ArrayList to insert keys in the ArrayList.
generate a random number from 0 to size()-1,
pick the key and then get the value from HashMap for that key.*/
class MyDS{
    ArrayList<Integer> lst;
    HashMap<Integer,Integer> map;
    public MyDS(){
        lst=new ArrayList<Integer>();
        map=new HashMap<Integer,Integer>();
    }
    void add(int x){
        if(map.get(x)!=null)
            return;
        int l=lst.size();
        lst.add(x);
        map.put(x,l);
    }
    void remove(int x){
        int idx=map.get(x);
        if(idx==null)
            return;
        map.remove(x);
        int l=arr.size();
        Integer last=arr.get(l-1);
        Collections.swap(arr,idx,l-1);
        arr.remove(l-1);
        map.put(last,idx);
    }
    int getRandom(){
        Random r=new Random();
        int idx=r.getNextInt(arr.size());//return index between 0 and arr.size()-1
        return arr.get(idx);
    }
}