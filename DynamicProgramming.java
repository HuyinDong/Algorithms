package com.alg.basic;

public class DynamicProgramming {
	public static void main(String[] args){
		DynamicProgramming dp = new DynamicProgramming();
		int[] arr = new int[]{3,2,1,5,7,4,9,8};
		dp.dp(arr);
	}
	public void dp(int[] arr){
		int[] temp = new int[arr.length];
		int i = 1;
		int len = 1;
		for(;i < arr.length;i++){
			if(temp[len-1]>arr[i]){
				temp[len-1] = arr[i];
				
			}else{
				temp[len] = arr[i];
				len++;
			}
		}
		for( int k : temp){
			System.out.print(k+",");
		}
	}
}
