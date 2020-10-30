import java.util.*;
import java.io.*;
public class ProdCons{
	protected LinkedList
	lst=new LinekdList();
	protected int MAX=10;
	protected boolean done=false;
	class Producer
	extends Thread{
		public void run(){
			while(true){
				synchornized(lst){
					while(lst.size()==MAX)
					//queue full
					try{
						System.out.println("Producer WAITING");
						lst.wait();
					}
					catch(InterruptedException ex){
						System.out.println("Producer INTERRUPTED");
					}
					lst.addFirst(jstProduced);
					lst.notifyAll();
					System.out.println("Produced 1;List size now" + lst.size());
				}
			}
		}
	}
	class Consumer extends Thread{
		public void run(){
			while(true){
				Object obj=null;
				synchronize(lst){
					while(lst.size()==0){
						try{
							System.out.println("CONSUMER WAITING");
							lst.wait();
						}
						catch(InterruptedException ex){
							System.out.println("CONSUMER INTERRUPTED");
						}
					}
					obj=lst.removeLast();
					lst.notifyAll();
				}
			}
		}
	}
}