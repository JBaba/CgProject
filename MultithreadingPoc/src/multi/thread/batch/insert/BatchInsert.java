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
		pRun();
	}
	
	public void pRun(){
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				CountDownLatch fsCountDown = new CountDownLatch(1);
				FSInsertWorker fsInsert = new FSInsertWorker(count, fsCountDown);
				fsInsert.start();
				
				try {
					fsCountDown.wait();
					System.out.println("Prun Done");
				} catch (InterruptedException e) {
					ILog.iclog(e);
				}
				
			}
		});
		t.start();
	}
	
	public static void main(String[] args){
		int count = 100;
		BatchInsert bi = new BatchInsert(count);
		BatchInsert bi1 = new BatchInsert(count);
		BatchInsert bi2 = new BatchInsert(count);
		BatchInsert bi3 = new BatchInsert(count);
		BatchInsert bi4 = new BatchInsert(count);
		ILog.iclog("Main Thread is done");
		try{
			bi.run();
			bi1.run();
			bi2.run();
			bi3.run();
			//bi4.run();*/
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
		
		n = randCase.nextInt(250) + 1;
		fs.setPayAmt(n);
		
		fs.setPaymentBegDt(Calendar.getInstance().getTime().toString());
		fs.setPaymentEndDt(Calendar.getInstance().getTime().toString());
		
		return fs;
	}

	@Override
	public void run() {
		Persister p = new Persister();
		int temp = 0;
		while (size != temp) {
			temp++;
			FsPayment fs = initFs();
			p.add(fs);
		}
		
		try {
			p.insert();
		} catch (Exception e) {
			ILog.iclog(e);
		}
		fsCountDown.countDown();
	}
	
}
