package leetcode.sol.extra;

public class DeadLock {

	public static void main(String[] args) throws Exception {
		DeadLock d = new DeadLock();
		Runnable task1 = () -> {
			synchronized (d) {
				try {
					System.out.println("Task 1 is waiting.");
					d.wait();
					System.out.println("Task 1 is Out of Wait.");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable task2 = () -> {
			synchronized (d) {
				try {
					System.out.println("Task 2 is waiting.");
					d.wait();
					System.out.println("Task 2 Out of Wait.");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable task3 = () -> {
			synchronized (d) {
				try {
					System.out.println("Task 3 trys to notify.");
					d.notifyAll();
					System.out.println("Task 3 notify.");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		Thread t3 = new Thread(task3);
		
		t1.start();
		t2.start();
		
		t1.sleep(100);
		t2.sleep(100);
		
		t3.start();
		//t3.start();
		
	}

}
