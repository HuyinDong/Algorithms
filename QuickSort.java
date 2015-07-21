package com.alg.basic;
	
		public class QuickSort {
			public static void main(String[] args){
				int[] arr1 = new int[]{2,8,7,1,3,5,6,4};
				int[] arr = new int[]{4,3,7,1,2,8,5,15,13,12,18,15,33};
				new QuickSort().qkSort(arr);
				for(int i : arr){
					System.out.print(i+",");
				}
			}
			public void qkSort(int[] arr){
				this.sort(arr, 0, arr.length-1);
			}
			public void sort(int[] arr, int p, int r){
				if(p<r){
					int q = this.partition(arr, p, r);
					this.sort(arr, p, q-1);
					this.sort(arr, q+1, r);
				}
			}
			public int partition(int[] arr, int p, int r){
				int i = p-1;
				int j = p;
				int temp = 0;
				int x = arr[r];
				for(;j<r;j++){
					if(arr[j] < x){
						i++;
						temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
					}
				}
				temp = arr[r];
				arr[r] = arr[i+1];
				arr[i+1] = temp;
				return i+1;
			}
		}
