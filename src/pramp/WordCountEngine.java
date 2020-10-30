package pramp;
import java.util.*;
public class WordCountEngine {
    public static void main(String[] args) {
        String document = "Practice makes perfect. you'll only get Perfect by practice. just practice !";
        String[][] output=wordCountEngine(document);
        Arrays.stream(output).forEach(arr->{
            System.out.println(arr[0]+"->"+arr[1]);
        });
    }

    static String[][] wordCountEngine(String doc) {
        String[] allWords = doc.toLowerCase().split("[^a-zA-Z']+");
        LinkedHashMap<String, Integer> counter = new LinkedHashMap<>();

        Arrays.stream(allWords).forEach(w -> {
            counter.compute(w, (key, value) -> value == null ? 1 : value + 1);
        });
        System.out.println(counter);
        TreeMap<Integer, HashSet<String>> sortedMap = new TreeMap<>(Collections.reverseOrder());
        Arrays.stream(allWords).forEach(w -> {
            int i = counter.get(w);
            if (sortedMap.containsKey(i)) {
                HashSet<String> set = sortedMap.get(i);
                set.add(w);
                sortedMap.put(i, set);
            }
            else {
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(w);
                sortedMap.put(i, hashSet);
            }
        });
        System.out.println(sortedMap);
        String[][] result=new String[counter.size()][2];
        int iterator=0;
        for(Map.Entry<Integer,HashSet<String>> entry:sortedMap.entrySet()){
            int count=entry.getKey();
            for(Map.Entry<String,Integer> e:counter.entrySet()){
                if(e.getValue()==count){
                    String[] res=new String[2];
                    res[0]=e.getKey();
                    res[1]=String.valueOf(count);
                    result[iterator]=res;
                    iterator++;
                }
            }
        }
        return result;
    }
}

class Data implements Comparable<Data>{
    String word;
    int count;
    public Data( String w, int c) {
        word = w;
        count = c;
    }
    public int compareTo( Data that ) {
        // sorts in descending order
        return that.count - this.count;
    }
}
public class Soln {
    public static List<Data> getWCE(String doc){
        if( doc == null || doc.length() == 0) {
            return null;
        }
        Map<String, Integer> map = new HashMap<>();
        String[] allWords = doc.toLowerCase().split("[^a-zA-Z]+");
        for( String s : allWords ) {
            if( map.containsKey(s) ) {
                map.put( s, map.get(s) + 1 );
            }
            else {
                map.put( s, 1 );
            }
        }
        List<Data> result = new ArrayList<Data>();
        for( String key : map.keySet() ) {
            result.add( new Data( key, map.get(key) ) );
        }
        Collections.sort(result);
        return result;
    }
    public static void main(String []args){
        String doc = "practice makes perfect. get perfect by practice. just practice!";
        List<Data> result = getBusiestTime(doc);
        for( Data d : result) {
            System.out.println(d.word + " : " + d.count);
        }
    }
}