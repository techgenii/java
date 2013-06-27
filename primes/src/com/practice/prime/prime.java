package com.practice.prime;

public class prime {
	
    private static int upperLimit = 100;
	
	public static boolean isPrime(int number) {
		  int sqrt = (int)Math.sqrt(number);
	      if (number == 1)
	            return false;
	      if (number == 2)
	            return true;
	      if (number % 2 == 0)
	            return false;
	      // number is a multiple of any integer between 2 and square root of number
	      for (int d = 3; d <= sqrt; d++) {
	            if (number % d == 0)
	                  return false;
	      }
	      return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    	System.out.println("---Printing Prime Numbers");
        for (int i = 0; i <= upperLimit; i++) { 
            if (isPrime(i)) { 
                System.out.print(i + " "); 
            } 
        }
        System.out.println();
    	System.out.println("---Done Prime Numbers");

	}

}
