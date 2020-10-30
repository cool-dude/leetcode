public class WordDistance {
    HashMap<String, ArrayList<Integer>> map;
    public WordDistance(String[] ws) {
        map = new HashMap<String, 0
        ArrayList<Integer>>();
        for(int i=0; i<ws.length; i++){
            if(map.containsKey(ws[i])){
                map.get(ws[i]).add(i);
            }
            else{
                ArrayList<Integer> l =
                        new ArrayList<Integer>();
                l.add(i);
                map.put(ws[i], l);
            }
        }
    }
    public int shortest(String w1, String w2) {
        ArrayList<Integer> l1 = map.get(w1); ArrayList<Integer> l2 = map.get(w2);

        int res = Integer.MAX_VALUE;
        for(int i1: l1){
            for(int i2: l2){
                result = Math.min(res,
                        Math.abs(i1-i2));
            }
        }
        return res;
    }
}