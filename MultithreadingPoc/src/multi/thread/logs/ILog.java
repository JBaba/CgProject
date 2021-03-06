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

	/**
	 * Method directly prints msg to consol and added to mylog file.
	 * @param msg
	 */
	public static void iclog(String msg){
		ilog.log(LogCategory.mylog, Priority.INFO, msg);
	}
	
	/**
	 * Method directly prints exception stack trace to consol and file
	 * @param e
	 */
	public static void iclog(Exception e){
		ilog.log(LogCategory.mylog, Priority.ERROR, e);
	}
	
	/**
	 * Method directly prints msg to consol and added to Category file.
	 * @param msg
	 */
	public static void iclog(LogCategory c,String msg){
		ilog.log(c, Priority.INFO, msg);
	}
	
	/**
	 * Method directly prints exception stack trace to Category and file
	 * @param e
	 */
	public static void iclog(LogCategory c,Exception e){
		ilog.log(c, Priority.ERROR, e);
	}
}
