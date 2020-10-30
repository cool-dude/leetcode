public interface Pet{
	public String petSnd();
}

//Der class 1 that might get instantiated
public class Dog implements Pet{
	public String petSnd(){
		return "Bow";
	}
}

public class Cat implements Pet{
	public String petSnd(){
		return "Meow";
	}
}

public class PetFactory{
	public Pet getPet(String  pType){
		Pet p=null;
		if("Bow".equals(pType))
			p=new Dog();
		else if("Meow".equals(pType))
			p=new Cat();
		return p;
	}
}

public class SampleFactory{
	public static void main(String args[]){
		PetFactory pf=new PetFactory();
		Pet p=pf.getPet("Bow");
		System.out.println("")
	}
}

//When to use:
1.When a class can't
guess the type of objects
it is supposed to create.
2.When a class wants its
subclasses to be ones to
specify the type of newly
created object.
3.When we want to localize
the knowledge of which
class gets created.