package com.alg.basic;

public class InsertionSort {
	public static void main(String[] args){
		int[] arr = new int[]{2,4,7,5,6,1,8,9};
		new InsertionSort().insertionSort(arr);
		for(int i : arr){
			System.out.print(i+",");
		}
	}
	public void insertionSort(int[] arr){
		int temp = 0;
		for(int i = 1; i<arr.length;i++){
			for(int j = i; j > 0; j--)
			if(arr[j-1]>arr[j]){
				temp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = temp;
			}
		}
	}
}
