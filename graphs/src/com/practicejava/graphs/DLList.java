package com.practicejava.graphs;

public class DLList {
	
	 public static DLNode head, end;
	 public DLList() {
	    head = new DLNode(0);
	    end = new DLNode(0);
	 }

	 public boolean isEmpty() {
	    return (head.next == null);
	 }

	 public void insert(int value)  {
	    DLNode current, previous, temp;
	    temp = new DLNode(value);
	    current = head;
	    previous = head;
	    while ((current.next != null) && (value > current.data)) {
	       previous = current;
	       current = current.next;
	    }
	    if (value < current.data) {
	         temp.next = current;
	         current.back = temp;
	         previous.next = temp;
	         temp.back = previous;
	     } else {
	         end = temp;
	         current.next = temp;
	         temp.back = current;
	     }
	  }

						 
	  public DLNode search(int value) {
	    DLNode current = head;
		while (current.next != null && current.data != value) {
			current = current.next;
		}
		return current;

	  }

	  public void deleteItem(int value) {
	    DLNode current, previous;
	    if (!isEmpty()) {
	    	current = head;
	    	previous = head;
	    	while (current != null) {
	    		if (current.data == value) {
	    			previous.next = current.next;
	    			if (current.next!= null) // check if end of list
	    				current.next.back = previous;
	    			else
	    				end = previous;    // new end of list
	    		}
	    		else {
	    			previous = current;
	    			current = current.next;
	    		}
	         }
	       }
	       return;
	    }

	   public void writeListinOrder() {
		     DLNode current = head;
		     if (isEmpty())
		         System.out.println("List is empty ");
		     else {
		         while (current != null) {
		          System.out.println(current.data);
		          current = current.next;
		         }
		     }
	  }
	   
	  public static void writeListReversed(){
	    DLNode current = end;
	    if (end == null)
	        System.out.println("List is empty ");
	    else {
	        while (current.back != null) {
	          System.out.println(current.data);
	          current = current.back;
	      }
	    }
	  }

}
