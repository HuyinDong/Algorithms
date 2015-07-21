package com.alg.basic;

public class Fib {
	public void print(int num){
		printFib(1,1,num);
	}
	public int printFib(int m, int n, int num){
		int temp = 0;
		if(num == 1){
			return 1;
		}else{
		temp = m;
		System.out.print(m+" ");
		num--;
		return printFib(n,temp+n,num);
		}
	}
	public static void main(String[] args){
		Fib f = new Fib();
		f.print(10);
	}
}
