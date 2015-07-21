package com.alg.basic;

public class MergeSort {
	public static void main(String[] args){
		MergeSort ms = new MergeSort();
		int[] arr = new int[]{7,6,4,1,9,2,11,13,5,81,22,4,14,16,20,19};
		ms.mergeSort(arr);
		for(int m : arr){
			System.out.print(m + ",");
		}
		System.out.println();
	}
	public void mergeSort(int[] arr){
		this.sort(arr, 0, (arr.length-1));
	}
	public void sort(int[] arr, int p ,int r){
		if(p<r){
			int q = (r+p)/2+1;									//q means the middle index
			sort(arr,p,q-1);
			sort(arr,q,r);
			merge(arr,p,q,r);
		}
	}
	public void merge(int[] arr, int p, int q, int r){
		int n1 = q-p;
		int n2 = r-q+1;
		int[] L = new int[n1];									// array is divided into two parts
		int[] R = new int[n2];									// each of them is given to L and R
		for(int i = 0;i<n1;i++){								
			L[i] = arr[p+i];
		}
		for(int j = 0; j<n2; j++){
			R[j] = arr[q+j];
		}
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < n1 && j < n2){								// merge two arrays in order
			if(L[i]<R[j]){
				arr[k+p] = L[i];
				i++;
				k++;
			}else{
				arr[k+p] = R[j];
				j++;
				k++;
			}
		}
			 while(i < n1){								// one array is merged while another
			    	arr[k+p] = L[i];							// one still has elements unmerged
					i++;										// merge the rest of them to the original
					k++;										// array
			    }
			    while(j < n2){
			    	arr[k+p] = R[j];
			    	k++;
					j++;
			    }
	}
}
