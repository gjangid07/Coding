package Graph;

public class Graph_Client {

	public static void main(String[] args) {
		Graph g = new Graph(6);
		
		g.addVertex(new Vertex('A', 0));
		g.addVertex(new Vertex('B', 1));
		g.addVertex(new Vertex('C', 2));
		g.addVertex(new Vertex('D', 3));
		g.addVertex(new Vertex('E', 4));
		g.addVertex(new Vertex('F', 5));
		
//		g.addEdge(0, 1);
//		g.addEdge(0, 3);
//		g.addEdge(1, 2);
//		g.addEdge(1, 3);
//		g.addEdge(3, 4);
//		g.addEdge(4, 5);
		
		g.addEdgeUsingAdjList(0, 1);
		g.addEdgeUsingAdjList(0, 3);
		g.addEdgeUsingAdjList(1, 2);
		g.addEdgeUsingAdjList(1, 3);
		g.addEdgeUsingAdjList(3, 4);
		g.addEdgeUsingAdjList(4, 5);
		
		Graph.bfsTraversalUsingAdjList();
//		System.out.println();
//		Graph.bfsTraversal();
	}
}
