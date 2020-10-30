import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;
public class ConsistentHash<T> {
    private final HashFunction hashFunction;
    private final int numberOfReplicas;
    private final SortedMap<Integer, T> circle =
            new TreeMap<Integer, T>();
    public ConsistentHash(HashFunction hashFunction,
                          int numberOfReplicas, Collection<T> nodes) {
        this.hashFunction = hashFunction;
        this.numberOfReplicas = numberOfReplicas;
        for (T node : nodes) {
            add(node);
        }
    }
    public void add(T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.put(hashFunction.hash(node.toString() + i),
                    node);
        }
    }
    public void remove(T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.remove(hashFunction.hash(node.toString() + i));
        }
    }
    public T get(Object key) {
        if (circle.isEmpty()) {
            return null;
        }
        int hash = hashFunction.hash(key);
        if (!circle.containsKey(hash)) {
            SortedMap<Integer, T> tailMap =
                    circle.tailMap(hash);
            hash = tailMap.isEmpty() ?
                    circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }
}
For example, as mentioned above, memcached,
a distributed memory object caching system,
now has clients that support consistent hashing.
Last.fm's ketama by Richard Jones was the first,
and there is now a Java implementation by
Dustin Sallings (which inspired my simplified demonstration implementation above).
It is interesting to note that it is only the client
that needs to implement the consistent hashing
algorithm - the memcached server is unchanged.
Other systems that employ consistent hashing
include Chord, which is a distributed hash
table implementation, and Amazon's Dynamo,
which is a key-value store