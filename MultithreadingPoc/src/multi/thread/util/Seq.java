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
	
	public synchronized long nextFs(){
		return fs++;
	}
	
	public synchronized long nextPm(){
		return pm++;
	}
	
	public synchronized long nextTf(){
		return tf++;
	}
}
