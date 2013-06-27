package com.practice.cellphone;

import java.util.LinkedList;
import java.util.List;

public class CellPhone {  
    // Number-to-letter mappings in order from zero to nine
    public static String mappings[][] = {
        {"0"},
        {"1"}, 
        {"A", "B", "C"}, //2
        {"D", "E", "F"}, //3
        {"G", "H", "I"}, //4
        {"J", "K", "L"}, //5
        {"M", "N", "O"}, //6
        {"P", "Q", "R", "S"}, //7
        {"T", "U", "V"}, //8
        {"W", "X", "Y", "Z"} //9
    };

    public static void generateCombosHelper(List<String> combos, String prefix, String remaining) {
        // The current digit we are working with
        int digit = Integer.parseInt(remaining.substring(0, 1));

        if (remaining.length() == 1) {
            // We have reached the last digit in the phone number, so add 
            // all possible prefix-digit combinations to the list
            for (int i = 0; i < mappings[digit].length; i++) {
                combos.add(prefix + mappings[digit][i]);
            }
        } else {
            // Recursively call this method with each possible new 
            // prefix and the remaining part of the phone number.
            for (int i = 0; i < mappings[digit].length; i++) {
                generateCombosHelper(combos, prefix + mappings[digit][i], remaining.substring(1));
            }
        }
    }

    public static List<String> generateCombos(String phoneNumber) {
        // This will hold the final list of combinations
        List<String> combos = new LinkedList<String>();

        // Call the helper method with an empty prefix and the entire 
        // phone number as the remaining part.
        generateCombosHelper(combos, "", phoneNumber);
        return combos;
    }

    public static void main(String[] args) {
        String phone = "234";
        List<String> combos = generateCombos(phone);

        System.out.println("---Initial Input=" + phone);
        for (String s : combos) {
            System.out.println(s);
        }
        System.out.println("---DONE---");

    }
}
