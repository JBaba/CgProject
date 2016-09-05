package multi.thread.util;

import multi.thread.util.Seq.ISeq;

/**
 * Get values of seq
 * @author jbaba
 *
 */
public class NSeq {

	Seq seq = ISeq.Iseq.getInstance();
	
	/**
	 * Seq for FS payments
	 * @return
	 */
	public long nextFs(){
		return seq.nextFs();
	}
	
	/**
	 * Seq for PM payments
	 * @return
	 */
	public long nextPm(){
		return seq.nextPm();
	}
	
	/**
	 * Seq for TF payments
	 * @return
	 */
	public long nextTf(){
		return seq.nextTf();
	}
	
	/**
	 * Test of unique seq
	 * @param args
	 */
	public static void main(String[] args){
		test();
	}
	
	/**
	 * Test this
	 */
	public static void test(){
		
	}
	
}
