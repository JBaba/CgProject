package multi.thread.logs;

import java.util.HashMap;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

/**
 * Logging manager 
 * @author jbaba
 *
 */
public class CategoryLoggerMultipaleFiles {
	
	HashMap<LogCategory, Category> myLogHashMap = new HashMap<LogCategory, Category>();
	
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
		
		Logger.getRootLogger().info("Msg from root ...");
		
		log(LogCategory.mylog,Priority.DEBUG,"Init mylog category ....");
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
