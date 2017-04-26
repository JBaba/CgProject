package com.amazon;

import java.util.HashMap;
import java.util.Map;

public class MapMatch {

	Map<String,String> map = new HashMap<>();
	Map<String,Boolean> isVisited = new HashMap<>();
	
	public static void main(String[] args) {
		MapMatch mm = new MapMatch();
		mm.asossiate("a","b");
		mm.asossiate("b","c");
		mm.asossiate("a","d");
		boolean ans = mm.doesMatchV2("a","d");
		
		mm.init();
		ans = mm.doesMatchV3("a","d");
		System.out.println(ans);
		ans = mm.doesMatchV2("c","d");
		System.out.println(ans);
		mm.asossiate("x","a");
		ans = mm.doesMatchV2("c","x");
		System.out.println(ans);
	}

	private void init() {
		isVisited = new HashMap<>();
	}

	private boolean doesMatchV3(String a, String b) {
		
		boolean flag = false;
		
		if(a.equalsIgnoreCase(b))
			return true;
		
		if(!map.containsKey(a))
			//if(!map.containsKey(b))
				return false;
		
		String[] ary = null;
		
		isVisited.put(a, true);
		ary = map.get(a).split(",");
	
		for(String item:ary){
			if(!isVisited.containsKey(item)){
				flag |= doesMatchV3(item, b);
			}
		}
	
		return flag;
	}

	private boolean doesMatch(String a, String b) {
		if(map.containsKey(a)){
			return findMatch(a,b,false,false,null);
		}else{
			return findMatch(b,a,false,false,null);
		}
	}
	
	private boolean doesMatchV2(String a, String b) {
		isVisited = new HashMap<>();
		FindTheMatch ftm = new FindTheMatch();
		return findMatchV2(a,b,ftm,null);
	}

	private boolean findMatch(String a, String b, boolean c, boolean d,
			String next) {

		if(c && d)
			return true;
		if(next != null && map.get(next) == null)
			return false;
		
		if(next == null){
			if(map.containsKey(a)){
				c = true;
				return findMatch(a,b,c,d,map.get(a));
			}else{
				return findMatch(a,b,c,d,map.get(a));
			}
		}else{
			if(next.equalsIgnoreCase(a)){
				c = true;
				return findMatch(a,b,c,d,map.get(next));
			}else if(next.equalsIgnoreCase(b)){
				d = true;
				return findMatch(a,b,c,d,map.get(next));
			}else{
				return findMatch(a,b,c,d,map.get(next));
			}
		}
	}

	private boolean findMatchV2(String a, String b,FindTheMatch ftm,String next) {

		if(ftm.c && ftm.d)
			return true;
		if(next != null && map.get(next) == null)
			return false;
		
		if(next == null){
			isVisited.put(a, true);
			if(map.containsKey(a)){
				ftm.c = true;
				for(String item:map.get(a).split(",")){
					if(!isVisited.containsKey(item)){
						findMatchV2(a,b,ftm,item);
					}
				}
			}else{
				for(String item:map.get(a).split(",")){
					if(!isVisited.containsKey(item)){
						findMatchV2(a,b,ftm,item);
					}
				}
			}
		}else{
			isVisited.put(next, true);
			if(next.equalsIgnoreCase(a)){
				ftm.c = true;
				for(String item:map.get(next).split(",")){
					if(!isVisited.containsKey(item)){
						findMatchV2(a,b,ftm,item);
					}
				}
			}else if(next.equalsIgnoreCase(b)){
				ftm.d = true;
				for(String item:map.get(next).split(",")){
					if(!isVisited.containsKey(item)){
						findMatchV2(a,b,ftm,item);
					}
				}
			}else{
				for(String item:map.get(next).split(",")){
					if(!isVisited.containsKey(item)){
						findMatchV2(a,b,ftm,item);
					}
				}
			}
		}
		
		return ftm.c && ftm.d;
	}
	
	
	private void asossiate(String a, String b) {

		if(!map.containsKey(a)){
			map.put(a, b);
		}else{
			map.put(a, (map.get(a)!=null?map.get(a)+","+b:b));
		}
		
		if(!map.containsKey(b)){
			map.put(b, a);
		}else{
			map.put(b, (map.get(b)!=null?map.get(b)+","+a:a));
		}
		
	}

}

class FindTheMatch {
	public boolean c =  false,d = false;
}
