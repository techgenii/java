package com.practivejava.lesson4;

public class TestTax {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        double grossIncome; // local variables
        String state;
        int dependents;

        grossIncome= 50000;
        dependents= 2;
        state= "NJ";

        Tax t = new Tax(grossIncome, state, dependents);
        Tax t2 = new Tax(65000, "TX", 4 );

        double yourTax = t.calcTax(); //calculating tax
        double hisTax = t2.calcTax(); // calculating tax
        
        String yourStr = Tax.convertTax2Euro(yourTax);
        String hisStr = Tax.convertTax2Euro(hisTax);
       
        // Printing the result
        System.out.println("Your converted tax is " + yourStr);
        System.out.println("His converted tax is " + hisStr);
	}

}
