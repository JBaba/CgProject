package com.amazon.hash;

import java.util.HashMap;
import java.util.Map;

public class KeyPadProb {

	Map<Integer,String> keyMap;
	
	public KeyPadProb() {
		keyMap = new HashMap<Integer, String>();
		keyMap.put(0, "");
		keyMap.put(1, "");
		keyMap.put(2, "ABC");
		keyMap.put(3, "DEF");
		keyMap.put(4, "GHI");
		keyMap.put(5, "JKL");
		keyMap.put(6, "MNO");
		keyMap.put(7, "PQRS");
		keyMap.put(8, "TUV");
		keyMap.put(9, "WXYZ");
	}
	
	public static void main(String[] args) {
		KeyPadProb p = new KeyPadProb();
		p.printAll(367);
	}

	private void printAll(int i) {
		printAll(i+"",0,"");
	}

	private void printAll(String string,int ix,String val) {
		if(ix>=string.length()){
			System.out.println(val);
			return;
		}
		
		String keys = keyMap.get(Integer.parseInt(string.charAt(ix)+""));
		
		if(keys.length()>0){
			for(int i=0;i<keys.length();i++){
				String ch = keys.charAt(i)+"";
				printAll(string,ix+1,val+ch);
			}
		}else{
			printAll(string,ix+1,val);
		}
	}

}
