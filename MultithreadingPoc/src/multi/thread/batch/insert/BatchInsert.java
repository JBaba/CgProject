package multi.thread.batch.insert;

import java.util.concurrent.CountDownLatch;

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
	
	public void run(){
		CountDownLatch fsCountDown = new CountDownLatch(count);
		FSInsert fsInsert = new FSInsert(count, fsCountDown);
		
		
	}
}

/**
 * FSInsert Parallel insert
 * @author jbaba
 *
 */
class FSInsert implements Runnable{

	int size = 0;
	CountDownLatch fsCountDown;
	
	public FSInsert(int size,CountDownLatch CountDown ) {
		this.size=size;
		this.fsCountDown=CountDown;
	}
	
	@Override
	public void run() {
		
	}
	
}
