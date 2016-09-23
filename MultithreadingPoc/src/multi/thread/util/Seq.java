package multi.thread.util;

import multi.thread.entity.persiter.SeqDao;
import multi.thread.logs.ILog;

/**
 * Seq for tables
 * @author jbaba
 *
 */
public class Seq {

	static long fs = 2;
	static long pm = 2;
	static long tf = 2;
	
	private Seq() {
		try {
			fs = (new SeqDao()).getMaxKey("Fs_Payment");
			fs++;
			pm = (new SeqDao()).getMaxKey("Pm_Payment");
			pm++;
			tf = (new SeqDao()).getMaxKey("Tf_Payment");
			tf++;
		} catch (Exception e) {
			ILog.iclog(e);
		}
	}
	
	/**
	 * Singleton of seq
	 * @author jbaba
	 *
	 */
	public enum ISeq{
		Iseq;
		private final Seq seq;
		private ISeq() {
			seq = new Seq();
		}
		public Seq getInstance(){
			return seq;
		}
	}
	
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
	
	@Override
	public String toString() {
		return "Seq [fs=" + fs + ", pm=" + pm + ", tf=" + tf + "]";
	}

}
