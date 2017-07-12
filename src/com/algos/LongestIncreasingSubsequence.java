package com.algos;

import java.util.Scanner;

/**
 * 
 * @author amit.bendale
 *Find the longest subsequence in an array.
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		int[] input = new int[size];
		for(int i=0;i<size;i++){
			input[i] = sc.nextInt();
		}
		System.out.println(LCS(input));

	}

	private static int LCS(int[] input) {
		int[] indexOfLeastNumber = new int[input.length+1];
		int[] predecessor = new int[input.length];
		int currentLongestLenght = 0;
		int longestLength = 0;
		for(int i=0;i<input.length;i++){
			int low = 1;
			int high = longestLength;
			while(low <= high){
				int middle = (int)Math.ceil((low+high)/2);
				if(input[i] > input[indexOfLeastNumber[middle]]){
					low = middle + 1;
				}else {
					high = middle - 1;
				}
			}
			currentLongestLenght = low;
			indexOfLeastNumber[currentLongestLenght] = i;
			if(currentLongestLenght > longestLength){
				longestLength = currentLongestLenght;
			}
		}
		return longestLength;
	}

}
