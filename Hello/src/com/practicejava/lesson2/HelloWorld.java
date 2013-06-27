package com.practicejava.lesson2;

public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String text = "1,234,890"; // example String
		double value = Double.parseDouble(text.replaceAll("[^0-9.]", ""));
		
		// TODO Auto-generated method stub
		System.out.println("Hello World");
	}

}
