package log.hello;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class JLogger {

	Logger rootLooger = null;
	
	public JLogger() {
		startConsolLog();
	}

	public void startConsolLog(){
		ConsoleAppender console = new ConsoleAppender(); //create appender
		  //configure the appender
		String PATTERN = "%d [%p|%c|%C{1}] %m%n";
		console.setLayout(new PatternLayout(PATTERN)); 
		console.setThreshold(Level.FATAL);
		console.activateOptions();
		
		//add appender to any Logger (here is root)
		rootLooger = Logger.getRootLogger();
		rootLooger.addAppender(console);
	}
	
	public void startFileLog(String fileName){
		FileAppender fa = new FileAppender();
		fa.setName(fileName);
		fa.setFile(fileName+".log");
		fa.setLayout(new PatternLayout("%d %-5p [%c{1}] %m%n"));
		fa.setThreshold(Level.DEBUG);
		fa.setAppend(true);
		fa.activateOptions();
	
		//add appender to any Logger (here is root)
		rootLooger.addAppender(fa);
		//repeat with all other desired appenders
	}
	
}
