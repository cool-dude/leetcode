package vending;
/** * A parameterized utility class
to hold two different object.*/
public class Bucket<E1, E2> {
    E1 first;
    E2 second;
    public Bucket(E1 first, E2 second){
        this.first = first; this.second = second;
    }
    public E1 getFirst(){
        return first;
    }
    public E2 getSecond(){
        return second;
    }
}