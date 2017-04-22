package com.epi.design;

import java.util.ArrayList;
import java.util.List;

public class MaxProfit {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list = CanReachEnd.getList("310,315,275,295,260,270,290,230,255,250",list);

		System.out.println(list);
		int profit = maxProfit(list);

		BuySellStock sellStock = getMaxProfit(list);
		System.out.println(sellStock);
		
		System.out.println(profit);

	}

	private static BuySellStock getMaxProfit(List<Integer> list) {

		BuySellStock bs = new BuySellStock();
		bs.whenToBuy = 0;
		bs.whenToSell = 0;
		
		int index = 1;
		int maxProfit = 0;
		int minPriceIndex = 0;
		
		while(index < list.size()){
			int tempProfit = list.get(index)-list.get(minPriceIndex);
			if(tempProfit > maxProfit){
				bs.whenToBuy = minPriceIndex;
				bs.whenToSell = index;
				maxProfit = tempProfit;
			}
			minPriceIndex = ((list.get(index)<list.get(minPriceIndex))?index:minPriceIndex);
			index++;
		}
		
		return bs;
	}

	private static int maxProfit(List<Integer> list) {
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		
		for(int price:list){
			maxProfit = Math.max(maxProfit, price-minPrice);
			minPrice = Math.min(minPrice, price);
		}
		
		return maxProfit;
	}

}

class BuySellStock {
	
	public int whenToBuy;
	public int whenToSell;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "i:"+whenToBuy+" j:"+whenToSell;
	}
}