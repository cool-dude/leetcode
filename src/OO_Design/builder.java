public interface CarPlan{
	public void 
	setBase(String bm);		
	public void 
	setWheels(String st);
	public void 
	setEngine(String st);		
	public void 
	setRoof(String st);
	public void 
	setMirrors(String rf);		
	public void 
	setLights(String rf);	
	public void 
	setInterior(String int);
}
public class Car implements CarPlan{
	private String base;
	private String wheels;
	private String engine;
	private String roof;
	private String mirrors;
	private String interior;
	public void setBase(String b){
		base=b;
	}
}
public interface CarBuilder{
	public void 
	buildBase();
	public void 
	buildWheels();
}
public class LPCBuilder extends CarBuilder{
	private Car c;
	public 
	LPCBuilder(){
		c=new Car();
	}
	public void 
	buildBase(){
		c.setBase("LP base");
	}
}
public class ME{
	private CarBuilder cb;
	public ME(CarBuilder carBuilder){
		cb=carBuilder;
	}
	public Car getCar(){
		return CarBuilder.getCar();
	}
	public void buildCar(){
		cb.buildBase();
	}
}