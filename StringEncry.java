package com.alg.basic;

import java.util.Scanner;

public class StringEncry {
	public static void main(String[] args){
		System.out.println("Please type in the sentence:");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		char[] str = input.toCharArray();
		for(char s : str){
			if(65<=s && s<90 || 97<=s && s<122){
				s+=1;
			}else if(s == 90){
				s = 'A';
			}else if(s == 122){
				s = 'a';
			}else{
				
			}
			
			System.out.print(s);
			
		}
		sc.close();
	}
}
