package leetcode.sol.structure;

public class Queue {
	
	private final int[] arry;
	private int front = -1;
	private int end = -1;

	public Queue(int size) {
		arry = new int[size];
	}
	
	public static void main(String[] args) {
		Queue q = new Queue(5);
		for (int i = 1; i < q.size()+2 ; i++) {
			q.add(i);
			q.print();
		}
		
		q.remove();
		q.print();
		
		q.add(6);
		q.print();
		
		q.add(6);
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
		if(front == (size()-1)){
			int item = arry[front];
			arry[front] = Integer.MIN_VALUE;
			front = 0;
			return item;
		}else if(front == -1){
			int item = arry[0];
			arry[0] = Integer.MIN_VALUE;
			front = 1;
			return item;
		}else{
			int item = arry[front];
			arry[front] = Integer.MIN_VALUE;
			++front;
			return item;
		}
	}

	private void add(int i) {
		if(isFull()){
			System.out.println("Queue is full.");
		}else if(end==(size()-1)){
			// pointer at end and front is empty
			end = 0;
			arry[end] = i;
		}else if(end>=front){
			++end;
			arry[end] = i;
		}
	}

	/**
	 * @return
	 */
	public boolean isFull() {
		boolean result = false;
		if(front==-1 && end==(size()-1))
			return true;
		if(front==-1 && end!=(size()-1))
			return false;
		if(front<end && (end-front)==(size()-1))
			result = true;
		else if(end<front && (front)==(end+1))
			result = true;
		return result;
	}

	/**
	 * @return
	 */
	public boolean isEmpty() {
		boolean result = false;
		if(front == -1 && end == -1)
			return true;
		else if(front==end)
			return true;
		return result;
	}
}
