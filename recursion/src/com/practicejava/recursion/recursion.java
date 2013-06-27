package com.practicejava.recursion;

public class recursion {

	// recursive declaration of method factorial
	public static long factorial(long number) {
		// base cases: 0! = 1 and 1! = 1
	    if (number == 1 || number == 0)
	      return 1; 
	    else
	      // recursion step
	      return (number * factorial(number - 1));
	}
	
	 // recursive declaration of method fibonacci
	 public static long fibonacci(long number) {
	    if ((number == 0) || (number == 1)) // base cases
	      return number;
	    else
	      // recursion step
	      return (fibonacci(number - 1) + fibonacci(number - 2));
	 }
	 
	 // find all permutations of a string
	  public static void permuteString(String beginningString, String endingString) {
		  if (endingString.length() <= 1)
		      System.out.println(beginningString + endingString);
		  else {
			  for (int i = 0; i < endingString.length(); i++) {
		        try {
		          String newString = endingString.substring(0, i) + endingString.substring(i + 1);
		          permuteString(beginningString + endingString.charAt(i), newString);
		        } catch (StringIndexOutOfBoundsException exception) {
		          exception.printStackTrace();
		        }
		      }
		  }
	  }
	  
	  // Raise x to the power n
	  static double power(double x, int n) {
	    if (n > 1)
	      return (x * power(x, n - 1)); // Recursive call
	    else if (n < 0)
	      return (1.0 / power(x, -n)); // Negative power of x
	    else
	      return x;
	  }
	  
	  // Towes of Hanoi
	  public static void doTowers(int topN, char from, char inter, char to) {
		    if (topN == 1) {
		      System.out.println("Move Disk 1 from " + from + " to " + to);
		    } else {
		      doTowers(topN - 1, from, to, inter);
		      System.out.println("Move Disk " + topN + " from " + from + " to " + to);
		      doTowers(topN - 1, inter, from, to);
		    }
	  }
	  
	  public static String sort(String s) {
		  char[] content = s.toCharArray();
		  java.util.Arrays.sort(content);
		  return new String(content);
	  }
	  
	  public static boolean permutation(String s, String t) {
		  if (s.length() != t.length())
			  return false;
		  return sort(s).equals(sort(t));
	  }

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int nDisks = 3;
	    double x = 5.0;
	    boolean perm = false;
	    
	    System.out.println(x + " to the power 4 is " + power(x, 4));
	    System.out.println("7.5 to the power 5 is " + power(7.5, 5));
	    System.out.println("7.5 to the power 0 is " + power(7.5, 0));
	    System.out.println("10 to the power -2 is " + power(10, -2));
	    
	    // Towers of Hanoi
	    System.out.println("-- Towers of Hanoi --");
	    doTowers(nDisks, 'A', 'B', 'C');

		// Factorial
	    System.out.println("-- Factorial --");
	    for (int counter = 0; counter <= 10; counter++)
	        System.out.printf("%d! = %d\n", counter, factorial(counter));

	    // Fibonacci numbers
	    System.out.println("-- Fibonnaci numbers --");
	    for (int counter = 0; counter <= 10; counter++)
	        System.out.printf("Fibonacci of %d is: %d\n", counter, fibonacci(counter));
	    
	    // Find all of the permutations of a string
	    System.out.println("-- Find All String Permutations --");
	    permuteString("", "dog");
	    permuteString("", "cat");
	    
	    // Find all of the permutations of a string
	    System.out.println("-- Is one string a permutation of another string --");
	    perm = permutation("god", "dog");
	    System.out.println("Permutation = " + perm);
	    perm = permutation("tac", "cat");
	    System.out.println("Permutation = " + perm);
	    perm = permutation("first", "dog");
	    System.out.println("Permutation = " + perm);
	    perm = permutation("good", "food");
	    System.out.println("Permutation = " + perm);

	}

}
