package leetcode.sol.euler;

public class P_2 {

	int target = 999;
	
	public P_2() {
		run();
	}
	
	private void run() {
			int sum = 0;
			int x = 1;  // Represents the current Fibonacci number being processed
			int y = 2;  // Represents the next Fibonacci number in the sequence
			while (x <= 4000000) {
				if (x % 2 == 0)
					sum += x;
				int z = x + y;
				x = y;
				y = z;
			}
			System.out.println(sum);
	}

	public static void main(String[] args) {
		P_2 p = new P_2();
	}

}
