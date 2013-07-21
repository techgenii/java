package com.practicejava.recursion;

public class recursion {
	 
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
	    boolean perm = false;
	    
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
