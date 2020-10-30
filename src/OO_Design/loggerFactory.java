public interface AppLogger{
	public void log(String logMsg);
}

public class FileLogger implements AppLogger{
	public void log(String logMsg){
		FileUtil fu=new FileUtil();
		fu.writeToFile(
		"log.txt",logMsg,true,true);
	}
}

public class DBLogger implements AppLogger{
	public void log(String logMsg){
		//open DB con
		//write log
	}
}

public class ConsoleLogger 
implements AppLogger{
	public void log(String logMsg){
		//open console
		//write log
	}
}

public class LogFactory{
	public Logger getLogger(int v){
		if(v==1)
			return new FileLogger();
		else if(v==2)
			return new DBLogger();
		else if(v==3)
			return new ConsoleLogger();
	}
}

public class LogFactoryTest{
	public static void main(String[] args){
		LogFactory fc=
			new LogFactory();
		AppLogger lg=
			fc.getLogger(1);
		lg.log("Message to File");
		lg=fc.getLogger(3);
		lg.log("Console Message\n");
	}
}