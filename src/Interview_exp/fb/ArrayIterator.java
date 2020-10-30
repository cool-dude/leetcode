https://www.careercup.com/question?id=5715706939703296
Given K sorted (ascending) arrays with N elements in each array,
        implement an iterator for iterating over the elements
        of the arrays in ascending order.

The constructor receives all of the input as array of arrays.

You need to implement the MyIterator class with a
        constructor and the following methods:

class MyIterator<T> {
    T next();
    boolean hasNext();
}
You are allowed to use only O(K) extra space with this class.
example:
input:
[[1,5,7], [2,3,10],[4,6,9]]
The iterator should return:
1,2,3,4,5,6,7,9,10
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.lang.Comparable;
import java.util.List;
import static java.util.Arrays.*;
class MyIter<T extends Comparable> implements Iterator {
    class IterState implements Comparable<IterState> {
        private Iterator<T> iter;
        private T currVal;
        public IterState(Iterator<T> i) {
            iter = i;
            next();
        }
        public T getVal() { return currVal; }
        public boolean hasNext() { return iter.hasNext(); }
        public void next() {
            if (iter.hasNext()) {
                currVal = iter.next();
            } else {
                currVal = null;
            }
        }
        public int compareTo(IterState o) {
            return currVal.compareTo(o.getVal());
        }
    }

    private PriorityQueue<IterState> states;

    public MyIter(List<List<T>> listOfList) {
        states = new PriorityQueue<IterState>();
        for (List<T> l:listOfList) {
            Iterator<T> it  = l.iterator();
            if (it.hasNext()) {
                states.add(new IterState(it));
            }
        }
    };
    public T next() {
        IterState n = states.poll();
        T retval = n.getVal();
        // if there is more in the current list, then put it back in the queue
        if (n.hasNext()) {
            n.next();
            states.add(n);
        }
        return retval;
    };
    public boolean hasNext() {
        return !states.isEmpty();
    }
}


class Main {
    private static <T extends Comparable> ArrayList toArray(List<List<T>> listOfList) {
        MyIter<T> i = new MyIter<T>(listOfList);
        ArrayList retval = new ArrayList();
        while (i.hasNext()) {
            retval.add(i.next());
        }
        return retval;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ArrayList arr = toArray(asList(
                asList(1,3,5),
                asList(2,4,6),
                asList(7,9),
                asList(8),
                asList(0,10),
                asList()));

        for (Object i:arr) {
            System.out.println(i);
        }
        arr = toArray(asList());
        for (Object i:arr) {
            System.out.println(i);
        }
    }
}