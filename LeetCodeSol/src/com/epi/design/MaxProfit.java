package com.epi.design;

import java.util.ArrayList;
import java.util.List;

public class MaxProfit {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list = CanReachEnd.getList("310,315,275,295,260,270,290,230,255,250",list);

		System.out.println(list);
		int profit = maxProfit(list);
		System.out.println(profit);

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
