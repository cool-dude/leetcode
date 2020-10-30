/*There is a collection of input strings
and a collection of query strings. For
each query string, determine how many
times it occurs in the list of input
strings. Return an array of the results.
Example
There are  instances of ',  of '' and  of ''.
For each query, add an element to the return array, .

Function Description

Complete the function matchingStrings in the editor below. The function must return an array of integers representing the frequency of occurrence of each query string in strings.

matchingStrings has the following parameters:

string strings[n] - an array of strings to search
string queries[q] - an array of query strings
Returns
int[q]: an array of results for each query*/
package hackerrank;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static java.util.function.Function.*;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
public class SparseArray {
    static int[] matchingStrings(String[] strings, String[] queries) {
        if(strings==null || strings.length==0||queries==null||queries.length==0)return new int[0];
        Map<String,Integer> map=new HashMap<>();
        for(String key:strings){
            map.put(key,map.getOrDefault(key,0)+1);
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (map.containsKey(queries[i]))
                result[i] = Math.toIntExact(map.get(queries[i]));
            else
                result[i] = 0;
        }
        return result;
    }
}
