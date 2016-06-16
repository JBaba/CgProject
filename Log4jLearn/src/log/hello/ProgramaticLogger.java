package log.hello;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class ProgramaticLogger {
	
	static {
		ConsoleAppender console = new ConsoleAppender(); //create appender
		  //configure the appender
		String PATTERN = "%d [%p|%c|%C{1}] %m%n";
		console.setLayout(new PatternLayout(PATTERN)); 
		console.setThreshold(Level.FATAL);
		console.activateOptions();
		
		//add appender to any Logger (here is root)
		Logger.getRootLogger().addAppender(console);
	
		FileAppender fa = new FileAppender();
		fa.setName("FileLogger");
		fa.setFile("mylog.log");
		fa.setLayout(new PatternLayout("%d %-5p [%c{1}] %m%n"));
		fa.setThreshold(Level.DEBUG);
		fa.setAppend(true);
		fa.activateOptions();
	
		//add appender to any Logger (here is root)
		Logger.getRootLogger().addAppender(fa);
		//repeat with all other desired appenders
	}
	
	final Logger logger = Logger.getLogger(ProgramaticLogger.class);
	
	public ProgramaticLogger() {
		String parameter = "Naimish";
		  
		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		}
			
		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}
			
		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);
	}
	
	public enum LogCategory{
		HC,MC,DC
	}

	public static void main(String[] args) {

		ProgramaticLogger plog = new ProgramaticLogger();
		
	}

}
