package com.practicejava.graphs;

public class Node {
		int data;
		Node next = null;
		
		public Node(int d) {
			this.data = d;
		}
		
		void appendToTail(int d) {
			Node end = new Node(d);
			Node n = this;
			while (n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
		
		Node insertInFront(int d) {
			Node l = new Node(d);
			l.next = this;
			return l;
		}
		
		Node findNode(int d) {
			Node n = this;
			while (n.next != null && n.data != d) {
				n = n.next;
			}
			return n;
		}
		
		Node deleteNode(Node head, int d) {
			Node l = head;
			
			if (l.data == d) {
				return head.next;
			}
			
			while (l.next != null) {
				if (l.next.data == d) {
					l.next = l.next.next;
					return head;
				}
				l = l.next;
			}
			return head;
		}
		
		
}
