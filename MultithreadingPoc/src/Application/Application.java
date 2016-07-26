package Application;

import org.apache.log4j.Priority;

import multi.thread.logs.CategoryLoggerMultipaleFiles.LogCategory;
import multi.thread.logs.CategoryLoggerMultipaleFiles.SLog;

/**
 * Run Multi threading application
 * @author jbaba
 *
 */
public class Application {

	public Application() {
	}
	
	public static void main(String[] args) {
		SLog.INSTANCE.getInstance().log(LogCategory.mylog, Priority.INFO, "Application Started..");
		Application app = new Application();
		SLog.INSTANCE.getInstance().log(LogCategory.mylog, Priority.INFO, "Application Main Thread ended.");
	}

}
