package multi.thread.util;

import multi.thread.logs.ILog;
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
	
	public void print(){
		ILog.iclog(seq.toString());
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
		// 1st parallel run thread
		Thread t1 = new Thread(new Runnable() {
			NSeq seq = new NSeq();
			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					seq.nextFs();
					seq.print();
				}
			}
		});
		t1.start();
		
		// 2st parallel run thread
		Thread t2 = new Thread(new Runnable() {
			NSeq seq = new NSeq();
			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					seq.nextFs();
					seq.print();
				}
			}
		});
		t2.start();
				
		// 3st parallel run thread
		Thread t3 = new Thread(new Runnable() {
			NSeq seq = new NSeq();
			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					seq.nextFs();
					seq.print();
				}
			}
		});
		t3.start();

		// 4st parallel run thread
		Thread t4 = new Thread(new Runnable() {
			NSeq seq = new NSeq();
			@Override
			public void run() {
				seq.nextFs();
				seq.print();for (int i = 0; i < 20; i++) {
					seq.nextFs();
					seq.print();
				}
			}
		});
		t4.start();
			
	}
	
}
