package leetcode.sol.extra;

import java.util.ArrayList;
import java.util.List;

public class DigitalClock {

	/**
	 * Give All possible combination of time in Digital Clock:
	 * 
	 * where first row with 4 leads : Hour 
	 *       second row with 6 leads : Minute 
	 * Input is number of leads is turned on at time with this number
	 * give all possible combination of time.
	 * 
	 */
	public static void main(String[] args){
		DigitalClock dc = new DigitalClock();
		
		List<String> list = dc.getTimes(3);
		System.out.println(list);
		
		System.out.println(String.format("%09d", Integer.parseInt("1234")));
		System.out.println(String.format("%.2f", 2.123d));
	}

	private List<String> getTimes(int bits) {
		List<Integer> bitsHour = getBitsForHour(bits);
		List<Integer> bitsMinute = getBitsForMinute(bits);
		
		List<String> result = new ArrayList<String>();
		
		for(int i = 0; i<=bits; i++){
			List<Integer> hour = getBitsForHour(i,bitsHour);
			List<Integer> minute = getBitsForMinute(bits-i,bitsMinute);
			
			for(int j=0;j<hour.size();j++){
				for(int k=0;k<minute.size();k++){
					result.add(hour.get(j)+":"+minute.get(k));
				}
			}
		}
		
		return result;
	}

	private List<Integer> getBitsForMinute(int i, List<Integer> bitsMinute) {
		List<Integer> result = new ArrayList<Integer>();
		for(int j = 0;j<bitsMinute.size();j++){
			if(Integer.bitCount(bitsMinute.get(j)) == i){
				if(!result.contains(bitsMinute.get(j)))
					result.add(bitsMinute.get(j));
			}
		}
		// you can't do this break at runtime
		return result;
	}

	private List<Integer> getBitsForHour(int i, List<Integer> bitsHour) {
		List<Integer> result = new ArrayList<Integer>();
		for(int j = 0;j<bitsHour.size();j++){
			if(Integer.bitCount(bitsHour.get(j)) == i){
				if(!result.contains(bitsHour.get(j)))
					result.add(bitsHour.get(j));
			}
		}
		// you can't do this break at runtime
		return result;
	}

	private List<Integer> getBitsForMinute(int bits) {
		List<Integer> result = new ArrayList<>();
		for(int i=0; i<(Math.pow(2,6));i++){
			// did not added into original sol only 60 minutes
			if(i==61)
				break;
			
			if(Integer.bitCount(i) <= bits)
				result.add(i);
		}
		
		// you can't do this break at runtime
		return result;
	}

	private List<Integer> getBitsForHour(int bits) {
		List<Integer> result = new ArrayList<>();
		for(int i=0; i<(Math.pow(2,4));i++){
			// did not added into original sol only 12 hours
			if(i==13)
				break;
			
			if(Integer.bitCount(i) <= bits)
				result.add(i);
		}
		
		// you can't do this break at runtime
		return result;
	}
}
