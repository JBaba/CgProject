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
	
	/**
	 * factorial rec solution
	 * @param n
	 * @return
	 */
	public static int fact(int n){
		return (n==1)?n:n*fact(n-1);
	}
	
	/**
	 * GCD rec solution
	 * @param n
	 * @return
	 */
	public static int GCD(int x,int y){		
		int d = (x<y)?x:y;
		return findGCD(x,y,d);
	}
	
	private static int findGCD(int x, int y, int d) {
		if(x%d == 0 && y%d == 0)
			return d;
		else
			return findGCD(x, y, d-1);
	}

	public static void main(String[] args) {
		System.out.println(fib(3));
		System.out.println(printFib(7));
		System.out.println(fact(4));
		System.out.println(GCD(15,12));
	}

}
