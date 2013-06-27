package com.practicejava.graphs;

public class Queue {
	Node first;
	Node last;
	
	Queue () {
		first = null;
		last = null;
	}
	
	void enqueue(int value) {;
	    if (first == null) {
	         last = new Node(value);
	         first = last;
	    }
	    else {
	         last.next = new Node(value);
	         last = last.next;
	    }
	}
	
	int dequeue() {
		int item = -1;
	    if (!isEmpty( )) {
	    	 item = first.data;
	         first = first.next;
	    }
	    return item;
	}
	
	boolean isEmpty() {
		return (first == null);	
	}
}