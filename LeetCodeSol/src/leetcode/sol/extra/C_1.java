package leetcode.sol.extra;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class C_1 {

	public static int openingRightDoor(int input1,String input2)
    {
		
		if(input1 < 3)
			return 0;
		
	    int mid = input1/2;
		
		int first = (input1%2==0)? mid-1 : mid;
		int second = mid;
		int results = 0;
		
		while (first >= 0 || second < input1 ) {
			if(input2.charAt(first) != input2.charAt(second)){
				first--;
				second++;
				results+=2;
			}else{
				first--;
				second++;
			}
		}
		
		return results;
    }
	
	public static int openingRightDoor2(int input1,String input2)
    {
		
		if(input1 < 3)
			return 0;
		
		int results=0;
		
		Map<Integer,Integer> map = new LinkedHashMap<>();
	    
		for(int _char : input2.toCharArray()){
			if(map.containsKey(_char)){
				map.put(_char, map.get(_char)+1);
			}else{
				map.put(_char, 1);
			}
		}
		
		for(int _key : map.keySet()){
			int occurances = map.get(_key);

			if(occurances % 2 != 0){
				results += (occurances % 2); 
			}
			
		}
		
		return (input1%2==0)?results:results-1;
    }
	
	public void num(double d,int len){
		double x = d;
		for(int i=0;i<len;i++){
			x += 0.1d;
			System.out.printf("%1.1fd,",x);
		}
	}
	
	public void update(int start,String num,int len){
		String update = "update Ua_Clientua_Completn_Status set QUESTION_ID = ? where CLIENTUA_COMPLETN_STATUS_ID = ";
		
		int c = 0;
		
		for(int i=0;i<len;i++){
			
			c++;
			
			if(c%10 == 0)
				c++;
			
			String st = update.replace("?", num+""+c) + start +" ;";
			
			start++;
			
			System.out.println(st);
		}
	
	}
	
	public static void main(String[] args) {
		C_1 c=new C_1();
		
		File folder = new File("C:\\DEV\\CT_DEV\\BridgesEAR\\lib\\axis2");
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        System.out.println(listOfFiles[i].getName());
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }
		
	}

}
