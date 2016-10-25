package leetcode.sol.extra;

public class MyStack {

	int[] arry;
	int index = -1;
	
	public MyStack(int size) {
		arry = new int[size];
	}
	
	public boolean isFull(){
		return (arry.length-1 != index) ? false : true;
	}
	
	public boolean isEmpty(){
		return (-1 == index) ? true : false;
	}
	
	public void push(int item){
		if(!isFull()){
			++index;
			arry[index] = item;
		}else{
			throw new RuntimeException("Stack is full.");
		}
	}
	
	public int pop(){
		if(isEmpty()){
			throw new RuntimeException("Stack is Empty.");
		}else{
			int item = arry[index];
			--index;
			return item;
		}
	}
	
	public int size(){
		return arry.length;
	}
	
	public void print(){
		System.out.println(arry);
	}
	
	public static void main(String[] args) {
		MyStack my = new MyStack(5);
		
		for (int i = 0; i < my.size()+1 ; i++) {
			try{
				my.push(i);
			}catch(Exception e){
				e.printStackTrace();
			}
				my.print();
		}
		
		for (int i = 0; i < my.size()+1 ; i++) {
			try{
				my.pop();
			}catch(Exception e){
				e.printStackTrace();
			}
			my.print();
		}
	}

}
