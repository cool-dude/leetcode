/*Design a data structure that supports the following operations in Θ(1) time.
insert(x): Inserts an item x to the data structure if not already present.
remove(x): Removes an item x from the data structure if present.
search(x): Searches an item x in the data structure.
getRandom(): Returns a random element from current set of elements*/
class MyDS{
    ArrayList<Integer> arr;
    HashMap<Integer,Integer> map;
    public MyDS(){
        arr=new ArrayList<Integer>();
        map=new HashMap<Integer,Integer>();
    }
    void add(int x){
        if(map.get(x)!=null)
            return;
        int l=arr.size();
        arr.add(x);
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