package com.practicejava.simplegraphs;

class SimpleGraph// a directed graph, (digraph)
{  
   Listing vertex[];  // the reference to the vertex array
   int edge[][];      // reference to the adjacency matrix array
   int max, numberOfVertices;
   
   public SimpleGraph(int n)
   {  
	  vertex = new Listing[n]; // allocation of the vertex array
      edge = new int[n][n];   // adjacency matrix initialized to zeros
      max = n;   
      numberOfVertices = 0;
   }
   
   public boolean insertVertex(int vertexNumber, Listing newListing)
   {   
		if(vertexNumber >= max)  // the graph is full
			return false;
		vertex[vertexNumber] = newListing.deepCopy();  
		numberOfVertices++;
		return true;
	} // end insertVertex method
   
	public boolean insertEdge(int fromVertex, int toVertex)
	{  
		if(vertex[fromVertex] == null || vertex[toVertex] == null)
			return false; // nonexistent vertex
		edge[fromVertex][toVertex] = 1;
		return true;
	} // end insertEdge method
	
	public void showVertex(int vertexNumber)
	{  
		System.out.println(vertex[vertexNumber]);
	} // end showVertex method
	
	public void showEdges(int vertexNumber) // emanating from vertexNumber
	{  
		for(int column = 0; column < numberOfVertices; column++)
		{  
			if(edge[vertexNumber][column] == 1) // an edge found
				System.out.println(vertexNumber + "," + column);
		}
	} //end showEdges method
	

	public static void main(String[] args)
	{   
		SimpleGraph flyUS = new SimpleGraph(5);
	    Listing v0 = new Listing("Philadelphia");
		Listing v1 = new Listing("New York");
		Listing v2 = new Listing("Boston");
		Listing v3 = new Listing("Los Angeles");
	    Listing v4 = new Listing("Houston");
		// add the hub cities to the graph as vertices
	    flyUS.insertVertex(0, v0);
		flyUS.insertVertex(1, v1);
		flyUS.insertVertex(2, v2);
		flyUS.insertVertex(3, v3);
		flyUS.insertVertex(4, v4);
		// add the routes to the graph as edges
		flyUS.insertEdge(0,1);
		flyUS.insertEdge(0,3);
		flyUS.insertEdge(1,2);
		flyUS.insertEdge(1,3);
		flyUS.insertEdge(2,1);
		flyUS.insertEdge(3,1);
		flyUS.insertEdge(3,4);
		flyUS.insertEdge(4,0);
		flyUS.insertEdge(4,3);
	    // output the hubs and the routes stored in the graph
		for(int i = 0; i < 5; i++)
		{  
			System.out.print("hub " + i + "\'s ");
			flyUS.showVertex(i);
			System.out.println("its routes are: ");
			flyUS.showEdges(i);
		} // end the output loop
	} // end of main method
	
} // end of class SimpleGraph
