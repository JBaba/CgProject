package multi.thread.batch.insert;

import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import multi.thread.entity.FsPayment;
import multi.thread.entity.persiter.Persister;
import multi.thread.logs.ILog;

/**
 * Insert operations
 * @author jbaba
 *
 */
public class BatchInsert {
	int count = 0;
	public BatchInsert(int count) {
		this.count = count;
	}
	
	public void run() throws Exception{
		CountDownLatch fsCountDown = new CountDownLatch(count);
		FSInsertWorker fsInsert = new FSInsertWorker(count, fsCountDown);
		fsInsert.start();
	}
	
	public static void main(String[] args){
		BatchInsert bi = new BatchInsert(10);
		try{
			bi.run();
		}catch(Exception e){
			ILog.iclog(e);
		}
	}
}

/**
 * FSInsert Parallel insert
 * @author jbaba
 *
 */
class FSInsertWorker extends Thread{

	int size = 0;
	CountDownLatch fsCountDown;
	
	public FSInsertWorker(int size,CountDownLatch CountDown ) {
		this.size=size;
		this.fsCountDown=CountDown;
		
		initFs();
	}
	
	/**
	 * Init entity
	 * @return
	 */
	private FsPayment initFs() {
		FsPayment fs =new FsPayment();
		
		Random randCase = new Random();
		int  n = randCase.nextInt(500) + 1;
		
		fs.setCaseNum(n+"");
		
		n = randCase.nextInt(250) + 1;
		fs.setEdgNum(n+"");
		
		fs.setProgCd("FS");
		
		double d = randCase.nextDouble();
		fs.setPayAmt(d);
		
		fs.setPaymentBegDt(Calendar.getInstance().getTime().toString());
		fs.setPaymentEndDt(Calendar.getInstance().getTime().toString());
		
		return fs;
	}

	@Override
	public void run() {
		Persister p = new Persister();
		while (fsCountDown.getCount() != 0) {
			FsPayment fs = initFs();
			p.add(fs);
			fsCountDown.countDown();
		}
		
		try {
			p.insert();
		} catch (Exception e) {
			ILog.iclog(e);
		}
	}
	
}
