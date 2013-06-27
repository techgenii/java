package com.practicejava.myregex;

import java.util.regex.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;

public class myregex {
	
    private static final String TESTDATE_REGEX_DATE = "(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])-((19|2[0-9])\\d\\d)";
    private static final String REGEX_DATE_UK = "(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-((19|2[0-9])\\d\\d)";
    public enum DateType { US, UK };
    public static final Calendar cal = GregorianCalendar.getInstance();
    
    
    public static final String DATE_PATTERN_US = "MMM-dd-yyyy";
    public static final String DATE_PATTERN_UK = "dd-MMM-yyyy";
    
    public static final String DATE_PATTERN_US_NOFORMAT = "MM-dd-yyyy";
    public static final String DATE_PATTERN_UK_NOFORMAT = "dd-MM-yyyy";
    
    
    /** Private formatter instance for US date-only format */
    public static DateFormat DATE_FORMAT_US = new SimpleDateFormatReadOnly(DATE_PATTERN_US);

    /** Private formatter instance for UK date-only format */
    public static DateFormat DATE_FORMAT_UK = new SimpleDateFormatReadOnly(DATE_PATTERN_UK);
    
    /** Private formatter instance for US date-only noformat format */
    public static DateFormat DATE_FORMAT_US_NOFORMAT = new SimpleDateFormatReadOnly(DATE_PATTERN_US_NOFORMAT);
    
    /** Private formatter instance for UK date-only noformat format */
    public static DateFormat DATE_FORMAT_UK_NOFORMAT = new SimpleDateFormatReadOnly(DATE_PATTERN_UK_NOFORMAT);

    public static boolean validateDate (String aRegex, String aDate, DateType aType) {
        
	   	boolean isValidDate = false;
	   	int days = 0;
	   	int month = 0;
	   	int year = 0;
	    	
	   	Pattern p = Pattern.compile(aRegex, Pattern.CASE_INSENSITIVE);
	    Matcher m = p.matcher(aDate);
	
		if (m.matches()) {
				if (aType == DateType.US ) {
					month = Integer.parseInt(m.group(1));
					days = Integer.parseInt(m.group(2));
				}
				else {
					days = Integer.parseInt(m.group(1));
					month = Integer.parseInt(m.group(2));
				}
				year = Integer.parseInt(m.group(3));
		}
	    	           
	   switch (month) {
	    	case 1: case 3: case 5:
	    	case 7: case 8: case 10:
	    	case 12:
	    		isValidDate = ((days >= 1 && days <= 31) ? true : false);
	    		break;
	    	case 4: case 6:
	    	case 9: case 11:
	    		isValidDate = ((days >= 1 && days <= 30) ? true : false);
	    		break;
	    	case 2:
	    		if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) {
	        		isValidDate = ((days >= 1 && days <= 29) ? true : false);
	    		} else {
	        		isValidDate = ((days >= 1 && days <= 28) ? true : false);
	    		}
	    		break;
	    	default:
	    		isValidDate = false;
	    		break;
	    }
	    
	    return isValidDate;
    }
    
	public static boolean checkDate(Date d) {
		if (d == null) return false;
		cal.setTime(d);
		if (cal.get(Calendar.YEAR) < 32) return false;
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] dateStrUS = {  "28-07-2015", "07/20/2028", "07 20 2028", "07.20.2028", "02/28/2013", "04-02-2013", "02/29/2013", "04 20 2013,", "04 31 2013", "09/32/2013" };
		String[] dateStrUK = { "28-07-2015", "28-07-2515", "33-07-2015", "33-7-2015", "33-22-2515", "07/20/2028", "07 20 2028", "07.20.2028", "02/28/2013", "04-02-2013", "02/29/2013", "04 20 2013,", "04 31 2013", "09/32/2013" };

		boolean isValid;
		String dateStr, datePass;
    	ParsePosition pp = new ParsePosition(0);
    	Date d = null;

		System.out.println("-- US DATES Begin----");
		for (int i=0; i < dateStrUS.length; i++) {
			dateStr = dateStrUS[i];
			datePass = dateStr.replaceAll("[/,. ]", "-");
			isValid = validateDate(TESTDATE_REGEX_DATE, datePass, DateType.US);
			System.out.println("Date = " + dateStrUS[i] + " valid = " + isValid);
		}
		
		System.out.println("-- UK DATES Begin----");
		for (int i=0; i < dateStrUK.length; i++) {
			dateStr = dateStrUK[i];
			datePass = dateStr.replaceAll("[/,. ]", "-");
			isValid = validateDate(REGEX_DATE_UK, datePass, DateType.UK);
			System.out.println("Date = " + dateStrUK[i] + " valid = " + isValid);
		}
		
		dateStr = dateStrUS[0];
		datePass = dateStr.replaceAll("[/,. ]", "-");
		
		
    	// Check for the US Date Format: MMM-dd-yyyy
		pp.setIndex(0);
    	d = DATE_FORMAT_US.parse(datePass, pp);
    	if (checkDate(d)) {
			System.out.println("Date US = " + datePass);
		}

    	// Check for the UK Date Format: dd-MMM-yyyy
    	pp.setIndex(0);
    	d = DATE_FORMAT_UK.parse(datePass, pp);
    	if (checkDate(d)) {
			System.out.println("Date US = " + datePass);
		}
		System.out.println("-- DATE Check Begin----");
		if (validateDate(TESTDATE_REGEX_DATE, datePass, DateType.US)) {
    		pp.setIndex(0);
    		d = DATE_FORMAT_US_NOFORMAT.parse(datePass, pp);
    		if (checkDate(d)) {
    			System.out.println("Date US = " + datePass);
    		}
			
		}
		if (validateDate(REGEX_DATE_UK, datePass, DateType.UK)) {
    		pp.setIndex(0);
    		d = DATE_FORMAT_UK_NOFORMAT.parse(datePass, pp);
    		if (checkDate(d)) {
    			System.out.println("Date UK = " + datePass);
    		}
			
		}
		System.out.println("-- DATE Check End----");
		
	}

}
