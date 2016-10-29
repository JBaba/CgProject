package leetcode.sol.structure;

public class Queue_2 {
	
	private final int[] arry;
	private int front = 0;
	private int end = -1;
	private int count = 0;

	public Queue_2(int size) {
		arry = new int[size];
	}
	
	public static void main(String[] args) {
		Queue_2 q = new Queue_2(5);
		for (int i = 1; i < q.size()+2 ; i++) {
			q.add(i);
			q.print();
		}
		
		q.remove();
		q.print();
		
		q.add(6);
		q.print();
		
		q.remove();
		q.add(7);
		q.print();
	}

	private int size() {
		return arry.length;
	}

	private void print() {
		for(int i=0;i<size();i++){
			System.out.print(String.format("%2d", arry[i]));
		}
		System.out.println();
		System.out.println("-------------");
	}

	private int remove() {
		int result = Integer.MIN_VALUE;
		if(isEmpty()){
			System.out.println("Queue is full.");
		}else if(front==(size()-1)){
			result = arry[front];
			arry[front]=Integer.MIN_VALUE;
			front = 0;
			--count;
		}else{
			result = arry[front];
			arry[front]=Integer.MIN_VALUE;
			++front;
			--count;
		}
		return result;
	}

	private void add(int i) {
		if(isFull()){
			System.out.println("Queue is full.");
		}else if(end==(size()-1)){
			// pointer at end and front is empty
			end = 0;
			arry[end] = i;
			++count;
		}else{
			++end;
			arry[end] = i;
			++count;
		}
	}

	/**
	 * @return
	 */
	public boolean isFull() {
		return (count==size())?true:false;
	}

	/**
	 * @return
	 */
	public boolean isEmpty() {
		return (count==0)?true:false;
	}
}
