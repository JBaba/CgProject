package multi.thread.batch.insert;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;

import multi.thread.entity.FsPayment;
import multi.thread.entity.persiter.Persister;
import multi.thread.logs.CategoryLoggerMultipaleFiles.LogCategory;
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
	
	public BatchInsert() {
	}
	
	public void run() throws Exception{
		singleRun(null);
	}
	
	public void singleRun(CountDownLatch countDown){
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				CountDownLatch fsCountDown = new CountDownLatch(1);
				FSInsertWorker fsInsert = new FSInsertWorker(count, fsCountDown);
				fsInsert.start();
				try {
					fsCountDown.await();
					// only if its not null
					if(countDown!=null){
						countDown.countDown();
					}
				} catch (InterruptedException e) {
					ILog.iclog(e);
				}
				
			}
		});
		t.start();
	}
	
	/**
	 * Run Multiple at a time
	 * @author jbaba
	 *
	 */
	public void multipleRuns(int NoOfRuns,int batch){
		
		Stack<BatchInsert> list = new Stack<>();
		
		for (int i = 0; i < NoOfRuns; i++) {
			list.add(new BatchInsert(batch));
		}
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				int temp = 1;   
				// run in pair of 4 till list becomes empty
				while (!list.isEmpty()) {
					
					long lStartTime = new Date().getTime();  // start time
					
					CountDownLatch fsCountDown = new CountDownLatch(4);
					
					BatchInsert b1 = list.pop();
					BatchInsert b2 = list.pop();
					BatchInsert b3 = list.pop();
					BatchInsert b4 = list.pop();
					
					b1.singleRun(fsCountDown);
					b2.singleRun(fsCountDown);
					b3.singleRun(fsCountDown);
					b4.singleRun(fsCountDown);
					
					try {
						fsCountDown.await();

						long lEndTime = new Date().getTime(); // end time
						long difference = lEndTime - lStartTime; // check different
						ILog.iclog(LogCategory.DC,"Elapsed seconds: " + (difference/1000));
						
						ILog.iclog(LogCategory.DC,"Run no: "+temp+" is done.");
						temp++;
					} catch (InterruptedException e) {
						ILog.iclog(e);
					}
				}
				ILog.iclog(LogCategory.DC,"Multipale Run done.................");
			}
		});
		t.start();
	}
	
	public static void main(String[] args){
		int num = 320;
		BatchInsert bi = new BatchInsert();
		bi.multipleRuns(num,1050);
		/*BatchInsert b2 = new BatchInsert();
		b2.multipleRuns(num,50);*/
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
