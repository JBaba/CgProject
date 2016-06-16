package log.hello;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public class ProgLoggerMultipaleFiles {
	
	HashMap<LogCategory, Logger> myLogHashMap = new HashMap<LogCategory, Logger>();
	//Logger.getLogger(ProgLoggerMultipaleFiles.class);
	
	public ProgLoggerMultipaleFiles() {
		JLogger jlog = new JLogger();
		jlog.startFileLog("mylog");
		jlog.startFileLog("HC");
		jlog.startFileLog("MC");
		jlog.startFileLog("DC");
		
		myLogHashMap.put(LogCategory.mylog, Logger.getLogger("mylog"));
		myLogHashMap.put(LogCategory.HC, Logger.getLogger("HC"));
		myLogHashMap.put(LogCategory.MC, Logger.getLogger("MC"));
		myLogHashMap.put(LogCategory.DC, Logger.getLogger("DC"));
		
		Logger.getLogger("mylog").info("Hello");
		
		String parameter = "Naimish";
		  
		log(LogCategory.mylog,Priority.DEBUG,"This is debug : " + parameter);
		log(LogCategory.mylog,Priority.INFO,"This is info : " + parameter);
		log(LogCategory.mylog,Priority.WARN,"This is warn : " + parameter);
		log(LogCategory.mylog,Priority.ERROR,"This is error : " + parameter);
		log(LogCategory.mylog,Priority.FATAL,"This is fatal : " + parameter);
		
		log(LogCategory.HC,Priority.FATAL,"HC");
		log(LogCategory.MC,Priority.FATAL,"MC");
		log(LogCategory.DC,Priority.FATAL,"DC");
		
	}
	
	public void log(LogCategory category,Priority priority,String msg){
		myLogHashMap.get(category).log(priority, msg);
	}
	
	public enum LogCategory{
		mylog,HC,MC,DC
	}

	public static void main(String[] args) {

		ProgLoggerMultipaleFiles plog = new ProgLoggerMultipaleFiles();
		
	}

}
