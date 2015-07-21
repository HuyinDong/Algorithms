package com.alg.basic;

public class Stack<T>{
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
	private Node head;
	private int len;
	

	private int getLen() {
		return len;
	}
     


	public Stack() {
		super();
	}
    public boolean isEmpty(){
    	return head == null;
    }
	public int size(){
		return this.getLen();
	}
	public void push(T t){
		Node temp = this.head;
		Node node = new Node();
		node.setCurrent(t);
		this.head = node;
		node.setNext(temp);
		len++;
	}
	public T pop(){
		if(this.isEmpty()){
			throw new RuntimeException("Stack underflow asdf");
		}else{
		T t = this.head.getCurrent();
		this.head = this.head.getNext();
		len--;
		return t;
		}
	}
	public T peek(){
		if(this.isEmpty()){
			throw new RuntimeException("Stack underflow11111111");
		}else{
		return this.head.getCurrent();
		}
	}
	
	@Override
	public String toString() {
		return "Stack [head=" + head + ", len=" + len + "]";
	}

	public static void main(String[] args){
		Stack<String> stack = new Stack<String>();
		String t1 = "1";
		String t2 = "2";
		String t3 = "3";
		String t4 = "4";
		stack.push(t1);
		stack.push(t2);
		stack.push(t3);
		stack.push(t4);
		System.out.println(stack);
		while(stack.size()>0){
			System.out.println("Head is "+stack.peek()+", Length is "+ stack.size());
			stack.pop();
		}
	}
}
