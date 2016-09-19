package Application;

import org.apache.log4j.Priority;

import multi.thread.logs.CategoryLoggerMultipaleFiles.LogCategory;
import multi.thread.logs.CategoryLoggerMultipaleFiles.SLog;
import multi.thread.logs.ILog;

/**
 * Run Multi threading application
 * @author jbaba
 *
 */
public class Application {

	public Application() throws Exception{
		
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		SLog.INSTANCE.getInstance().log(LogCategory.mylog, Priority.INFO, "Application Started..");
		try{
			Application app = new Application();
		}catch(Exception e){
			ILog.iclog(e);
		}
		SLog.INSTANCE.getInstance().log(LogCategory.mylog, Priority.INFO, "Application Main Thread ended.");
	}

}
