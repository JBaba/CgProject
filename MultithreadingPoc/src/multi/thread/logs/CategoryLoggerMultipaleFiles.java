package multi.thread.logs;

import java.util.HashMap;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public class CategoryLoggerMultipaleFiles {
	
	HashMap<LogCategory, Category> myLogHashMap = new HashMap<LogCategory, Category>();
	//Logger.getLogger(ProgLoggerMultipaleFiles.class);
	
	public CategoryLoggerMultipaleFiles() {
		JCategoryLogger jlog = new JCategoryLogger();
		jlog.startFileLog("mylog");
		jlog.startFileLog("HC");
		jlog.startFileLog("MC");
		jlog.startFileLog("DC");
		
		myLogHashMap.put(LogCategory.mylog, Category.getInstance("mylog"));
		myLogHashMap.put(LogCategory.HC, Category.getInstance("HC"));
		myLogHashMap.put(LogCategory.MC, Category.getInstance("MC"));
		myLogHashMap.put(LogCategory.DC, Category.getInstance("DC"));
		
		Logger.getRootLogger().info("Hello");
		
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

		CategoryLoggerMultipaleFiles plog = new CategoryLoggerMultipaleFiles();
		
	}

}
