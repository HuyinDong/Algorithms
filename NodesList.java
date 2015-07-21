package com.alg.basic;

class Node{
	private String name;
	private Node next;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node(String name) {
		super();
		this.name = name;
	}	
}
public class NodesList{
	private Node head;

	public Node getHead() {
		return head;
	}
	public void setHead(Node head) {
		this.head = head;
	}
	public void addNode(Node node){
		if(this.head == null){
			this.head = node;
		}else{
			Node tail = this.searchTail();
			tail.setNext(node);
		}
	}
	public void insertNode(int location, Node node){
		Node temp = this.head;
		Node beforeNode = null;
		try{
			for(int i = 0; i<location; i++){
				beforeNode = temp;
				temp = temp.getNext();
			}
			if(beforeNode != null){
				beforeNode.setNext(node);
				node.setNext(temp);
			}else{
				this.head = node;
				node.setNext(temp);
			}
			}catch(Exception e){
				System.out.println("Invalid Input");
			}
	}
	public void removeNode(int location){
		Node temp = this.head;
		Node beforeNode = null;
		Node afterNode = null;
		try{
		for(int i = 0; i<location; i++){
			beforeNode = temp;
			temp = temp.getNext();
			afterNode = temp.getNext();
		}
		if(afterNode != null){
			beforeNode.setNext(afterNode);
		}else{
			beforeNode.setNext(null);
		}
		}catch(Exception e){
			System.out.println("Invalid Input");
		}
	}
	public Node searchTail(){
		Node temp = this.head;
		while(temp.getNext() != null){
			temp = temp.getNext();
		}
		return temp;
	}
	public void printList(){
		Node temp = this.head;
		while(temp.getNext() != null){
			System.out.print(temp.getName()+"-->");
			temp = temp.getNext();
		}
		System.out.print(temp.getName());
	}
	public static void main(String[] args){
		NodesList nl = new NodesList();
		Node n1 = new Node("1");
		Node n2 = new Node("2");
		Node n3 = new Node("3");
		Node n4 = new Node("4");
		nl.addNode(n1);
		nl.addNode(n2);
		nl.addNode(n3);
		nl.insertNode(0, n4);
		
		nl.printList();
		System.out.println();
		nl.removeNode(1);
		nl.printList();
	}
}