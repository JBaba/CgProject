package leetcode.sol.extra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Scanner;

public class Dijkstars  {
	/* Store the structure of the Maze. */
	private static int[][] matrix = null;
	private static String str;
	
	private static int m = 0, n = 0;
	
	 /* Main method.
	 */
	public static void main(String[] args) {
		
		// Scanner to read from the console.
		Scanner consoleScanner = new Scanner(System.in);
		// Scanner to read from the file.
		Scanner fileScanner = null;
		
		System.out.print("Enter the file containing the matrix: ");
		String inputFileName = consoleScanner.nextLine();
		
		/*
		 * Try block.
		 */
		try {
			File inputFile = new File(inputFileName);
			fileScanner = new Scanner(inputFile);
			
			BufferedReader bf = new BufferedReader(new FileReader(inputFile)); 
			
			
			// Read the no. of Nodes
			if(fileScanner.hasNextLine())
				m = Integer.parseInt(fileScanner.next());
							
			n = m;
			System.out.println("Matrix has " + m + " Nodes.");
								
			String[] length = fileScanner.nextLine().split(" ");//Removing Space
			
			System.out.print("Enter the starting vertex: ");
			int startingVertex = consoleScanner.nextInt();
			
			matrix = new int[m][n];
			
			int lineCount = 0;
			while(fileScanner.hasNextLine()){
				String[] currentLine = fileScanner.nextLine().split(" "); 
				for(int i = 0; i < currentLine.length; i++){
					matrix[lineCount][i] = Integer.parseInt(currentLine[i]);
				}
				lineCount++;
			}
				
			for(int i = 0; i < matrix.length; i++) {
				for(int j = 0; j < matrix[i].length; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.print("\n");
			}
			
			FindShortPath sp = new FindShortPath(matrix, startingVertex, m);
		    sp.dijkstra(matrix, startingVertex);
		    
			
			
		}
		/*
		 * Catch block.
		 */
		catch(FileNotFoundException fileNotFoundException) {
			System.out.println("File not found.");
		}
		/*
		 * Catch block.
		 */
		catch(Exception exception) {
			System.out.println("Exception occured: ");
			exception.printStackTrace();
		}
		/*
		 * Finally block.
		 */
		finally {
			if(consoleScanner != null)	consoleScanner.close();
			if(fileScanner != null)	fileScanner.close();
		}
	}
		
		
}
