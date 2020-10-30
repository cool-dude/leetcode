public class Parts{
	public String spc;
	public Parts(String sp){
		spc=sp;
	}
	public String 
	getSpec(){
		return spc;
	}
}
public abstract class Car{
	public Parts getWheels();
	public Parts getMirrors();
	public Parts getEngine();
	public Parts getBody();
}
public class BQ extends Car{
	public Parts getWheels(){
		return new Parts("BQ Wheels");
	}
	public Parts getMirrors(){
		return new Parts("BQ Mirrors");
	}
	public Parts getEngine(){
		return new Parts("BQ Eng");
	}
	public Parts getBody(){
		return new Parts("BQ Body");
	}
}
public class BMW extends Car{
	public Parts getWheels(){
		return new Parts("BMW Wheels");
	}
	public Parts getEngine(){
		return new Parts("BMW Eng");
	}
	public Parts getMirrors(){
		return new Parts("BMW Mirrors");
	}
	public Parts getBody(){
		return new Parts("BMW Body");
	}
};
public class GM extends Car{
	public Parts getWheels(){
		return new Parts("GM Wheels");
	}
	public Parts getEngine(){
		return new Parts("GM Eng");
	}
	public Parts getMirrors(){
		return new Parts("GM Mirrors");
	}
	public Parts getBody(){
		return new Parts("GM Body");
	}
};
interface CPU {
    void process();
}
interface CPUFactory {
	CPU produceCPU();
}
class AMDFactory implements CPUFactory {
    public CPU produceCPU() {
        return new AMDCPU();
    }
}
class IntelFactory implements CPUFactory {
    public CPU produceCPU() {
        return new IntelCPU();
    }
}
class AMDCPU implements CPU {
    public void process() {
        System.out.println("AMD is processing...");
    }
}
class IntelCPU implements CPU {
    public void process() {
        System.out.println("Intel is processing...");
    }
}
class Computer {
	CPU cpu;
    public Computer(CPUFactory factory) {
    	cpu = factory.produceCPU();
        cpu.process();
    }
}
public class Client {
    public static void main(String[] args) {
        new Computer(createSpecificFactory());
    }
    public static CPUFactory createSpecificFactory() {
        int sys = 0; // based on specific requirement
        if (sys == 0) 
        	return new AMDFactory();
        else 
        	return new IntelFactory();
    }
}
package com.design.model;
public abstract class Computer{
	public abstract String getRAM();
	public abstract String getHDD();
	public abstract String getCPU();
	@Override
	public String toString(){
		return "RAM= "+this.getRAM()+
			" , HDD="+this.getHDD()+" , CPU="+this.getCPU());
	}
}
public class PC extends Computer {
    private String ram;
    private String hdd;
    private String cpu;
    public PC(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
    public String getRAM() {
        return this.ram;
    }
    @Override
    public String getHDD() {
        return this.hdd;
    }
    @Override
    public String getCPU() {
        return this.cpu;
    }
}
public class Server extends Computer {
    private String ram;
    private String hdd;
    private String cpu;
    public Server(String ram, 
		String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
    public String getRAM() {
        return this.ram;
    }
    @Override
    public String getHDD() {
        return this.hdd;
    }
    @Override
    public String getCPU() {
        return this.cpu;
    }
}
public interface ComputerAbstractFactory {
	public Computer createComputer();
}
import com.design.model.Computer;
import com.design.model.PC;
public class PCFactory 
	implements ComputerAbstractFactory {
	private String ram;
	private String hdd;
	private String cpu;
	public PCFactory(String ram, String hdd, String cpu){
		this.ram=ram;
		this.hdd=hdd;
		this.cpu=cpu;
	}
	@Override
	public Computer createComputer() {
		return new PC(ram,hdd,cpu);
	}
}
import com.design.model.Computer;
import com.design.model.Server;
public class ServerFactory 
	implements ComputerAbstractFactory {
	private String ram;
	private String hdd;
	private String cpu;
	public ServerFactory(String ram, String hdd, String cpu){
		this.ram=ram;
		this.hdd=hdd;
		this.cpu=cpu;
	}
	@Override
	public Computer createComputer() {
		return new Server(ram,hdd,cpu);
	}
}

import com.design.model.Computer;
public class ComputerFactory{
	public static Computer 
		getComputer(ComputerAbstractFactory factory){
		return factory.createComputer();
	}
}
import com.design.abstractfactory.PCFactory;
import com.design.abstractfactory.ServerFactory;
import com.design.factory.ComputerFactory;
import com.design.model.Computer;
public class TestDesignPatterns {
	public static void main(String[] args) {
		testAbstractFactory();
	}
	private static void testAbstractFactory() {
		Computer pc = com.design.abstractfactory.ComputerFactory.getComputer(new PCFactory("2 GB","500 GB","2.4 GHz"));
		Computer server = com.design.abstractfactory.ComputerFactory.getComputer(new ServerFactory("16 GB","1 TB","2.9 GHz"));
		System.out.println("AbstractFactory PC Config::"+pc);
		System.out.println("AbstractFactory Server Config::"+server);
	}
}
AbstractFactory PC Config::RAM= 2 GB, HDD=500 GB, CPU=2.4 GHz.
AbstractFactory Server Config::RAM= 16 GB, HDD=1 TB, CPU=2.9 GHz.