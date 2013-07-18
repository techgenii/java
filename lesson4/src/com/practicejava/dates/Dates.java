package com.practicejava.dates;

import java.util.Calendar;

public class Dates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        // Create a calendar with year and day of year.
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2012);
        calendar.set(Calendar.DAY_OF_YEAR, 9);
         
        // See the full information of the calendar object.
        System.out.println(calendar.getTime().toString());
         
        // Get the weekday and print it
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println("Day of Week: " + dayOfWeek);
        

        if (dayOfWeek == 6) { // Friday
        	calendar.add(Calendar.DATE, 3);
        }
        else if (dayOfWeek == 7) { // Saturday
        	calendar.add(Calendar.DATE, 2);
        } else { // Any other day
        	calendar.add(Calendar.DATE, 1);
        }
        
        dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println("Next Week Day: " + dayOfWeek);
        // See the full information of the calendar object.
        System.out.println(calendar.getTime().toString());

	}

}
