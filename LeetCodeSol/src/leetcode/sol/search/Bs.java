package leetcode.sol.search;

public class Bs {

	public Bs() {
		int[] maze = new int[8];
		int number = 10000000;
		
		for(int i = 0;i<maze.length;i++){
			for (int j = 0; j < 10; j++) {
				maze[i] = ((i*number)+j);
			}
		}
		
		int target = (number*6) -1;
		
		long start = System.currentTimeMillis();
		
		start = System.currentTimeMillis();
		start = System.currentTimeMillis();
		start = System.currentTimeMillis();
		start = System.currentTimeMillis();
		
		
		binarySearch(maze,target);
		long end =  System.currentTimeMillis();
		System.out.println((end-start));
	
		System.out.println("------------------");
		
	}
	
	private void binarySearch(int[] maze, int target) {

	}

	public static void main(String[] args) {
		Bs bs = new Bs();
	}

}
