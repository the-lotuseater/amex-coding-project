package com.codingproject;

import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codingproject.constants.CommonConstants;


public class App{	

	 private static Logger logger = LoggerFactory.getLogger(App.class);
	
	public static  void main(String[] args) {
		logger.trace("Received order");
		if(args.length<1) //default case
			return;
		if(args[0].equalsIgnoreCase("consumer")) //If app is called as a consumer
			Consumer.Consume();

		System.out.println("Welcome to Abhisheks Fruit Store!!");
		double cost = calculateTotal(args);
		logger.trace("Received order");
		System.out.println("Thank you for shopping! Your total is $"+cost);

		StringBuilder builder = new StringBuilder();
		for(String item: args) {
			builder.append(item+" ");
		}
		Producer.produce(new ArrayList<>(Arrays.asList(cost, builder.toString().trim())));
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
