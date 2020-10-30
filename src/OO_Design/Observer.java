import java.util.ArrayList;
public interface Subject {
	public void 
		registerObserver(Observer o);
	public void 
		removeObserver(Observer o);
	public void 
		notifyAllObservers();
}
public class HeadHunter
implements Subject{
	//define a list of users, 
	//such as Mike, Bill, etc.
	List<Observer> userList;
	List<String> jobs;
	public HeadHunter(){
		userList = 
			new ArrayList<Observer>();
		jobs = 
			new ArrayList<String>();
	}
	@Override
	public void registerObserver(Observer o) {
		userList.add(o);
	}
	@Override
	public void removeObserver(Observer o) {}
 
	@Override
	public void notifyAllObservers() {
		for(Observer o: userList){
			o.update(this);
		}
	}
	
	public void addJob(String job) {
		jobs.add(job);
		notifyAllObservers();
	}
	
	public ArrayList<String> getJobs() {
		return jobs;
	}
	
	public String toString(){
		return jobs.toString();
	}
}
public interface
Observer {
	public void
	update(Subject s);
}
public class JobSeeker 
implements Observer {
	private String name;
	public JobSeeker(String name){
		this.name = name;
	}

	@Override
	public void 
	update(Subject s) {
		System.out.println(this.name 
			+ " got notified!");
		//print job list
		System.out.println(s);
	}
}
public class Main {
	public static 
	void main(String[] args) {
		HeadHunter hh = 
			new HeadHunter();
		hh.registerObserver(
			new JobSeeker("Mike"));
		hh.registerObserver(
			new JobSeeker("Chris"));
		hh.registerObserver(
			new JobSeeker("Jeff"));
		//Each time, a new job 
		//is added, all 
		//registered job seekers 
		//will get noticed.
		hh.addJob("Google Job");
		hh.addJob("Yahoo Job");
	}
}