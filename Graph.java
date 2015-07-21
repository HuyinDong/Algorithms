package com.alg.basic;

import java.util.ArrayList;

class Vertex{
	private String name;
	private ArrayList<Vertex> next = new ArrayList<Vertex>();
	private int key;
	private Vertex parent;
	
	public Vertex getParent() {
		return parent;
	}
	public void setParent(Vertex parent) {
		this.parent = parent;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public ArrayList<Vertex> getNext() {
		return next;
	}
	public void setNext(ArrayList<Vertex> next) {
		this.next = next;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Vertex(String name) {
		super();
		this.name = name;
		this.key = Integer.MAX_VALUE;
	}
	@Override
	public String toString() {
		return this.getName();
	}
}
class Edge{
	private Vertex start;
	private Vertex end;
	private int weight;
	public Edge(Vertex start, Vertex end, int weight) {
		super();
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	public Vertex getStart() {
		return start;
	}
	public void setStart(Vertex start) {
		this.start = start;
	}
	public Vertex getEnd() {
		return end;
	}
	public void setEnd(Vertex end) {
		this.end = end;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
public class Graph {
	private ArrayList<Vertex> vertices = new ArrayList<Vertex>();
	private ArrayList<Edge> edges= new ArrayList<Edge>();
	public ArrayList<Vertex> getVertices() {
		return vertices;
	}
	public void setVertices(ArrayList<Vertex> vertices) {
		this.vertices = vertices;
	}
	public ArrayList<Edge> getEdges() {
		return edges;
	}
	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}
	private int[][] gra = null;
	
	
	public int[][] getGra() {
		return gra;
	}
	public void setGra(int[][] gra) {
		this.gra = gra;
	}
	public Graph(int size) {
		super();
		this.gra = new int[size][size];
	}
	public void addVertex(String name){
		Vertex vertex = new Vertex(name);
		this.vertices.add(vertex);
	}
	public void addEdge(String start, String end, int weight){
		Vertex startVertex = vertices.get(this.searchVertex(start));
		Vertex endVertex = vertices.get(this.searchVertex(end));
		startVertex.getNext().add(endVertex);
		endVertex.getNext().add(startVertex);
		Edge edge = new Edge(startVertex,endVertex,weight);	
		edges.add(edge);
		this.mapGrap(edge);
	}
	private void mapGrap(Edge e){
		Vertex startVertex = e.getStart();
		Vertex endVertex = e.getEnd();
		
		int i = this.searchVertex(startVertex.getName());
		int j = this.searchVertex(endVertex.getName());
		gra[i][j] = e.getWeight();
		gra[j][i] = e.getWeight();
	}
	public int searchVertex(String name){
		  int i = 0;
		for(; i<vertices.size();i++){
			if(vertices.get(i).getName().equals(name)){
				return i;
			}
	}
		i = -1;
		return i;
}
	public void printGrap(){
		for(int i = 0 ; i< vertices.size();i++){
			System.out.print("  "+vertices.get(i).getName());
		}
		System.out.println();
		for(int i = 0 ; i<vertices.size();i++){
			System.out.print(vertices.get(i).getName()+" ");
			for(int j = 0; j<vertices.size();j++){
				System.out.print(gra[i][j]+"  ");
			}
			System.out.println();
		}
		for(Vertex v : vertices){
			System.out.println(v+":"+v.getNext());
		}
	}
	public static void main(String[] args){
	
	}
}