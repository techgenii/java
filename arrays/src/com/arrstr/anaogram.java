package com.arrstr;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: barbarabickham
 * Date: 7/20/13
 * Time: 9:28 PM
 */
public class anaogram {

    // anogram
    public static boolean anogram(String orig, String comp) {
        // if string is null, empty, blank, or length = 0, return false
        if (orig == null || orig.isEmpty() || orig.equals("") || orig.length() == 0) {
            return false;
        }

        // if string is null, empty, blank, or length = 0, return false
        if (comp == null || comp.isEmpty() || comp.equals("") || comp.length() == 0) {
            return false;
        }

        // if the lengths are not the same, then return false
        if (orig.length() != comp.length()) {
            return false;
        }

        // got to the end of the permuted string and compare the chars of the strings
        int j = 0;
        for (int i = comp.length()-1; i >= 0; i--) {
            if ( j < orig.length() ) {
                if (orig.charAt(j++) != comp.charAt(i))  {
                    return false;
                }
            };
        }

        return true;
    }


    /**
     * @param args command line args
     */
    public static void main(String[] args) {
        String compStr = "abbc";
        String angStr = "cbba";

        if (anogram(compStr,angStr))  {
            System.out.println("Success " + compStr + " " + angStr);
        }


        compStr = "abcd";
        angStr = "cdba";
        if (!anogram(compStr, angStr))  {
            System.out.println("Fail " + compStr + " " + angStr);
        }

    }
}
