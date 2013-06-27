package com.practicejava.lru;

import java.util.*;

public class lruTest {
	
	static class Stack {
		String[] nodes;
		int nodeCount = 0;
		
		public Stack() {
			nodes = new String[200];
			nodeCount = 0;
		}
		
		public Stack(int x) {
			if (x >= 0) {
				nodes = new String[x];
			}
			nodeCount = 0;
		}
		
		String pop() {
			if (nodeCount == 0)
				return null;
			else
				return nodes[--nodeCount];
		}
		
		void push (String s) {
			if (s.isEmpty() || s == null)
				return;
			else
				nodes[nodeCount++] = s;
		}
		
		String peek() {
			int top = nodeCount-1;
			if (top >= 0)
				return nodes[top];
			else
				return null;
		}
		
		String get(int index) {
			if (index >= 0 && index<=nodeCount)
				return nodes[index];
			else
				return null;
		}
		
		boolean contains(String s) {
			for (int i=0; i<nodeCount; i++) {
				if (nodes[i] == s)
					return true;
			}
			return false;
		}
		
		int size() {
			return nodes.length;
		}
		
		int totalItems() {
			return nodeCount;
		}
		
		boolean isEmpty() {
			return (nodeCount == 0);
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack(20);
		String[] s = {"Mary", "Joe", "Jeff", "Jane", "List", "Another", "Jeff", "Come", "Daniel", "Doe", "Jane", "Lift"};
		
		if (stack.isEmpty())
			System.out.println("List is empty.");
		
		for (int i=0; i<s.length; i++) {
			if (s[i] == null || s[i].isEmpty())
				System.out.println("Null or empty string. Skipping....");
			else if (stack.contains(s[i]))
				System.out.println(s[i] + " already exists in the list. Skipping...");
			else {
				stack.push(s[i]);
				System.out.println(s[i] + " added to the list.");
			}
		}
		
		// print the size of the stack
		System.out.println("Size of stack = " + stack.size());
		
		// total items on the stack
		System.out.println("Total stack item = " + stack.totalItems());
		
		// review item from the top of the stack
		System.out.println("Look at top stack item = " + stack.peek());
		
		// remove an item from the top of the stack
		System.out.println("Pop top stack item = " + stack.pop());
		
		
		//Random Stack Lookpus....
		Random generator = new Random();
		int randomIndex = 0;
		for (int i=0; i<stack.totalItems(); i++) {
			randomIndex = generator.nextInt( stack.totalItems() );
			System.out.println(stack.get(randomIndex) + " is in the list at index " + randomIndex);
		}	
	}

}
