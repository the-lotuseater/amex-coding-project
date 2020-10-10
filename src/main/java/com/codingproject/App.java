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
		for(String arg: args) {
			switch(arg.toUpperCase()) {
			case CommonConstants.APPLE: total+=CommonConstants.APPLE_COST;break ;
			case CommonConstants.ORANGE: total+=CommonConstants.ORANGE_COST;break;
			default: throw (new IllegalArgumentException("Sorry we could not find that item in our catalog."));
			}
		}
		return total;
	}
	
}
