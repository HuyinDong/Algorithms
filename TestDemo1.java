package com.alg.basic;

import java.util.ArrayList;

class Point{
	ArrayList<Point> next;
	String name;
	public Point(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return "Point [name=" + name + "]";
	}
	
}
public class TestDemo1 {
	public Point current;
	
	public static void main(String[] args){
		Stack<Point> stack = new Stack<Point>();
		stack.push(new Point("A"));
		stack.push(new Point("B"));
		stack.push(new Point("C"));
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
	}
	
}
