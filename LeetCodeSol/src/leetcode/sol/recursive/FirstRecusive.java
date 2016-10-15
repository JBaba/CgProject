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

	/**
	 * For a given integer , print the first  rows of Pascal's Triangle. Print each row with each value separated by a single 
	 * space. The value at the  row and  column of the triangle is equal to n! / (r! * (n-r)!)  where indexing starts from . These values are the 
	 * binomial coefficients.

		The Pascal Triangle
		
		1
		1 1
		1 2 1
		1 3 3 1
		1 4 6 4 1
	 * 
	 * @param rows
	 * @param columns
	 */
	private static void pascalAlgo(int count,int rows,int columns){
		if(count<rows)
			return;
		for(int i = 0;i<=columns;i++){
			System.out.print(String.format("%2d", pascalValue(i,rows)));
		}
		System.out.println();
		pascalAlgo(count,rows+1, columns+1);
	}
	
	/**
	 * Returns value n! / (r! * (n-r)!) where n = row and r = column
	 * @param i is column
	 * @param rows 
	 * @return
	 */
	private static int pascalValue(int i,int rows) {
		// return 1 of 0!
		if(i==0) return 1;
		int value = 0;
		// impl of n! / (r! * (n-r)!) function
		value = (fact(rows))/(fact(i) * (fact((rows-i)==0?1:(rows-i))));
		return value;
	}

	public static void main(String[] args) {
		System.out.println(fib(3));
		System.out.println(printFib(7));
		System.out.println(fact(4));
		System.out.println(GCD(15,12));
		pascalAlgo(4,0,0);
	}

}
