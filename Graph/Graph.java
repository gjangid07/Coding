package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Vertex {
	public char label;
	public boolean isVisited;
	public int index;
	public LinkedList<Vertex> linkedList;

	public Vertex(char c, int idx) {
		label = c;
		isVisited = false;
		index = idx;
		linkedList = new LinkedList<Vertex>();
	}

	public Vertex(char c, boolean b) {
		label = c;
		isVisited = b;
		linkedList = new LinkedList<Vertex>();
	}
}

public class Graph {

	private static Vertex[] vertexList;
	private int vertexListSize;
	private int currVertexList;
	private static int[][] adjMatrix;
	

	private static Stack<Vertex> stack;
	
	private static Queue<Vertex> queue;

	public Graph(int vertexes) {
		currVertexList = 0;
		vertexListSize = vertexes;
		vertexList = new Vertex[vertexListSize];
		adjMatrix = new int[vertexes][vertexes];
		stack = new Stack<Vertex>();
		queue = new LinkedList<Vertex>();
	}

	public void addVertex(Vertex v) {
		vertexList[currVertexList++] = v;
	}

	public void addEdge(int sourceVertex, int destVertex) {
		adjMatrix[sourceVertex][destVertex] = 1;
		adjMatrix[destVertex][sourceVertex] = 1;
	}
	
	public void addEdgeUsingAdjList(int sourceVertex, int destVertex) {
		vertexList[sourceVertex].linkedList.add(vertexList[destVertex]);
	}
	
	public static void dfsTraversalUsingAdjList() {

		stack.push(vertexList[0]);
		printVertex(vertexList[0]);
		vertexList[0].isVisited = true;

		while (!stack.isEmpty()) {
			Vertex v = neighborOfUsingAdjList(stack.peek());
			if (v == null) {
				stack.pop();
			} else {
				stack.push(v);
				printVertex(v);
				v.isVisited = true;
			}

		}

	}
	
	public static Vertex neighborOfUsingAdjList(Vertex v) {

		for (int i = 0; i < v.linkedList.size(); i++) {
			if (!v.linkedList.get(i).isVisited) {
				return v.linkedList.get(i);
			}
		}
		return null;
	}

	public static void dfsTraversal() {

		stack.push(vertexList[0]);
		printVertex(vertexList[0]);
		vertexList[0].isVisited = true;

		while (!stack.isEmpty()) {
			Vertex v = neighborOf(stack.peek());
			if (v == null) {
				stack.pop();
			} else {
				stack.push(v);
				printVertex(v);
				v.isVisited = true;
			}

		}

	}
	
	public static void bfsTraversal() {
		
		queue.add(vertexList[0]);
		printVertex(vertexList[0]);
		vertexList[0].isVisited = true;
		
		while(!queue.isEmpty()) {
			Vertex v = neighborOf(queue.peek());
			
			if(v==null) {
				queue.poll();
			}else {
				queue.add(v);
				printVertex(v);
				v.isVisited = true;
			}
		}
	}
	
	public static void bfsTraversalUsingAdjList() {

		queue.add(vertexList[0]);
		printVertex(vertexList[0]);
		vertexList[0].isVisited = true;

		while (!queue.isEmpty()) {
			Vertex v = neighborOfUsingAdjList(queue.peek());
			if (v == null) {
				queue.poll();
			} else {
				queue.add(v);
				printVertex(v);
				v.isVisited = true;
			}

		}

	}

	private static Vertex neighborOf(Vertex v) {

		for (int i = 0; i < vertexList.length; i++) {
			if (adjMatrix[v.index][i] == 1 && vertexList[i].isVisited == false) {
				return vertexList[i];
			}
		}
		return null;
	}

	public static void printVertex(Vertex v) {
		System.out.print(v.label + ",");
		v.isVisited = true;
	}
	
	

}
