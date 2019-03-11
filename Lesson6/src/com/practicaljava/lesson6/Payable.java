package com.practicaljava.lesson6;

public interface Payable {
	
	final int INCREASE_CAP = 20;
	default boolean increasePay(int percent) {
		
		System.out.println("Default code implement pay increase goes here");
		return true;
		
	}

}
