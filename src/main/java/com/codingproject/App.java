package com.codingproject;


import com.codingproject.constants.CommonConstants;

public class App {

	public static  void main(String[] order) {
		System.out.println("Welcome to Abhisheks Fruit Store!!");
		double cost= calculateTotal(order);
		System.out.println("Thank you for shopping! Your total is $"+cost);
	}
	
	public static double calculateTotal(String[] args) {
		double total = 0D;
		int appleCount =0, orangeCount=0;
		for(String arg: args) {
			switch(arg.toUpperCase()) {
			case CommonConstants.APPLE: {
					appleCount++;
					break; 
			}
			case CommonConstants.ORANGE: {
					orangeCount++;
					break;
			}
			default: throw (new IllegalArgumentException("Sorry we could not find that item in our catalog."));
			}
		}
		appleCount = appleCount/2 + appleCount%2;
		orangeCount = 2*orangeCount/3 + orangeCount%3;
		total = appleCount*CommonConstants.APPLE_COST + orangeCount*CommonConstants.ORANGE_COST;
		return total;
	}
	
}
