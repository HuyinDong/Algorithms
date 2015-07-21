package com.alg.basic;

public class Queue<T> {
	private class Node{
		private T current;
		private Node next;
		public T getCurrent() {
			return current;
		}
		public void setCurrent(T current) {
			this.current = current;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node() {
			super();
		}
		@Override
		public String toString() {
			return "Node [current=" + current + ", next=" + next + "]";
		}
	}
	
	@Override
	public String toString() {
		return "Queue [head=" + head + ", tail=" + tail + ", size=" + size
				+ "]";
	}
	private Node head;
	private Node tail;
	private int size;
	public boolean isEmpty(){
		return head==null;
	}
	public void enQueue(T t){
		Node node = new Node();
		node.setCurrent(t);
		if(this.isEmpty()){
			this.head = node;
			this.tail = node;
			size++;
		}else{
		this.tail.setNext(node);
		this.tail = node;
		size++;
		}
	}
	public int size(){
		return this.size;
	}
	public T deQueue(){
		if(this.isEmpty()){
			throw new RuntimeException("Queue underflow bbb");
		}else{
			Node node = this.head;
			this.head = this.head.getNext();
			size--;
			return node.getCurrent();
		}
	}
	public Node temp = this.head;
	public void search(){
		
		this.isInQueue(temp.getCurrent());
		
	}
public boolean isInQueue(T v){
		for(int i = 0;i<size;i++){
			if(v == temp.getCurrent()){
				return true;
			}else{
				temp = temp.getNext();
				continue;
			}
		}
		return false;
	}
	public T peek(){
		if(this.isEmpty()){
			throw new RuntimeException("Queue underflow aaa");
		}else{
		return this.head.getCurrent();
		}
	}
	public static void main(String[] args){
		Queue<String> q = new Queue<String>();
		String t1 = "1";
		String t2 = "2";
		String t3 = "3";
		String t4 = "4";
		String t5 = "5";
		q.enQueue(t1);
		q.enQueue(t2);
		q.enQueue(t3);
		q.enQueue(t4);
		q.enQueue(t5);
		System.out.println(q);
		System.out.println(q.peek());
		}
}
