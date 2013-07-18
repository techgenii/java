package com.practivejava.lesson4;

class Tax {
	double grossIncome; // class member variables
	String state;

	int dependents;
	static int customerCounter;

	// Constructor
	Tax (double gi, String st, int depen){
	     grossIncome = gi;  // member variable initialization
	     state = st;
	     dependents=depen;
	     customerCounter++;    // increment the counter by one
	     System.out.println("Preparing the tax data for customer #" + customerCounter);
	}
	
	double calcTax() {
		return (grossIncome*0.33-dependents*100);
	}
	
    static String convertTax2Euro(double tax) {
	    return "$" + tax + " (" + tax * 1.25 + " euros)";
	}
}
