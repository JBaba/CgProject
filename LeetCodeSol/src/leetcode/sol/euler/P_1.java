package leetcode.sol.euler;

public class P_1 {

	int target = 999;
	
	public P_1() {
		run(10,3,5);
		run(1000,3,5);
		System.out.println(SumDividibleBy(3)+SumDividibleBy(5)-SumDividibleBy(15));
	}
	
	private int SumDividibleBy(int n){
		int p = target/n;
		return (n*(p*(p+1))) / 2;
	}
	
	private void run(int number, int num1, int num2) {
		int sum = 0;
		
		int smallNumber = (num1<num2)?num1:num2;
		
		for (int i = 1; i < ((number/smallNumber)+1) ; i++) {
			int temp = num1 * i;
			// multiple is smaller then number
			if(temp < number)
				sum += temp;
			
			temp = num2 * i;
			
			if(temp < number && !(temp%num1 == 0))
				sum += temp;
		}
		
		System.out.println(sum);
	}

	public static void main(String[] args) {
		P_1 p = new P_1();
	}

}
