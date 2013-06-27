package com.practicejava.simplegraphs;

public class Listing2
{  
	private String name;
	boolean pushed;
	
	public Listing2(String n)
	{  
		name = n;
	}
	public String toString()
	{  
		return ("Name is " + name);
	} // end of toString method
	public Listing2 deepCopy()
	{  
		Listing2 clone = new Listing2(name);
		return clone;
	} // end of deepCopy method
	public boolean getPushed()
	{  
		return pushed;
	} // end of getPushed method
	public void setPushed(boolean value)
	{  
		pushed = value;
	} // end of setPushed method
	public void visit()
	{  
		System.out.println(this);
	} // end of visit method
	
} // end class Listing2