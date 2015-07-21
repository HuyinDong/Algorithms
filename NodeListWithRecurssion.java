package com.alg.basic;

class Node1{
	private String name;
	private Node1 next;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Node1 getNext() {
		return next;
	}
	public void setNext(Node1 next) {
		this.next = next;
	}
	public Node1(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return this.name;
	}
	
	
}

public class NodeListWithRecurssion {
		private Node1 header;
		
		public Node1 getHeader() {
			return header;
		}
		public void setHeader(Node1 header) {
			this.header = header;
		}
		public void addNode(Node1 node){
			if(header == null){
				this.header = node;
			}else{
				this.getLastNode(header).setNext(node);
			}
		}
		public Node1 getLastNode(Node1 node){
			if(node.getNext() == null){
				return node;
			}else{
				return this.getLastNode(node.getNext());
			}
		}
		
		
		@Override
		public String toString() {
			return "NodeListWithRecurssion [header=" + header + "]";
		}

		public void printNode(Node1 node){
			if(node.getNext() == null){
				System.out.print(node);
			}else{
				System.out.print(node+"==>");
				printNode(node.getNext());
			}
		}
		public void print(){
			printNode(header);
		}
		public static void main(String[] args){
			Node1 n1 = new Node1("1");
			Node1 n2 = new Node1("2");
			Node1 n3 = new Node1("3");
			Node1 n4 = new Node1("4");
			NodeListWithRecurssion nlwr = new NodeListWithRecurssion();
			nlwr.addNode(n1);
			nlwr.addNode(n2);
			nlwr.addNode(n3);
			nlwr.addNode(n4);
			System.out.println(nlwr);
			nlwr.print();
		}
}
