package leetcode.sol.recursive;

/**
 * This class contains easy recursive problems and solutions
 * @author nviradia
 *
 */
public class FirstRecusive {

	public FirstRecusive() {
	}
	
	/**
	 * Fibonacci rec solution
	 * @param n
	 * @return
	 */
	public static int fib(int n){
		return (n<=1)?n:fib(n-1)+fib(n-2);
	}
	
	public static int printFib(int n){
		if(n<=1){
			return n;
		}else{
			return printFib(n-1)+printFib(n-2);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(fib(3));
		System.out.println(printFib(7));
	}

}
