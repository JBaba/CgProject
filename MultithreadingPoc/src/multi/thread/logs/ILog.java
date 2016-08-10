package multi.thread.logs;

import org.apache.log4j.Priority;

import multi.thread.logs.CategoryLoggerMultipaleFiles.LogCategory;
import multi.thread.logs.CategoryLoggerMultipaleFiles.SLog;

/**
 * Create class to send msg to looger by just msg
 * @author jbaba
 *
 */
public class ILog {

	public final static CategoryLoggerMultipaleFiles ilog = SLog.INSTANCE.getInstance();
	
	public ILog() {
	}

	public static void iclog(String msg){
		ilog.log(LogCategory.mylog, Priority.INFO, msg);
	}
	
}
