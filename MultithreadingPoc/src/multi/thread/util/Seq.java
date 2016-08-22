package multi.thread.util;

/**
 * Seq for tables
 * @author jbaba
 *
 */
public class Seq {

	long fs = 2;
	long pm = 2;
	long tf = 2;
	
	/**
	 * Seq for FS payments
	 * @return
	 */
	public synchronized long nextFs(){
		return fs++;
	}
	
	/**
	 * Seq for PM payments
	 * @return
	 */
	public synchronized long nextPm(){
		return pm++;
	}
	
	/**
	 * Seq for TF payments
	 * @return
	 */
	public synchronized long nextTf(){
		return tf++;
	}
}
