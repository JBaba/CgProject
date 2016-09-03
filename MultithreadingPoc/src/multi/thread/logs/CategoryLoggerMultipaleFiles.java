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
	
	// Map of all category
	HashMap<LogCategory, Category> myLogHashMap = new HashMap<LogCategory, Category>();
	
	private CategoryLoggerMultipaleFiles() {
		JCategoryLogger jlog = new JCategoryLogger();
		
		// Init file keys for file adapter
		jlog.startFileLog("mylog");
		jlog.startFileLog("HC");
		jlog.startFileLog("MC");
		jlog.startFileLog("DC");
		
		// create category and store in map
		myLogHashMap.put(LogCategory.mylog, Category.getInstance("mylog"));
		myLogHashMap.put(LogCategory.HC, Category.getInstance("HC"));
		myLogHashMap.put(LogCategory.MC, Category.getInstance("MC"));
		myLogHashMap.put(LogCategory.DC, Category.getInstance("DC"));
		
		Logger.getRootLogger().info("Msg from root ...");
		
		log(LogCategory.mylog,Priority.DEBUG,"Init mylog category ....");
	}
	
	/**
	 * Method for send log msg
	 * @param category file name
	 * @param priority type of msg
	 * @param msg values
	 */
	public void log(LogCategory category,Priority priority,String msg){
		if(priority == Priority.INFO)
			myLogHashMap.get(category).log(priority, msg);
	}
	
	/**
	 * Method prints exception stack trace
	 * @param category file name
	 * @param priority type of msg
	 * @param msg values
	 */
	public void log(LogCategory category,Priority priority,Exception msg){
		myLogHashMap.get(category).error("Exception:", msg);
	}
	
	/**
	 * List of categories
	 * @author jbaba
	 *
	 */
	public enum LogCategory{
		mylog,HC,MC,DC
	}
	
	/**
	 * Enum for Singleton Access to Logs
	 * @author jbaba
	 *
	 */
	public enum SLog
	{
	    INSTANCE;

	    // instance vars, constructor
	    private final CategoryLoggerMultipaleFiles log;

	    SLog()
	    {
	        // Initialize the log
	        log = new CategoryLoggerMultipaleFiles();
	    }

	    // getter
	    public CategoryLoggerMultipaleFiles getInstance()
	    {
	        return log;
	    }

	}

	public static void main(String[] args) {

		CategoryLoggerMultipaleFiles plog = new CategoryLoggerMultipaleFiles();
		
	}

}


