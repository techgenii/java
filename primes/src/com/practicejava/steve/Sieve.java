package com.practicejava.steve;

public class Sieve {
    
    private static int upperLimit = 10000;
    private static boolean[] flags;

    public Sieve() {
    }

    public static void main(String[] args) {
        initialize(args);
        findPrimes();
        displayPrimes();
    }
    
    private static void initialize(String[] args) {
        if (args.length > 0) {
            upperLimit = Integer.parseInt(args[0]);
        }
        /* 
         * Create a set of boolean (true/false) flags, corresponding to the 
         *     integers from 2 to upper limit, in order. 
         */
        flags = new boolean[upperLimit + 1];
        /* 
         * While position is less than or equal to upper limit: 
         *   Set the flag corresponding to position to the value false. 
         *   Increment position by 1.
         */
        for (int position = 0; position <= upperLimit; position++) {
            flags[position] = false;
        }
    }

    private static void findPrimes() {
    	 /*
         * Set position to 2. 
         * While position is less than or equal to square root of upper limit: 
         */
        for (int position = 2; position <= Math.sqrt(upperLimit); position++) {
            // If the flag corresponding to position has the value false: 
            if (!flags[position]) {
                /*
                 *   Set multiple to twice the value of position.
                */
                int multiple = position * 2;
            	/*
                 *   While multiple is less than or equal to upper limit: 
                 *     Set the flag corresponding to the multiple to the value true. 
                 *     Increment multiple by position. 
                 */
                while (multiple <= upperLimit) {
                    flags[multiple] = true;
                    multiple += position;
                }                
            }
            /* Increment position by 1. */
        }
    }
    
    private static void displayPrimes() {
    	System.out.println("---Printing Prime Numbers");
        for (int position = 2; position <= upperLimit; position++) { 
            if (!flags[position]) { 
                System.out.print(position + " "); 
            } 
        }
        System.out.println();
    	System.out.println("---Done Prime Numbers");
    }

}
