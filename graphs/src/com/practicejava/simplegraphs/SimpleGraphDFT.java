package com.practicejava.simplegraphs;

import java.util.Stack;

public class SimpleGraphDFT // adds a method DFT to the class in Figure 9.14
{   
	Listing2 vertex[];  // the reference to the vertex array
	int edge[][];  // reference to the adjacency matrix array
	int max, numberOfVertices;
	
	public SimpleGraphDFT(int n)
	{  
		vertex = new Listing2[n]; // allocation of the vertex array
		edge = new int[n][n]; // adjacency matrix with elements set to 0
		max = n;   
		numberOfVertices = 0;
	}
	
	public void DFT(int firstVertex)
	{ 
		int v;
		Stack<Integer> stack = new Stack(); // uses Java Stack class
		// initialize all vertices to not visited
		for (int i = 0; i < numberOfVertices; i++)
		{  
			if(vertex[i] != null)
				vertex[i].setPushed(false); // mark all vertices unvisited
		}
		stack.push(firstVertex); // visit the first vertex
		vertex[firstVertex].setPushed(true);
		// visit all the decedents
	    while (!stack.empty())
		{  
	    	v = stack.pop();
	    	vertex[v].visit(); // visit a vertex
	    	for (int column = 0; column < numberOfVertices; column++)
	    	{  
	    		if(edge[v][column] == 1 && !vertex[column].getPushed())
	    		{  
	    			stack.push(column);
	    			vertex[column].setPushed(true);
	    		} // end if
	    	} // end for
		} // end while
	} // end DFT method
	
	public boolean insertVertex(int vertexNumber, Listing2 newListing)
	{  
		if(vertexNumber >= max) // the graph is full
			return false;
		vertex[vertexNumber] = newListing.deepCopy();   
		numberOfVertices++;
		return true;
	}
		
	public boolean insertEdge(int fromVertex, int toVertex)
	{  
		if(vertex[fromVertex] == null || vertex[toVertex] == null)
			return false; // nonexistent vertex
		edge[fromVertex][toVertex] = 1;
		return true;
	}
	
	public void showVertex(int vertexNumber)
    {  
		System.out.println(vertex[vertexNumber]);
	}
	
	public void showEdges(int vertexNumber) // edges from vertexNumber
	{  
		for(int column = 0; column < numberOfVertices; column++)
		{  
			if(edge[vertexNumber][column] == 1) // there is an edge
				System.out.println(vertexNumber + "," + column);
		}
	} // end showEdges method
	
	public static void main(String[] args)
	{  
		SimpleGraphDFT flyUS = new SimpleGraphDFT(5);
		Listing2 v0 = new Listing2("V0");
		Listing2 v1 = new Listing2("V1");
		Listing2 v2 = new Listing2("V2");
		Listing2 v3 = new Listing2("V3");
		Listing2 v4 = new Listing2("V4");
	
		flyUS.insertVertex(0, v0);
		flyUS.insertVertex(1, v1);
		flyUS.insertVertex(2, v2);
		flyUS.insertVertex(3, v3);
		flyUS.insertVertex(4, v4);

		flyUS.insertEdge(0,1);
		flyUS.insertEdge(0,3);
		flyUS.insertEdge(0,4);
		flyUS.insertEdge(1,0);
		flyUS.insertEdge(1,2);
		flyUS.insertEdge(1,3);
		flyUS.insertEdge(2,1);
		flyUS.insertEdge(3,0);
		flyUS.insertEdge(3,1);
		flyUS.insertEdge(3,4);
		flyUS.insertEdge(4,0);
		flyUS.insertEdge(4,3);

		System.out.println("DFT of the graph in Figure 9.19 starting at Vertex 3, \"V3\"");
		flyUS.DFT(3);
	} // end main method
} // end class SimpleGraphDFT
