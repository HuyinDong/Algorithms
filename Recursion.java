package com.alg.basic;

public class Recursion {
	int sum;
	public static void main(String[] args){
		Recursion r = new Recursion();
		int t = r.factorial(10);
		System.out.print("="+t);
	}
	public int factorial(int i){
		if(i ==1){
			System.out.print(i);
			return 1;
		}
		System.out.print(i+"*");
		return i*factorial(--i);
		
	}
}
