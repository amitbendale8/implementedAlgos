package com.algos;

public class QuickSortAndPartition {

	public static void main(String[] args) {
		int[] input={3, 1, 4, 5, 9, 2, 6, 8, 7};
		
		input = quicksort(input,0,input.length-1);
		System.out.println("Done");
		System.out.println(input.toString());

	}

	private static int[] quicksort(int[] input,int start,int end) {
		if(end-start >= 1){
			int p = partition(input,start);
			quicksort(input,start,p-1);
			quicksort(input,p+1,end);
		}
		
		return input;
		
	}

	private static int partition(int[] input, int index) {
		int currentVal = input[index];
		int currentReplaceIndex = index;
		int replaceIndex = index;
		
		
		for(int i=index+1;i<input.length;i++){
			if(input[i] < currentVal ){
				swap(input,currentReplaceIndex,i);
				currentReplaceIndex++;
				replaceIndex = i;
			}
		}
		if(input[currentReplaceIndex] > input[replaceIndex]){
			swap(input,currentReplaceIndex,replaceIndex);
		}
		return currentReplaceIndex;
	}
	
	/**
	 * Swap without third variable
	 * @param input
	 * @param a
	 * @param b
	 */
	private static void swap(int[] input, int a, int b) {
		input[a] = input[a] + input[b];
		input[b] = input[a] - input[b];
		input[a] = input[a] - input[b];
	}

}
