package com.practicejava.graphs;

public class Stack {
	Node top;
	int stackCnt = 0;
	
	int pop () {
		if (top != null) {
			int item = top.data;
			stackCnt--;
			top = top.next;
			return item;
		}
		return -1;
	}
	
	void push(int item) {
		Node t = new Node(item);
		t.next = top;
		top = t;
		stackCnt++;
	}
	
	int peek() {
		return top.data;
	}
	
	boolean isEmpty() {
		return (top == null);
	}
	
	Node get(int index) {
		Node n = top;
		if (index >= 0 && (int) index <= stackCnt) {
			for (int i = 0; i < index; i++) {
				n = n.next;
			}
			return n;
		}
		else
			return null;
	}
	
	boolean contains(int d) {
		Node n = top;
		while (n != null) {
			if (n.data == d)
				return true;
			else
				n = n.next;
		}
		return false;
	}
	
}
