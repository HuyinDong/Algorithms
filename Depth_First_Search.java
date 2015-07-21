package com.alg.basic;

import java.util.ArrayList;

public class Depth_First_Search {
	private Graph graph;					
	private Vertex current;						//current vertex which is also the peek of stack
	private Vertex root;						//set root to begin with
	private int i = 0;						    //pointer in the adjacent which is a ArrayList
	ArrayList<Vertex> adjacent = null;
	private Stack<Vertex> stack = new Stack<Vertex>();
	public boolean[] visited = null;
	public Depth_First_Search(Graph graph, String rootName) {		
		super();
		this.graph = graph;
		for (Vertex v : graph.getVertices()) { // get root vertex in the graph
			if (v.getName().equals(rootName)) {
				this.root = v;
				break;
			}
		}
		this.current = root;
		visited = new boolean[graph.getVertices().size()];
	}
	public boolean isVisited(String name){			//check if the vertex has been visited
		int t = graph.searchVertex(name);
		return this.visited[t];
	}
	public boolean isAllVisited(ArrayList<Vertex> list){	//check if all the vertices in the adjacent is visited
		for(Vertex v : list){
			if(this.visited[graph.searchVertex(v.getName())] == false){
				return false;
			}
		}
		return true;
	}
	public void setVisited(Vertex v){					//set visited of a vertex
		this.visited[graph.searchVertex(v.getName())] = true;
	}
	public void DFS() {						
			this.stack.push(current);					//initialize the stack
			this.setVisited(current);		
			this.getAdjacent();
		}
	public void getAdjacent() {							//traverse the graph 
		while(!this.stack.isEmpty()){
				adjacent = this.current.getNext();		
				if(this.isAllVisited(adjacent)){
					System.out.print(this.stack.pop()+"-->");
					if(stack.isEmpty()){
						break;
					}
					current = stack.peek();
				}else if(!this.isVisited(adjacent.get(i).getName())){
					this.current = adjacent.get(i);
					this.stack.push(current);
					this.setVisited(current);
					i = 0;
				}else{
					i++;
				}
				this.getAdjacent();
				}
			}		
	public static void main(String[] args) { // test
		Graph graph = new Graph(11);
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addVertex("H");
		graph.addVertex("I");
		graph.addVertex("J");
		graph.addVertex("K");
		graph.addEdge("A", "B", 4);
		graph.addEdge("A", "F", 3);
		graph.addEdge("B", "C", 5);
		graph.addEdge("C", "D", 2);
		graph.addEdge("D", "H", 6);
		graph.addEdge("D", "E", 1);
		graph.addEdge("E", "F", 5);
		graph.addEdge("F", "G", 1);
		graph.addEdge("G", "I", 2);
		graph.addEdge("G", "J", 2);
		graph.addEdge("F", "K", 2);
		graph.printGrap();
		Depth_First_Search df = new Depth_First_Search(graph, "A");
		df.DFS();
	}

}
