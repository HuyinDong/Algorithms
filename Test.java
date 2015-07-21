package com.alg.basic;

import java.util.ArrayList;

public class Test {
	private Graph graph;
	private Vertex current;
	private Vertex root;
	private int i = 0;
	ArrayList<Vertex> adjacent = null;
	private Stack<Vertex> stack = new Stack<Vertex>();
	public boolean[] visited = null;
	public Test(Graph graph, String rootName) {
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
	public boolean isVisited(String name){
		int t = graph.searchVertex(name);
		return this.visited[t];
	}
	public boolean isAllVisited(ArrayList<Vertex> list){
		for(Vertex v : list){
			if(this.visited[graph.searchVertex(v.getName())] == false){
				return false;
			}
		}
		return true;
	}
	public void setVisited(Vertex v){
		this.visited[graph.searchVertex(v.getName())] = true;
	}
	public void DFS() {
			this.stack.push(current);
			this.setVisited(current);
			adjacent = current.getNext();
			this.getAdjacent();
		}
	public void getAdjacent() {
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
	public static void main(String[] args) throws Exception{ // test
		Graph graph = null;
		try{
		System.out.println(graph.toString());
		}catch(Exception e){
			System.out.println("null value");
		}
	}

}
