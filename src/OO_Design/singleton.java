public class Singleton{
	private static Singleton inst;
	private Singleton(){
	}
	public static Singleton getInstance(){
		if(inst==null){
			synchronized(Singleton.class){
				inst=new Singleton();
			}
		}
		return inst;
	}
}
//double-checked locking
//lazy evaluation
public class Singleton{
	private static Singleton inst;
	private Singleton(){
	}
	public static
	Singleton getInstance(){
		if(inst==null){
			synchronized(Singleton.class){
				if(inst==null)
					inst=new Singleton();
			}
		}
		return inst;
	}
}
//early eval
public class Singleton{
	private static
	Singleton _inst=new Singleton();
	private Singleton(){}
	public static
	Singleton getInst(){
		return _inst;
	}
}