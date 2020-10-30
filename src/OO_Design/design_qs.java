//Abstract class can have instance methods 
//that implement default behavior.
//Interface can only declare constants 
//and instance methods,but cannot 
//implement default behavior 
//and all methods are implicitly abstract.
//Class 
public abstract class TClass{
	//declare fields
	//declare non-abstract methods
	abstract void draw();
}

//interface  has all public  
//members and no implementation.
//Abstract class can have usual 
//flavors of class members
//public,private and) but 
//some abstract methods.
public interface TInterface{
	public double fun1();
	public int fun2();
}

Garbage collection:Identify and discard 
objects no longer needed by program so that their resources.
can be reused.Java object is  
subject to garbage collection 
when it becomes unreachable.

//Pass By Reference:Pass the adress itself.
//Pass by value: Pass a copy of the value.

//Map is interface, Hashmap class to implement that.

//HashMap and HashTable:
//HashMap class is roughly 
//eq to hashtable,
//a) HashMap is unsynchronized 
//b) HashMap permits NULL
//(HashMap allows NULL as key 
//and value where HashTable does not).

//ctor:member fn of class.Used to 
//screate objects,has no return 
//type and invoked 
//using new operator.

//final class cannot be extended.
//final method cannot be overriden 
//when the class is inherited.
//final variable cannot be changed.
//Iterator:java collection classes provided. 
{
	long start=System.currentTimeMillis();
	methood();
	long end=System.currentTimeMillis();
	System.out.println("Time taken for execution is" +(end-start));
}

//Access specifiers
1.private.
2.protected.
3.public.
4.No specifier.
//Issue in ctor.