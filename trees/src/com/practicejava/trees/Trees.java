package com.practicejava.trees;

public class Trees {
	
	// binary tree representation
	static class Node {
		private Node left;
		private Node right;
		private int value;
		
		public Node( ) {
			return;
		}
		
		public Node (Node left, Node right, int value) {
			this.left = left;
			this.right = right;
			this.value = value;
		}
		
		public Node getLeft() { return left; }
		public Node getRight() { return right; }
		public int getValue() { return value; }
		public void printValue() {
			System.out.println( "Value = " + value);
		}
		
		private int findNextLowerValue(Node tree) {
			// tree is initially the left child node
			if (tree.right == null)
				return tree.getValue();
			else
			   return findNextLowerValue(tree.right);
		}
		
		public Node insert (Node tree, int  item) {
			// empty tree / sub-tree so insert here
		    if (tree == null){         
		         tree = new Node(null, null, item);
		     }
		     else {
		    	 if (item < tree.getValue())
		    		// recursive calls to left subtree
		    		 tree.left = insert(tree.left, item); 
		         else
		        	// recursive calls to right subtree
		             tree.right =  insert(tree.right, item); 
		    }
		    // address of root of tree or the new sub-tree
		    return tree;  
		 }
		
		public Node deleteNode (Node tree, int item) {
			   // tree empty or key not present
			   if (tree == null) {                 
			        System.out.println(item + " is not present");
			   }
			   else if (item < tree.getValue())
			       // recursive call to left subtree
				   tree.left = deleteNode (tree.left, item);
			       // recursive call to left subtree
			   else if (item > tree.getValue())
			       // recursive call to right subtree
			       tree.right = deleteNode (tree.right, item);
			   else {            // correct node has been found so prepare to delete
			        // Case 1 - leaf node, set parent to null 
			        if ((tree.right == null) && (tree.left == null))
			                tree = null;
			        // Case 2Ðsingle child, link parent to the child node
			        else if (tree.left == null)     // no left child so set to right
			                 tree = tree.right;
			        else if (tree.right == null)    // no right child so set to left
			                 tree = tree.left;
			        // Case 3 - two children, replace by next lower value node data
			        else {
			             int replacementValue = findNextLowerValue(tree.left);
			             tree.value = replacementValue;   // copy data to target node
			             tree.left = deleteNode (tree.left, replacementValue);
			             // delete the replacing node
			        }
			    } 
			    // return the changed link so as to maintain the tree
			    return tree;
		}
		
		public Node findNode( Node root, int value ){
		    if( root == null ) return null;
		    int currval = root.getValue();
		    if( currval == value ) return root;
		    if( currval < value ){
		        return findNode( root.getRight(), value );
		    } else { // currval > value
		        return findNode( root.getLeft(), value );
		    }
		}
		
		public boolean isNode( Node root, int value ){
		    if( root == null ) return false;
		    int currval = root.getValue();
		    if( currval == value ) return true;
		    if( currval < value ){
		        return isNode( root.getRight(), value );
		    } else { // currval > value
		        return isNode( root.getLeft(), value );
		    }
		}
		
		public void printPreOrder (Node root) {
			if (root == null)
				return;
			root.printValue();
			printPreOrder(root.getLeft());
			printPreOrder(root.getRight());
		}
		
		public void printInOrder (Node root) {
			if (root == null)
				return;
			printInOrder(root.getLeft());
			root.printValue();
			printInOrder(root.getRight());
		}
		
		public void printPostOrder (Node root) {
			if (root == null)
				return;
			printInOrder(root.getLeft());
			printInOrder(root.getRight());
			root.printValue();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val = { 35, 56, 18, 24, 9, 27, 6, 10, 45, 32, 105, 93, 12, 21, 62, 73, 84, 33 };
		Node tree = new Node(null, null, val[0]);
		System.out.println("Inserting... " + val[0]);

		// populate the tree
		for(int i=1; i < val.length; i++) {
			System.out.println("Inserting... " + val[i]);
			tree.insert(tree, val[i]);
		}
		
		// print the tree
		System.out.println("Print Left Child");
		tree.printInOrder(tree.getLeft());
		System.out.println("Print Right Child");
		tree.printInOrder(tree.getRight());
		System.out.println("Print the root");
		tree.printValue();
		
		//search the tree
		System.out.println("Finding node 32...");
		Node find = tree.findNode(tree, 32);
		if (find != null) {
			System.out.println("Found node...");
			find.printValue();
		}
		else
			System.out.println("Node not found...");

		System.out.println("Finding node 105...");
		find = tree.findNode(tree, 105);
		if (find != null) {
			System.out.println("Found node...");
			find.printValue();
		}
		else
			System.out.println("Node not found...");

		System.out.println("Searching for node 88...");
		if (tree.isNode(tree, 88)) {
			System.out.println("Found node...");
		}
		else
			System.out.println("Node not found...");

		System.out.println("--- In Order Entire Tree --- ");
		tree.printInOrder(tree);
		System.out.println("--- Post Order Entire Tree --- ");
		tree.printPostOrder(tree);
		System.out.println("--- Pre Order Entire Tree --- ");
		tree.printPreOrder(tree);

	}

}
