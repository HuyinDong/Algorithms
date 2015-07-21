package com.alg.basic;

public class BubbleSort {
	public static void main(String[] args){
		int[] arr = new int[]{2,4,7,5,6,1,8,9};
		new BubbleSort().bubble(arr);
		for(int i : arr){
			System.out.print(i+",");
		}
	}
	public void bubble(int[] arr){
		int len = arr.length;
		int temp = 0;
		for(int i = len-1;i>=1;i--){
			for(int j = len-2; j>=0;j--){
				if(arr[j+1]<arr[j]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}