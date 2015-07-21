package com.alg.basic;

public class CountingSort {
	public static void main(String[] args){
		CountingSort cs = new CountingSort();
		int[] arr = new int[]{2,5,3,0,2,3,0,3};
		arr = cs.countingSort(arr);
		for(int i : arr){
			System.out.print(i+",");
		}
	}
	public int[] countingSort(int[] arr){
		
		int max = arr[0];
		for(int i = 1;i<arr.length;i++){
			if(max<arr[i]){
				max = arr[i];
			}
		}
		//get the biggest number in arr, max
		int[] temp = new int[max+1];
		//creating an array, which length is max+1
		for(int i = 0; i<arr.length;i++){
			temp[arr[i]]++;
		}
		//counting the numbers in arr, in this example 
		for(int i = 1; i < temp.length;i++){
			temp[i] = temp[i]+temp[i-1];
		}
		// temp is gonna be [2,2,4,7,7,8]
		int[] result = new int[arr.length];
		for(int i = arr.length-1; i>=0;i-- ){
			result[temp[arr[i]]-1] = arr[i];
			temp[arr[i]] = temp[arr[i]]-1;
		}
	/*
	 * I think this is somewhat to understand of this part.
	 * The process is traversal the arr, and the final position is 
	 * in the temp, for example, traversal from the end 
	 * 3, in the temp, 3 is mapping to 7, so it should be in the 7th
	 * position in the final arr, then 7-1, because the next 3 is gonna
	 * be at 7-1 position. The next number is 0, it's mapping to 2, so
	 * its final position is 2nd, then 2-1, means the next 2 is in the 
	 * 1st position 
	 */
		return result;
	}
}
